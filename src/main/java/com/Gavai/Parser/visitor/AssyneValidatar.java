package com.Gavai.Parser.visitor;

import com.Gavai.Parser.ast.*;
import com.Gavai.lib.Variables;

public class AssyneValidatar extends AbstractVisitor {
    @Override
    public void visit(AssignmentStatement st) {
        st.expression.accept(this);
        if (Variables.isExists(st.variable)) {
            throw new RuntimeException("Cannot assign value to constant");
        }
    }
}