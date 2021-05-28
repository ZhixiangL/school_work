package AST;

public class MultiplyExpression extends Expression {
    
    public Expression leftExpr;
    public Expression rightExpr;

    public MultiplyExpression(Expression e1, Expression e2) {
        this.leftExpr = e1;
        this.rightExpr = e2;
    }

}