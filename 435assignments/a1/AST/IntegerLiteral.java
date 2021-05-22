package AST;

public class IntegerLiteral extends Literal {
    private int value;

    public IntegerLiteral(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}