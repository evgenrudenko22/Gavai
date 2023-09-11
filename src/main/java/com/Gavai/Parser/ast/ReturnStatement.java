package com.Gavai.Parser.ast;

import com.Gavai.lib.Value;

public class ReturnStatement extends RuntimeException implements Statement{

    private final Expression expression;
    private Value result;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    public Value getResult() {
        return result;
    }

    @Override
    public void execute() {
        result = expression.eval();
        throw this;
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "break";
    }
}
