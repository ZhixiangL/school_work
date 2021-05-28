package AST;

public class PrintStatement extends Statement {
    public Expression expr;

    public PrintStatement(Expression e){
        this.expr = e;
    }
}