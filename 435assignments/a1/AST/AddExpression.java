package AST;

public class AddExpression extends Expression {
    
    public Expression leftExpr;
    public Expression rightExpr;

    public AddExpression(Expression e1, Expression e2) {
        this.leftExpr = e1;
        this.rightExpr = e2;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}