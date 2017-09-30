/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2017. . ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */

package tech.comfortheart.formula;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * I found that the visitor mode is not efficiency. Because when you invoke
 * the 'visit' to visit sub-trees, it will invoke them twice or more..
 *
 * Created by 43391554 on 2017/8/28.
 */
public class EvalVisitor extends FormulaBaseVisitor<String> {
    public static final BigDecimal NEGATIVE_ONE = new BigDecimal("-1");

    ParseTreeProperty<BigDecimal> numbers = new ParseTreeProperty<>();

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFormula(FormulaParser.FormulaContext ctx) {
        return super.visitFormula(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAddMinus(FormulaParser.AddMinusContext ctx) {
//        BigDecimal result;
//        ParseTree left = ctx.expr(0);
//        ParseTree right = ctx.expr(1);
//        if(ctx.ADD() != null) {
//            result = exprValues.get(left).add(exprValues.get(right));
//        } else if(ctx.MINUS() != null) {
//            result = exprValues.get(left).subtract(exprValues.get(right));
//        } else {
//            throw new RuntimeException("Unknown operator: " + ctx.getText());
//        }
//        exprValues.put(ctx, result);
        return super.visitAddMinus(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNegative(FormulaParser.NegativeContext ctx) {
//        BigDecimal decimal = new BigDecimal(ctx.NUMBER().toString()).negate();
//        exprValues.put(ctx, decimal);
//
//        System.out.println(exprValues.get(ctx));
        return ctx.NUMBER().toString();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNumber(FormulaParser.NumberContext ctx) {
        //exprValues.put(ctx, new BigDecimal(ctx.getText()));
        System.out.println(ctx.NUMBER().getText());
        return ctx.NUMBER().getText();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultDivMod(FormulaParser.MultDivModContext ctx) {
        ParseTree left = ctx.expr(0);
        ParseTree right = ctx.expr(1);
        visit(left);
        visit(right);

//        if(ctx.MULT() != null) {
//            result = exprValues.get(left).multiply(exprValues.get(right));
//            exprValues.put(ctx, result);
//
//        }
//
//        System.out.print(ctx.getText() + ": ");
//        System.out.println(exprValues.get(ctx));
        //System.out.println(ctx.MULT().getText());
        return super.visitMultDivMod(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionCall(FormulaParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPow(FormulaParser.PowContext ctx) {
        return super.visitPow(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitId(FormulaParser.IdContext ctx) {
        return super.visitId(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitString(FormulaParser.StringContext ctx) {
        return super.visitString(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExprParentheses(FormulaParser.ExprParenthesesContext ctx) {
        //exprValues.put(ctx, exprValues.get(ctx.expr()));
        return super.visitExprParentheses(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConditionJointAndOr(FormulaParser.ConditionJointAndOrContext ctx) {
        return super.visitConditionJointAndOr(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConditionExpr(FormulaParser.ConditionExprContext ctx) {
        return super.visitConditionExpr(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConditionJointNot(FormulaParser.ConditionJointNotContext ctx) {
        return super.visitConditionJointNot(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConditionParentheses(FormulaParser.ConditionParenthesesContext ctx) {
        return super.visitConditionParentheses(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionDefinition(FormulaParser.FunctionDefinitionContext ctx) {
        return super.visitFunctionDefinition(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitParamsDef(FormulaParser.ParamsDefContext ctx) {
        return super.visitParamsDef(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionPredefinition(FormulaParser.FunctionPredefinitionContext ctx) {
        return super.visitFunctionPredefinition(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitParamsPredefine(FormulaParser.ParamsPredefineContext ctx) {
        return super.visitParamsPredefine(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionInvoke(FormulaParser.FunctionInvokeContext ctx) {
        return super.visitFunctionInvoke(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitParams(FormulaParser.ParamsContext ctx) {
        return super.visitParams(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStat(FormulaParser.StatContext ctx) {
        return super.visitStat(ctx);
    }

}
