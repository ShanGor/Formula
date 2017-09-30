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
import org.junit.Test;

import java.io.IOException;

/**
 * Created by 43391554 on 2017/8/28.
 */
public class EvalVisitorTest {
    @Test
    public void testFormula() throws IOException {
        // CharStream input = CharStreams.fromStream(this.getClass().getResourceAsStream("/t.expr"));
        CharStream input = CharStreams.fromString("x = 1 * (3 + 4 + 5)\n");
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);
        ParseTree tree = parser.formula();
        EvalVisitor evalVisitor = new EvalVisitor();
        evalVisitor.visit(tree);
    }
}
