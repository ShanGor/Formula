// Generated from C:/temp/formula/src/main/resources\Formula.g4 by ANTLR 4.7
package tech.comfortheart.formula;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormulaParser}.
 */
public interface FormulaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(FormulaParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(FormulaParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(FormulaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(FormulaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddMinus}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddMinus(FormulaParser.AddMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddMinus}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddMinus(FormulaParser.AddMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegative(FormulaParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegative(FormulaParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(FormulaParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(FormulaParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivMod(FormulaParser.MultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivMod(FormulaParser.MultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(FormulaParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(FormulaParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPow(FormulaParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPow(FormulaParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(FormulaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(FormulaParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(FormulaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(FormulaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParentheses}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParentheses(FormulaParser.ExprParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParentheses}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParentheses(FormulaParser.ExprParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionJointAndOr}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionJointAndOr(FormulaParser.ConditionJointAndOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionJointAndOr}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionJointAndOr(FormulaParser.ConditionJointAndOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionExpr}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionExpr(FormulaParser.ConditionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionExpr}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionExpr(FormulaParser.ConditionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionJointNot}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionJointNot(FormulaParser.ConditionJointNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionJointNot}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionJointNot(FormulaParser.ConditionJointNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionParentheses}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionParentheses(FormulaParser.ConditionParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionParentheses}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionParentheses(FormulaParser.ConditionParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(FormulaParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(FormulaParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#paramsDef}.
	 * @param ctx the parse tree
	 */
	void enterParamsDef(FormulaParser.ParamsDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#paramsDef}.
	 * @param ctx the parse tree
	 */
	void exitParamsDef(FormulaParser.ParamsDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(FormulaParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(FormulaParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#functionPredefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPredefinition(FormulaParser.FunctionPredefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#functionPredefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPredefinition(FormulaParser.FunctionPredefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#paramsPredefine}.
	 * @param ctx the parse tree
	 */
	void enterParamsPredefine(FormulaParser.ParamsPredefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#paramsPredefine}.
	 * @param ctx the parse tree
	 */
	void exitParamsPredefine(FormulaParser.ParamsPredefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#functionInvoke}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvoke(FormulaParser.FunctionInvokeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#functionInvoke}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvoke(FormulaParser.FunctionInvokeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(FormulaParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(FormulaParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(FormulaParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(FormulaParser.ParamContext ctx);
}