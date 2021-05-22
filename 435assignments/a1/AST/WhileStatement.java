package AST;

public class WhileStatement extends Statement {
    private Expression expr;
    private Block block;

    public WhileStatement(Expression e, Block b){
        this.expr = e;
        this.block = b;
    }

    public Expression getExpression() {
        return this.expr;
    }

    public Block getBlock(){
        return this.block;
    }
}