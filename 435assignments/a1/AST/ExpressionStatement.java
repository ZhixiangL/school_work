package AST;

public class ExpressionStatement extends Statement {
    public Expression expr;

    public ExpressionStatement(Expression e) {
        this.expr = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}