package AST;

public class AddExpression extends Expression {
    
    private Expression leftExpr;
    private Expression rightExpr;

    public AddExpression(Expression e1, Expression e2) {
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