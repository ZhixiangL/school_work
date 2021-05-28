package AST;

public class FloatLiteral extends Literal {
    public float value;

    public FloatLiteral(float f) {
        this.value = f;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
