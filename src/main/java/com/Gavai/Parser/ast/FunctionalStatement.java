package com.Gavai.Parser.ast;

public class FunctionalStatement implements Statement{

    public final FunctionalExpression function;

    public FunctionalStatement(FunctionalExpression function) {
        this.function = function;
    }

    @Override
    public void execute() {
        function.eval();
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return function.toString();
    }
}
