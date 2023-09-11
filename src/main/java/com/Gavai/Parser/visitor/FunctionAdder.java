package com.Gavai.Parser.visitor;

import com.Gavai.Parser.ast.*;

public class FunctionAdder extends AbstractVisitor {
    @Override
    public void visit(FunctionDefine st) {
        st.body.accept(this);
        st.execute();
    }
}
