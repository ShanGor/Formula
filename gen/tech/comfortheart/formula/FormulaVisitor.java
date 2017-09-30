// Generated from C:/temp/formula/src/main/resources\Formula.g4 by ANTLR 4.7
package tech.comfortheart.formula;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormulaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormulaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(FormulaParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(FormulaParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddMinus}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddMinus(FormulaParser.AddMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative(FormulaParser.NegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(FormulaParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivMod(FormulaParser.MultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(FormulaParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(FormulaParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(FormulaParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(FormulaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParentheses}
	 * labeled alternative in {@link FormulaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentheses(FormulaParser.ExprParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionJointAndOr}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionJointAndOr(FormulaParser.ConditionJointAndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionExpr}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(FormulaParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionJointNot}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionJointNot(FormulaParser.ConditionJointNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionParentheses}
	 * labeled alternative in {@link FormulaParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionParentheses(FormulaParser.ConditionParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(FormulaParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#paramsDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsDef(FormulaParser.ParamsDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(FormulaParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#functionPredefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPredefinition(FormulaParser.FunctionPredefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#paramsPredefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsPredefine(FormulaParser.ParamsPredefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#functionInvoke}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvoke(FormulaParser.FunctionInvokeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(FormulaParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(FormulaParser.ParamContext ctx);
}