package AST;

public class SubstractExpression extends Expression {
    
    public Expression leftExpr;
    public Expression rightExpr;

    public SubstractExpression(Expression e1, Expression e2) {
        this.leftExpr = e1;
        this.rightExpr = e2;
    }

}