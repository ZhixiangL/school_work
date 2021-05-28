package AST;

public class BooleanLiteral extends Literal {
    public boolean value;

    public BooleanLiteral(boolean b) {
        this.value = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
