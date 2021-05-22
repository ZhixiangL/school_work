package AST;

public class FloatLiteral extends Literal {
    private float value;

    public FloatLiteral(float f) {
        this.value = f;
    }

    public float getValue() {
        return this.value;
    }
}
