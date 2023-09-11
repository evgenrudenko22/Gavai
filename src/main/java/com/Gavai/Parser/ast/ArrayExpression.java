package com.Gavai.Parser.ast;

import com.Gavai.lib.*;

import java.util.List;

public class ArrayExpression implements Expression{


    public final List<Expression> elements;

    public ArrayExpression(List<Expression> args) {
        this.elements = args;
    }

    @Override
    public Value eval() {
        final int size = elements.size();
        final ArrayValue array = new ArrayValue(size);
        for (int i = 0; i < size; i++) {
            array.set(i, elements.get(i).eval());
        }
        return array;
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
