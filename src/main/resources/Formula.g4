grammar Formula;

/*
# Data Types
  There are 3 types of data:
  NUMBER
  STRING
  BOOLEAN (Only produced from condition)

# Priority control
  Use the () to group them if you are not sure about the priority

# Logical Operators
  Priority: 'not' -> ('>' '<' '>=' '<=' '==' '<>') -> ('and' | 'or')
  >                              - Greater than
  <                              - Less than
  >=                             - Greater than or equal to
  <=                             - Less than or equal to
  ==                             - Equal
  <>                             - Not equal
  not <condition>                - Opposite value for the condition
  condition (and|or) condition   - joint the conditions

# Calculation Operators
  -           - Negative                     (Priority the first)
  ^           - Power                        (Priority the second)
  *           - Multiply                     (Priority the third)
  /           - Divided                      (Priority the third)
  %           - Mod                          (Priority the third)
  +           - Plus                         (Priority the 4th)
  -           - Minus                        (Priority the 4th)
# Recursive Formula
  Given such a scenario
    fact(1) = 1
    fact(x) = x * fact(x-1)
  The invokation for f(4) would generate such a result list:
    fact(1) = 1
    fact(2) = 2
    fact(3) = 6
    fact(4) = 24

 */

/* The start of the formula */
formula: stat+ ;

stat: ID '=' expr NEWLINE*
    | functionDefinition '=' functionBody NEWLINE* /* Like f(x) = a*x + b */
    | functionPredefinition '=' expr NEWLINE* /* Like f(1) = a + b, predefine some function value, to enable the recursive formula */
    ;

expr: '-' NUMBER               #Negative
    | expr POW expr            #Pow
    | expr (MUL|DIV|MOD) expr  #MultDivMod
    | expr (ADD|SUB) expr      #AddMinus
    | NUMBER                   #Number
    | ID                       #Id
    | STRING                   #String
    | functionInvoke           #functionCall
    | '(' expr ')'            #exprParentheses
    ;

condition: 'not' condition    #conditionJointNot
    | expr (LT|GT|LE|GE|EQ|NE) expr #conditionExpr
    | condition ('and'|'or') condition #conditionJointAndOr
    | '(' condition ')'       #conditionParentheses
    ;

/* Like f(x) = a*x + b */
functionDefinition: ID '(' paramsDef? ')' ;
paramsDef: ID (',' ID)* ;
functionBody: expr;

/* Like f(1) = a + b, predefine some function value, to enable the recursive formula */
functionPredefinition: ID '(' paramsPredefine ')' ;
paramsPredefine: (NUMBER|STRING) (',' (NUMBER|STRING))* ;

/* Invoke a function, at the right side of the '='; Like `myValue = f(4)` */
functionInvoke: ID '(' params ')' ;
params: param (',' param)* ;
param: expr|condition;

/* Identifier */
ID: [a-zA-Z]+([a-zA-Z0-9_])*
    ;

/* Number, both Integer and Float. But there is no minus with it, the negative sign is an operator in the expr */
NUMBER: [0-9]+('.'[0-9]+)?
    ;

/* String */
STRING: '\'' .*? '\'' /* There is no escape for this kind of string */
    | '"' ('\\"'|~'"')* '"' /* Use the '\' to escape the double-quote */
    ;

/* New line character, use new-line character to mark it */
NEWLINE: '\n' ;

/* Skip white spaces */
WS: [ \t\r]+ -> skip ;

POW: '^' ;
MUL: '*' ;
MOD: '%' ;
DIV: '/' ;
ADD: '+' ;
SUB: '-' ;

GT: '>';
GE: GT'=';
LT: '<';
LE: LT'=';
EQ: '==';
NE: '<>';
