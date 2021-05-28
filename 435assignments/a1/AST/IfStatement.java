package AST;

public class IfStatement extends Statement {
    public Expression expr;
    public Block ifBlock;
    public Block elseBlock;
    
    public IfStatement(Expression e, Block b) {
        this.expr = e;
        this.ifBlock = b;
        this.elseBlock = null;
    }

    public IfStatement(Expression e, Block b1, Block b2) {
        this.expr = e;
        this.ifBlock = b1;
        this.elseBlock = b2;
    }

}
