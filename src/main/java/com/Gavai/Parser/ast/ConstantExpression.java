package com.Gavai.Parser.ast;

import com.Gavai.lib.Value;
import com.Gavai.lib.Variables;

public class ConstantExpression implements Expression{

    public final String name;

    public ConstantExpression(String name) {
        this.name = name;
    }

    @Override
    public Value eval() {
        if (!Variables.isExists(name)) throw new RuntimeException("Constant does not exists");
        return Variables.get(name);
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
