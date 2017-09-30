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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import tech.comfortheart.formula.exceptions.InvalidFormulaException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by 43391554 on 2017/8/29.
 */
public class FormulaEvaluatorTest {
    @Test
    public void testFormula() {
        CharStream input = CharStreams.fromString("x = 2 * (3 + 4 + 5) + 120/5");
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);
        ParseTree tree = parser.formula();
        ParseTreeWalker walker = new ParseTreeWalker();
        FormulaEvaluator evalVisitor = new FormulaEvaluator();
        walker.walk(evalVisitor, tree);
        System.out.println(evalVisitor.getVariable("x"));
    }

    @Test
    public void testId() {
        String[] sourceLines = {
                "y=(x+1)^2",
                "z = y + 3"
        };
        String source =String.join("\n", sourceLines);
        long initTime = System.nanoTime();
        CharStream input = CharStreams.fromString(source);
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);
        ParseTree tree = parser.formula();
        ParseTreeWalker walker = new ParseTreeWalker();

        Map<String, BigDecimal> requestValues = new HashMap<>();
        requestValues.put("x", new BigDecimal("11"));
        FormulaEvaluator evalVisitor = new FormulaEvaluator(requestValues);
        walker.walk(evalVisitor, tree);
        System.out.println("y=" + evalVisitor.getVariable("y"));
        System.out.println("z=" + evalVisitor.getVariable("z"));

        long startTime = System.nanoTime();
        for(int i=0; i<10; i++) {
            requestValues.put("x", new BigDecimal(i));
            evalVisitor = new FormulaEvaluator(requestValues);
            walker.walk(evalVisitor, tree);
            System.out.println("y=" + evalVisitor.getVariable("y"));
            System.out.println("z=" + evalVisitor.getVariable("z"));
        }
        long endTime = System.nanoTime();

        System.out.println("Total time: " + (endTime-initTime)/1000_000_000.0 + " secornds");
        System.out.println("Looping time: " + (endTime-startTime)/1000_000_000.0 + " secornds");
    }

    //@Test
    public void testIdWithVolumn() {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setMaxPoolSize(2);
        //executorService.setCorePoolSize(10);
        executorService.initialize();

        String[] sourceLines = {
                "y=(x+1)*2 + 43/32",
                "z = (y + 3) * 32"
        };
        String source =String.join("\n", sourceLines);
        long initTime = System.nanoTime();
        CharStream input = CharStreams.fromString(source);
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);
        ParseTree tree = parser.formula();
        ParseTreeWalker walker = new ParseTreeWalker();
        ConcurrentHashMap<String, Object> result = new ConcurrentHashMap<>();

        //Map<String, BigDecimal> requestValues = new HashMap<>();

        long startTime = System.nanoTime();
        for(int i=0; i<2_000_000; i++) {
            final int x = i;
            executorService.execute(()-> {
                Map<String, BigDecimal> requestValues = new HashMap<>();
                requestValues.put("x", new BigDecimal(x));
                FormulaEvaluator evalVisitor = new FormulaEvaluator(requestValues);
                walker.walk(evalVisitor, tree);
                result.put("y"+x, evalVisitor.getVariable("y"));
            });
        }

        while (executorService.getActiveCount() > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();

        System.out.println("y" + 1_000_000 + ": " + result.get("y" + 1_000_000));
        System.out.println("expected result: " + (1_000_000+1)*2 + 43/32.0);
        System.out.println("Total time: " + (endTime-initTime)/1000_000_000.0 + " secornds");
        System.out.println("Looping time: " + (endTime-startTime)/1000_000_000.0 + " secornds");
    }

    @Test
    public void testFunctionBody() {
        String source = "f(x, y) = x + y\nf1(x)=x+1";
        CharStream input = CharStreams.fromString(source);
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);
        ParseTree tree = parser.formula();
        ParseTreeWalker walker = new ParseTreeWalker();
        Map<String, BigDecimal> requestValues = new HashMap<>();
        FormulaEvaluator evalVisitor = new FormulaEvaluator(requestValues);
        walker.walk(evalVisitor, tree);
        assert evalVisitor.functions.get("f").getParameter().get(0).toString().equals("x");
        assert evalVisitor.functions.get("f1").getBodyContext().getText().equals("x+1");

        // Negative testing, no parameter for the function, that is illegal.
        source = "f() = x + y\n";
        input = CharStreams.fromString(source);
        lexer = new FormulaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new FormulaParser(tokens);
        tree = parser.formula();
        walker = new ParseTreeWalker();
        evalVisitor = new FormulaEvaluator(requestValues);
        try {
            walker.walk(evalVisitor, tree);
            fail();
        } catch (InvalidFormulaException e) {
            assertEquals(e.getMessage(), "The parameter of function cannot be null: f");
        }
    }

    @Test
    public void testErrorInput() {
        try {
            String source = "f(x,) = x + y\n";
            CharStream input = CharStreams.fromString(source);
            FormulaLexer lexer = new FormulaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FormulaParser parser = new FormulaParser(tokens);
            ParseTree tree = parser.formula();
            ParseTreeWalker walker = new ParseTreeWalker();
            Map<String, BigDecimal> requestValues = new HashMap<>();
            FormulaEvaluator evalVisitor = new FormulaEvaluator(requestValues);
            walker.walk(evalVisitor, tree);
            fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert e.getMessage().equals("<missing ID>");
        }
    }

    @Test
    public void testConditionAndOr() {
        try {
            String source = "f(x) = x + 1\nz = f(1==2 and 2==3) + 1\n";
            CharStream input = CharStreams.fromString(source);
            FormulaLexer lexer = new FormulaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FormulaParser parser = new FormulaParser(tokens);
            ParseTree tree = parser.formula();
            ParseTreeWalker walker = new ParseTreeWalker();
            Map<String, BigDecimal> requestValues = new HashMap<>();
            FormulaEvaluator evalVisitor = new FormulaEvaluator(requestValues);
            walker.walk(evalVisitor, tree);
            fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert e.getMessage().equals("Invalid operation for non-numeric variables: f()+1");
        }
    }
}
