package AST;

public class ArrayAssignmentStatement extends Statement {
    public Expression expr;
    public ArrayReference arrayReference;

    public ArrayAssignmentStatement(ArrayReference a, Expression e){
        this.arrayReference = a;
        this.expr = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}