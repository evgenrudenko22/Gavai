package com.Gavai.Parser.ast;

public class IfStatement implements Statement{

    public final Expression expression;
    public final Statement ifStatement, elseStatement;

    public IfStatement(Expression expression, Statement ifStatement, Statement elseStatement) {
        this.expression = expression;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public void execute() {
        final double result = expression.eval().asDouble();
        if (result != 0)
        {
            ifStatement.execute();
        } else if (elseStatement != null)
        {
            elseStatement.execute();
        }
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append("if ").append(expression).append(' ').append(ifStatement);
        if (elseStatement != null)
        {
            result.append("\nelse ").append(expression).append(' ').append(elseStatement);
        }
        return result.toString();
    }
}
