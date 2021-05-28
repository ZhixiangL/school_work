package AST;

public class IntegerLiteral extends Literal {
    public int value;

    public IntegerLiteral(int i) {
        this.value = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}