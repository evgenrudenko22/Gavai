package com.Gavai.Parser.ast;

import com.Gavai.lib.Value;
import com.Gavai.lib.Variables;

public class AssignmentStatement implements Statement{

    public final String variable;
    public final Expression expression;

    public AssignmentStatement(String variable, Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public void execute() {
        final Value result = expression.eval();
        Variables.set(variable, result);
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("%s = %s", variable, expression);
    }
}
