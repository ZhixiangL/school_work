package AST;

public class LessThanExpression extends Expression {
    
    public Expression leftExpr;
    public Expression rightExpr;

    public LessThanExpression(Expression e1, Expression e2) {
        this.leftExpr = e1;
        this.rightExpr = e2;
    }
}