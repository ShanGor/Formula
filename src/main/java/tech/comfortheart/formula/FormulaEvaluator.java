package tech.comfortheart.formula;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import tech.comfortheart.formula.exceptions.InvalidFormulaException;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 43391554 on 2017/8/29.
 */
public class FormulaEvaluator extends FormulaBaseListener {
    ParseTreeProperty<Object> exprValues;
    ParseTreeProperty<String> strings = new ParseTreeProperty<>();
    ConcurrentHashMap<String, Object> variables;
    ConcurrentHashMap<String, FunctionDefinition> functions = new ConcurrentHashMap<>();

    String currentFunctionName = null;
    FunctionDefinition currentFunctionDefinition = null;

    public FormulaEvaluator() {
        exprValues = new ParseTreeProperty<>();
        variables = new ConcurrentHashMap<>();
    }

    public FormulaEvaluator(final Map<String, BigDecimal> requestValues) {
        exprValues = new ParseTreeProperty<>();
        variables = new ConcurrentHashMap<>(requestValues);
    }

    /**
     * Do math 'add' or 'minus' (subtraction)
     *
     * @param ctx
     */
    @Override
    public void exitAddMinus(FormulaParser.AddMinusContext ctx) {
        Object left = exprValues.get(ctx.expr(0));
        Object right = exprValues.get(ctx.expr(1));
        if(!(left instanceof BigDecimal) || !(right instanceof BigDecimal)) {
            throw new InvalidFormulaException("Invalid operation for non-numeric variables: " + ctx.getText());
        }

        if(ctx.ADD() != null) {
            exprValues.put(ctx, ((BigDecimal)left).add((BigDecimal)right));
        } else if (ctx.SUB() != null){
            exprValues.put(ctx, ((BigDecimal)left).subtract((BigDecimal)right));
        } else
            throw new RuntimeException("Unknown operator: " + ctx.getText());

        super.exitAddMinus(ctx);
    }

    /**
     * Put the number as negative number
     */
    @Override
    public void exitNegative(FormulaParser.NegativeContext ctx) {
        exprValues.put(ctx, ((BigDecimal)exprValues.get(ctx.NUMBER())).negate());
        super.exitNegative(ctx);
    }

    /**
     * Put the number to the dictionary.
     *
     * @param ctx
     */
    @Override
    public void exitNumber(FormulaParser.NumberContext ctx) {
        exprValues.put(ctx, new BigDecimal(ctx.NUMBER().getText()));
        super.exitNumber(ctx);
    }

    @Override
    public void exitString(FormulaParser.StringContext ctx) {
        strings.put(ctx, ctx.STRING().getText());
    }

