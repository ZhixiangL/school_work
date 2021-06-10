package AST;
import Type.*;

public class IntegerLiteral extends Literal {
    public int value;

    public IntegerLiteral(int i) {
        this.value = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }

}