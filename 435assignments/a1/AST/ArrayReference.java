package AST;

public class ArrayReference extends Expression {
    private Expression expr;
    private Identifier id;

    public ArrayReference(Identifier i, Expression e){
        this.id = i;
        this.expr = e;
    }

    public Expression getExpression() {
        return this.expr;
    }

    public Block getIdentifier(){
        return this.id;
    }
}