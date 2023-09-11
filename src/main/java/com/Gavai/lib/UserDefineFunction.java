package com.Gavai.lib;

import com.Gavai.Parser.ast.ReturnStatement;
import com.Gavai.Parser.ast.Statement;

import java.util.List;

public class UserDefineFunction implements Function{

    private final List<String> argName;
    private final Statement body;

    public UserDefineFunction(List<String> argName, Statement body) {
        this.argName = argName;
        this.body = body;
    }

    public int getArgsCount()
    {
        return argName.size();
    }

    public String getArgsName(int index)
    {
        if (index < 0 || index >= getArgsCount()) return "";
        return argName.get(index);
    }

    @Override
    public Value execute(Value... args) {
        try {
            body.execute();
            return new NumberValue(0);
        } catch (ReturnStatement rs)
        {
            return rs.getResult();
        }
    }
}
