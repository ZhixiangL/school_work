package AST;

public class AssignmentStatement extends Statement {
    public Expression expr;
    public Identifier id;

    public AssignmentStatement(Identifier i, Expression e){
        this.id = i;
        this.expr = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}