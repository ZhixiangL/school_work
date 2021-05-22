package AST;

public class PrintStatement extends Statement {
    private Expression expr;

    public PrintStatement(Expression e){
        this.expr = e;
    }

    public Expression getExpression() {
        return this.expr;
    }
}