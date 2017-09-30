package tech.comfortheart.formula.exceptions;

public class InvalidFormulaException extends RuntimeException {
    public InvalidFormulaException(String msg) {
        super(msg);
    }

    public InvalidFormulaException(Exception e) {
        super(e);
    }
}
