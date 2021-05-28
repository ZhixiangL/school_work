package AST;

public class EqualExpression extends Expression {
    
    public Expression leftExpr;
    public Expression rightExpr;

    public EqualExpression(Expression e1, Expression e2) {
        this.leftExpr = e1;
        this.rightExpr = e2;
    }
}