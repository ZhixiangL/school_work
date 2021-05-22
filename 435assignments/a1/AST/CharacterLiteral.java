package AST;

public class CharacterLiteral extends Literal {
    private char value;

    public CharacterLiteral(char c) {
        this.value = c;
    }

    public char getValue() {
        return this.value;
    }

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
