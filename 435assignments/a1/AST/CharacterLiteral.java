package AST;

public class CharacterLiteral extends Literal {
    public char value;

    public CharacterLiteral(char c) {
        this.value = c;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
