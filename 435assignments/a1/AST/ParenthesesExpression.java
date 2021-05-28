package AST;

public class ParenthesesExpression extends Expression {
    public Expression expr;

    public ParenthesesExpression(Expression e) {
        this.expr = e;
    }

}