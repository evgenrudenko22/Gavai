package com.Gavai.Parser.ast;

public interface Visitor {

    void visit(AssignmentStatement st);
    void visit(FunctionDefine st);
    void visit(FunctionalStatement st);
    void visit(ReturnStatement st);
    void visit(PrintStatement st);
    void visit(UnaryExpression st);
    void visit(ValueExpression st);
    void visit(WhileStatement st);
    void visit(IfStatement st);
    void visit(FunctionalExpression st);
    void visit(ForStatement st);
    void visit(DoWhileStatement st);
    void visit(ConditionalExpression st);
    void visit(ConstantExpression st);
    void visit(ContinueStatement st);
    void visit(BlockStatement st);
    void visit(BinaryExpression st);
    void visit(BreakStatement st);
    void visit(ArrayAccessExpression st);
    void visit(ArrayExpression st);
    void visit(ArrayAssignmentStatement st);
    void visit(UseStatement st);

}
