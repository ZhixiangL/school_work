package AST;

public class ExpressionStatement extends Statement {
    public Expression expr;

    public ExpressionStatement(Expression e) {
        this.expr = e;
    }

}