    /**
     * Do the math for 'multiply', 'divide' or mod.
     *
     * @param ctx
     */
    @Override
    public void exitMultDivMod(FormulaParser.MultDivModContext ctx) {
        BigDecimal left = (BigDecimal) exprValues.get(ctx.expr(0));
        BigDecimal right = (BigDecimal) exprValues.get(ctx.expr(1));
        if(ctx.MUL() != null) {
            exprValues.put(ctx, left.multiply(right));
        } else if (ctx.DIV() != null){
            exprValues.put(ctx, left.divide(right, 21, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
        } else if(ctx.MOD() != null) {
            exprValues.put(ctx, left.remainder(right));
        } else
            throw new RuntimeException("Unknown operator: " + ctx.getText());

        super.exitMultDivMod(ctx);
    }

    @Override
    public void enterFunctionInvoke(FormulaParser.FunctionInvokeContext ctx) {
        String functionName = ctx.ID().getText();
        FunctionDefinition functionDefinition = functions.get(functionName);
        if(functionDefinition == null) {
            throw new InvalidFormulaException("Function invoke before definition: " + functionName);
        }
        currentFunctionDefinition = functionDefinition;
        currentFunctionName = functionName;
    }

    @Override
    public void exitFunctionInvoke(FormulaParser.FunctionInvokeContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitPow(FormulaParser.PowContext ctx) {
        BigDecimal left = (BigDecimal) exprValues.get(ctx.expr(0));
        BigDecimal right = (BigDecimal) exprValues.get(ctx.expr(1));
        if(ctx.POW() != null) {
            exprValues.put(ctx, left.pow(right.intValue()));
        } else
            throw new RuntimeException("Unknown operator: " + ctx.getText());

        super.exitPow(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitId(FormulaParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if(variables.containsKey(ctx.ID().getText()))
            exprValues.put(ctx, variables.get(id));
        else
            throw new RuntimeException("Identifier does not exist: " + id);
        super.exitId(ctx);
    }


    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitStat(FormulaParser.StatContext ctx) {
        if(ctx.ID() != null) {
            variables.put(ctx.ID().getText(), exprValues.get(ctx.expr()));
        }

        super.exitStat(ctx);
    }

    public Object getVariable(String id) {
        return variables.get(id);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitExprParentheses(FormulaParser.ExprParenthesesContext ctx) {
        exprValues.put(ctx, exprValues.get(ctx.expr()));
        super.exitExprParentheses(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitConditionJointAndOr(FormulaParser.ConditionJointAndOrContext ctx) {
        Boolean left;
        Boolean right;
        try{
            left  = (Boolean) exprValues.get(ctx.condition(0));
            right = (Boolean) exprValues.get(ctx.condition(1));
        } catch (ClassCastException e) {
            throw new InvalidFormulaException("Invalid operation on non-boolean variables: " + ctx.getText());
        }

        String token = ctx.children.get(1).getText();
        if(token.equals("and")) {
            exprValues.put(ctx, left && right);
        } else if(token.equals("or")) {
            exprValues.put(ctx, left || right);
        } else {
            throw new InvalidFormulaException("Unknown condition operator: " + ctx.getText());
        }
    }

    @Override
    public void exitConditionExpr(FormulaParser.ConditionExprContext ctx) {
        Object left = exprValues.get(ctx.expr(0));
        Object right = exprValues.get(ctx.expr(1));
        if(ctx.EQ() != null) {
            if(left instanceof BigDecimal && right instanceof BigDecimal) {
                exprValues.put(ctx, ((BigDecimal)left).compareTo((BigDecimal)right) == 0);
            } else {
                exprValues.put(ctx, left.equals(right));
            }
        } else if(ctx.GT() != null) {
            if(left instanceof BigDecimal && right instanceof BigDecimal) {
                exprValues.put(ctx, ((BigDecimal)left).compareTo((BigDecimal)right) > 0);
            } else {
                throw new InvalidFormulaException("Invalid comparison for non-numeric expression: " + ctx.getText());
            }
        } else if(ctx.GE() != null) {
            if(left instanceof BigDecimal && right instanceof BigDecimal) {
                exprValues.put(ctx, ((BigDecimal)left).compareTo((BigDecimal)right) >= 0);
            } else {
                throw new InvalidFormulaException("Invalid comparison for non-numeric expression: " + ctx.getText());
            }
        } else if(ctx.LE() != null) {
            if(left instanceof BigDecimal && right instanceof BigDecimal) {
                exprValues.put(ctx, ((BigDecimal)left).compareTo((BigDecimal)right) <= 0);
            } else {
                throw new InvalidFormulaException("Invalid comparison for non-numeric expression: " + ctx.getText());
            }
        } else if(ctx.LT() != null) {
            if(left instanceof BigDecimal && right instanceof BigDecimal) {
                exprValues.put(ctx, ((BigDecimal)left).compareTo((BigDecimal)right) < 0);
            } else {
                throw new InvalidFormulaException("Invalid comparison for non-numeric expression: " + ctx.getText());
            }
        } else if(ctx.NE() != null) {
            if(left instanceof BigDecimal && right instanceof BigDecimal) {
                exprValues.put(ctx, ((BigDecimal)left).compareTo((BigDecimal)right) != 0);
            } else {
                exprValues.put(ctx, !left.equals(right));
            }
        } else {
            throw new InvalidFormulaException("Unknown condition expression: " + ctx.getText());
        }
    }

    @Override
    public void exitConditionJointNot(FormulaParser.ConditionJointNotContext ctx) {
        exprValues.put(ctx, !(Boolean) exprValues.get(ctx.condition()));
    }

    @Override
    public void exitConditionParentheses(FormulaParser.ConditionParenthesesContext ctx) {
        exprValues.put(ctx, exprValues.get(ctx.condition()));
    }

    @Override
    public void exitParamsDef(FormulaParser.ParamsDefContext ctx) {
        String functionName = currentFunctionName;
        currentFunctionDefinition = new FunctionDefinition(functionName);
        ctx.ID().forEach(id -> {
            currentFunctionDefinition.addParam(id.getText());
        });
        super.exitParamsDef(ctx);
    }

    @Override
    public void enterFunctionDefinition(FormulaParser.FunctionDefinitionContext ctx) {
        if(ctx.paramsDef() == null) {
            throw new InvalidFormulaException("The parameter of function cannot be null: " + ctx.ID().getText());
        }
        //functionNames.put(ctx, ctx.ID().getText());
        currentFunctionName = (ctx.ID().getText());
        super.enterFunctionDefinition(ctx);
    }

    @Override
    public void enterFunctionBody(FormulaParser.FunctionBodyContext ctx) {
        currentFunctionDefinition.setBodyContext(ctx.expr());

        // Put the function to the function dictionary
        functions.put(currentFunctionName, currentFunctionDefinition);

        // Remove the expr from the function body, to avoid the traversing to the expr.
        ctx.removeLastChild(); // function body only has one child, that is expr.
        super.enterFunctionBody(ctx);
    }

    @Override
    public void exitFunctionPredefinition(FormulaParser.FunctionPredefinitionContext ctx) {
        super.exitFunctionPredefinition(ctx);
    }

    @Override
    public void exitParamsPredefine(FormulaParser.ParamsPredefineContext ctx) {
        super.exitParamsPredefine(ctx);
    }

    @Override
    public void exitParams(FormulaParser.ParamsContext ctx) {
        ctx.param().forEach(param -> {

        });
    }

    @Override
    public void enterParams(FormulaParser.ParamsContext ctx) {
        List<FunctionParameter> parameters = new LinkedList<>();
        ctx.param().forEach(param -> {
            parameters.add(getParam(param));
        });
        ctx.children.clear();
    }

    @Override
    public void enterParam(FormulaParser.ParamContext ctx) {
        throw new InvalidFormulaException("You are not supposed to see me! The parent should has cleared the children at enterParams()!");
    }

    public FunctionParameter getParam(FormulaParser.ParamContext ctx) {
        FunctionParameter parameter = new FunctionParameter();

        if(ctx.expr() != null) {
            parameter.type = FunctionParameter.TYPE_NUMBER;
            parameter.value = exprValues.get(ctx.expr());
        } else if (ctx.condition() != null) {
            parameter.type = FunctionParameter.TYPE_CONDITION;
            parameter.value = exprValues.get(ctx.condition());
        } else {
            throw new InvalidFormulaException("Unknown parameter type: " + ctx.getText());
        }
        parameter.name = currentFunctionName;
        return parameter;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        throw new InvalidFormulaException(node.getText());
    }
}
