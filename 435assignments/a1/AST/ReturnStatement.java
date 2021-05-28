package AST;

public class ReturnStatement extends Statement {
    public Expression expr;

    public ReturnStatement() {
        this.expr = null;
    }

    public void addExpression(Expression e) {
        this.expr = e;
    }
}