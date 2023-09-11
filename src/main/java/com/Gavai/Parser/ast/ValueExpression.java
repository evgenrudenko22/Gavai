package com.Gavai.Parser.ast;

import com.Gavai.lib.NumberValue;
import com.Gavai.lib.StringValue;
import com.Gavai.lib.Value;

public final class ValueExpression implements Expression{

    public final Value value;

    public ValueExpression(double value)
    {
        this.value = new NumberValue(value);
    }

    public ValueExpression(String value)
    {
        this.value = new StringValue(value);
    }

    @Override
    public Value eval() {
        return value;
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return value.asString();
    }
}
