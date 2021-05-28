package AST;

public class Declaration extends ASTNode {
    public TypeNode type;
    public Identifier id;

    public Declaration (TypeNode t, Identifier i) {
        this.type = t;
        this.id = i;
    } 

    public void accept(Visitor v) {
        v.visit(this);
    }
}