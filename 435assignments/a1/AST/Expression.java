package AST;

public abstract class Expression extends ASTNode {
    public abstract void accept (Visitor v);
    public abstract Type accept (TypeVisitor v) throws SemanticException;
    // public abstract Temp accept (TempVisitor v);
    // public abstract Value accept (InterpreterVisitor v);

}