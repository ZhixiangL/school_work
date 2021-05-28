package AST;

public class WhileStatement extends Statement {
    public Expression expr;
    public Block block;

    public WhileStatement(Expression e, Block b){
        this.expr = e;
        this.block = b;
    }
}