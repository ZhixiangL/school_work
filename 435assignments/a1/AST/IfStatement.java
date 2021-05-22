package AST;

public class IfStatement extends Statement {
    private Expression expr;
    private Block ifBlock;
    private Block elseBlock;
    private boolean noElse;
    
    public IfStatement(Expression e, Block b) {
        this.expr = e;
        this.ifBlock = b;
        this.elseBlock = null;
        this.noElse = true;
    }

    public IfStatement(Expression e, Block b1, Block b2) {
        this.expr = e;
        this.ifBlock = b1;
        this.elseBlock = b2;
        this.noElse = false;
    }

    public Expression getExpression() {
        return this.expr;
    }

    public Block getIfBlock() {
        return this.ifBlock;
    }

    public Block getElseBlock() {
        return this.elseBlock;
    }
}
