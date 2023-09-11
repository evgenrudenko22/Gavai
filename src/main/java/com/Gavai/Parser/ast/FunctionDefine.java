package com.Gavai.Parser.ast;

import com.Gavai.lib.Functions;
import com.Gavai.lib.UserDefineFunction;

import java.util.List;

public class FunctionDefine implements Statement{

    public final String name;
    public final List<String> argName;
    public final Statement body;

    public FunctionDefine(String name, List<String> argName, Statement body) {
        this.name = name;
        this.argName = argName;
        this.body = body;
    }

    @Override
    public void execute() {
        Functions.set(name, new UserDefineFunction(argName, body));
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "fn (" + argName.toString() + ")" + body.toString();
    }
}
