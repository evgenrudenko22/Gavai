package com.Gavai.Parser.ast;

public class ForStatement implements Statement{

    public final Statement initialization;
    public final Expression termination;
    public final Statement increment;
    public final Statement statement;

    public ForStatement(Statement initialization, Expression termination, Statement increment, Statement statement) {
        this.initialization = initialization;
        this.termination = termination;
        this.increment = increment;
        this.statement = statement;
    }

    @Override
    public void execute() {
        for (initialization.execute(); termination.eval().asDouble() != 0; increment.execute())
        {
            try
            {
                statement.execute();
            } catch (BreakStatement bs)
            {
                break;
            } catch (ContinueStatement cs)
            {
                // continue
            }
        }
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "for " + initialization + ", " + termination + ", " + increment + " " + statement;
    }
}
