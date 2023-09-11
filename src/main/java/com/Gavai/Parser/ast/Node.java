package com.Gavai.Parser.ast;

public interface Node {
    void accept(Visitor visitor);
}
