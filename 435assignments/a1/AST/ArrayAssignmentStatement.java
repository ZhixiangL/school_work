package AST;

public class ArrayAssignmentStatement extends Statement {
    private Expression expr;
    private ArrayReference ar;

    public ArrayAssignmentStatement(ArrayReference a, Expression e){
        this.ar = a;
        this.expr = e;
    }

    public Expression getExpression() {
        return this.expr;
    }

    public Block getArrayReference(){
        return this.ar;
    }
}