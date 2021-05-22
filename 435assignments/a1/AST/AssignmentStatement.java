package AST;

public class AssignmentStatement extends Statement {
    private Expression expr;
    private Identifier id;

    public AssignmentStatement(Identifier i, Expression e){
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