package AST;

public class VariableDeclaration extends ASTNode {
    private TypeNode tn;
    private Identifier id;

    public VariableDeclaration (TypeNode t, Identifier i) {
        this.tn = t;
        this.id = i;
    }

    public TypeNode getType() {
        return this.tn;
    }

    public Identifier getIdentifier() {
        return this.id;
    }    
}