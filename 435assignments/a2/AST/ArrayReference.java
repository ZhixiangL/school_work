package AST;
import Type.*;

public class ArrayReference extends Expression {
    public Expression expr;
    public Identifier id;

    public ArrayReference(Identifier i, Expression e){
        this.id = i;
        this.expr = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }

}