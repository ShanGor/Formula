package tech.comfortheart.formula;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 43391554 on 2017/8/29.
 */
public class FunctionDefinition {
    private String name;
    private List<String> parameter;
    private Stack callingStack;
    private FormulaParser.ExprContext bodyContext;

    public FunctionDefinition(String name) {
        parameter = new LinkedList<>();
        this.name = name;
    }

    public FunctionDefinition addParam(String parameterName) {
        this.parameter.add(parameterName);
        return this;
    }

    public FunctionDefinition pushStack(Object obj) {
        if(callingStack == null) {
            callingStack = new Stack();
        }
        callingStack.push(obj);
        return this;
    }

    /**
     * If the calling stack is not empty, return true;
     * @return
     */
    public boolean hasStackElement() {
        if(callingStack==null || callingStack.empty()) {
            return false;
        }
        return true;
    }

    /**
     * Pop an element from the calling stack.
     * @return
     */
    public Object popStack() {
        if(callingStack==null || callingStack.empty()) {
            return null;
        }

        return callingStack.pop();
    }

    public List<String> getParameter() {
        return this.parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParameter(List<String> parameter) {
        this.parameter = parameter;
    }

    public Stack getCallingStack() {
        return callingStack;
    }

    public void setCallingStack(Stack callingStack) {
        this.callingStack = callingStack;
    }

    public FormulaParser.ExprContext getBodyContext() {
        return bodyContext;
    }

    public void setBodyContext(FormulaParser.ExprContext bodyContext) {
        this.bodyContext = bodyContext;
    }
}
