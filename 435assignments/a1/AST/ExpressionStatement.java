package AST;

public class ExpressionStatement extends Statement {
    private Expression expr;

    public ExpressionStatement(Expression e) {
        this.expr = e;
    }

    public Expression getExpression() {
        return this.expr;
    }
}