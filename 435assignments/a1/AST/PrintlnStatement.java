package AST;

public class PrintlnStatement extends Statement {
    public Expression expr;

    public PrintlnStatement(Expression e){
        this.expr = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}