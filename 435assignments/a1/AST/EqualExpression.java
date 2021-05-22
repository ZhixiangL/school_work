package AST;

public class EqualExpression extends Expression {
    
    private Expression leftExpr;
    private Expression rightExpr;

    public EqualExpression(Expression e1, Expression e2) {
        this.leftExpr = e1;
        this.rightExpr = e2;
    }

    public Expression getLeftExpression() {
        return this.leftExpr;
    }

    public Expression getRightExpression() {
        return this.rightExpr;
    }
}