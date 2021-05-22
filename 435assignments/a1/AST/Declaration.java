package AST;

public class Declaration extends ASTNode {
    private Type tn;
    private Identifier id;

    public Declaration (Type t, Identifier i) {
        this.tn = t;
        this.id = i;
    }

    public Type getType() {
        return this.tn;
    }

    public Identifier getIdentifier() {
        return this.id;
    }    
}