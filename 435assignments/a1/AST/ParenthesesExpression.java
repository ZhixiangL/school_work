package AST;

public class ParenthesesExpression extends Expression {
    private Expression expr;

    public ParenthesesExpression(Expression e) {
        this.expr = e;
    }

    public Expression getExpression() {
        return this expr;
    }
}