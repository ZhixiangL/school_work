package AST;

public class VariableDeclaration extends ASTNode {
    public TypeNode type;
    public Identifier id;

    public VariableDeclaration (TypeNode t, Identifier i) {
        this.type = t;
        this.id = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
 
}