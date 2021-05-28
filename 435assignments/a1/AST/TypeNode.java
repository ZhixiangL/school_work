package AST;

import Type.Type;

public class TypeNode extends ASTNode {
    public Type type;

    public TypeNode(Type type) {
        this.type = type;
    }

}
