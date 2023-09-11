package com.Gavai.Parser.ast;

import com.Gavai.lib.modules.Module;

public class UseStatement implements Statement{

    private static final String PACKAGE = "com.Gavai.lib.modules.";

    public final Expression expression;

    public UseStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void execute() {
        try {
            final String moduleName = expression.eval().asString();
            final Module module = (Module) Class.forName(PACKAGE + moduleName).newInstance();
            module.init();
        } catch (Exception ex) { }
    }

    @Override
    public String toString() {
        return "use " + expression;
    }
}
