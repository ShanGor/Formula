package tech.comfortheart.formula;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Samuel on 2017/9/2.
 */
@RestController
public class CalculateController {

    @RequestMapping(value = "/calc", method = {RequestMethod.POST})
    public Map<String, Object> calc(@RequestBody CalculateRequest request) {
        String source = request.getSource();
        Map<String, BigDecimal> requestValues = request.getNumericRequestValues();

        CharStream input = CharStreams.fromString(source);
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);
        ParseTree tree = parser.formula();
        ParseTreeWalker walker = new ParseTreeWalker();


        FormulaEvaluator evalVisitor = new FormulaEvaluator(requestValues);
        walker.walk(evalVisitor, tree);
        //System.out.println("Server: z is " + evalVisitor.getVariable("y"));
        return evalVisitor.variables;
    }

}
