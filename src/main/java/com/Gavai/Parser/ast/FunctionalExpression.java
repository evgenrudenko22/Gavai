package com.Gavai.Parser.ast;

import com.Gavai.lib.*;

import java.util.ArrayList;
import java.util.List;

public class FunctionalExpression implements Expression{

    public final String name;
    public final List<Expression> args;

    public FunctionalExpression(String name) {
        this.name = name;
        this.args = new ArrayList<>();
    }

    public FunctionalExpression(String name, List<Expression> args) {
        this.name = name;
        this.args = args;
    }

    public void addArgs(Expression arg)
    {
        args.add(arg);
    }

    @Override
    public Value eval() {
        final int size = args.size();
        final Value[] values = new Value[size];
        for (int i = 0; i < size; i++)
        {
            values[i] = args.get(i).eval();
        }

        final Function function = Functions.get(name);
        if (function instanceof UserDefineFunction)
        {
            final UserDefineFunction userFunction = (UserDefineFunction) function;
            if (size != userFunction.getArgsCount()) throw new RuntimeException("Args count mismatch");

            for (int i = 0; i < size; i++)
            {
                Variables.set(userFunction.getArgsName(i), values[i]);
            }
        }
        return function.execute(values);
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name + "(" + args.toString() + ")";
    }
}
