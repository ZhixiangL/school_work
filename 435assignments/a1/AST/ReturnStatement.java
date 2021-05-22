package AST;

public class ReturnStatement extends Statement {
    private Expression expr;
    private boolean noReturn;

    public ReturnStatement(Expression e){
        this.expr = e;
        this.noReturn = false;
    }

    public ReturnStatement() {
        this.expr = null;
        this.noReturn = true;
    }

    public Expression getExpression() {
        return this.expr;
    }

    public void addExpression(Expression e) {
        this.expr = e;
        noReturn = false;
    }
}