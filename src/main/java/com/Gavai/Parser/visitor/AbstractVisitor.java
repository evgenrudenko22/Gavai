package com.Gavai.Parser.visitor;

import com.Gavai.Parser.ast.*;
import com.Gavai.lib.Variables;

public abstract class AbstractVisitor implements Visitor {
    @Override
    public void visit(AssignmentStatement st) {
        st.expression.accept(this);
    }

    @Override
    public void visit(FunctionDefine st) {
        st.body.accept(this);
    }

    @Override
    public void visit(FunctionalStatement st) {
        st.function.accept(this);
    }

    @Override
    public void visit(ReturnStatement st) {

    }

    @Override
    public void visit(PrintStatement st) {
        st.expression.accept(this);
    }

    @Override
    public void visit(UnaryExpression st) {
        st.expr1.accept(this);
    }

    @Override
    public void visit(ValueExpression st) {

    }

    @Override
    public void visit(WhileStatement st) {
        st.statement.accept(this);
        st.condition.accept(this);
    }

    @Override
    public void visit(IfStatement st) {
        st.expression.accept(this);
        st.ifStatement.accept(this);
        if (st.elseStatement != null)
        {
            st.elseStatement.accept(this);
        }
    }

    @Override
    public void visit(FunctionalExpression st) {
        for (Expression argument : st.args)
        {
            argument.accept(this);
        }
    }

    @Override
    public void visit(ForStatement st) {
        st.increment.accept(this);
        st.initialization.accept(this);
        st.statement.accept(this);
        st.termination.accept(this);
    }

    @Override
    public void visit(DoWhileStatement st) {
        st.condition.accept(this);
        st.statement.accept(this);
    }

    @Override
    public void visit(ConditionalExpression st) {
        st.expr1.accept(this);
        st.expr2.accept(this);
    }

    @Override
    public void visit(ConstantExpression st) {

    }

    @Override
    public void visit(ContinueStatement st) {

    }

    @Override
    public void visit(BlockStatement st) {
        for (Statement statement : st.statements)
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(BinaryExpression st) {
        st.expr1.accept(this);
        st.expr2.accept(this);
    }

    @Override
    public void visit(BreakStatement st) {

    }

    @Override
    public void visit(ArrayAccessExpression st) {
        for (Expression index : st.indices){
            index.accept(this);
        }
    }

    @Override
    public void visit(ArrayExpression st) {
        for (Expression index : st.elements){
            index.accept(this);
        }
    }

    @Override
    public void visit(ArrayAssignmentStatement st) {
        st.array.accept(this);
        st.expression.accept(this);
    }

    @Override
    public void visit(UseStatement st)
    {

    }
}
