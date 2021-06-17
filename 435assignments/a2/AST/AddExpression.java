package AST;
import Type.*;

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

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}