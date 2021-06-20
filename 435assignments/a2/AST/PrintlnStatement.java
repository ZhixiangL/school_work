package AST;
import Type.*;

public class PrintlnStatement extends Statement {
    public Expression expr;

    public PrintlnStatement(Expression e){
        this.expr = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}