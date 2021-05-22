package AST;

public class BooleanLiteral extends Literal {
    private boolean value;

    public BooleanLiteral(boolean b) {
        this.value = b;
    }

    public boolean getValue() {
        return this.value;
    }
}
