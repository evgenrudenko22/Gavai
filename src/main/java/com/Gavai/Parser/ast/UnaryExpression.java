package com.Gavai.Parser.ast;

import com.Gavai.lib.NumberValue;
import com.Gavai.lib.Value;

public class UnaryExpression implements Expression{

    public final Expression expr1;
    public final char operation;

    public UnaryExpression(char operation, Expression expr1) {
        this.operation = operation;
        this.expr1 = expr1;
    }

    @Override
    public Value eval() {
        switch (operation)
        {
            case '-': return new NumberValue(-expr1.eval().asDouble());
            case '+':
            default:
                return expr1.eval();
        }
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("%c%s ", operation, expr1 );
    }
}
