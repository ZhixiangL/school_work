package AST;

public class PrintlnStatement extends Statement {
    private Expression expr;

    public PrintlnStatement(Expression e){
        this.expr = e;
    }

    public Expression getExpression() {
        return this.expr;
    }
}