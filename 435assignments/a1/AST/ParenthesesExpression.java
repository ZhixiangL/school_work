package AST;

public class ParenthesesExpression extends Expression {
    public Expression expr;

    public ParenthesesExpression(Expression e) {
        this.expr = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}