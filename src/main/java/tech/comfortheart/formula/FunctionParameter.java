package tech.comfortheart.formula;

import tech.comfortheart.formula.exceptions.InvalidFormulaException;

public class FunctionParameter {
    public static final int TYPE_NUMBER = 0;
    public static final int TYPE_CONDITION = 1;

    int type = -1;
    String name;
    Object value;

}
