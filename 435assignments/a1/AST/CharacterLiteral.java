package AST;

public class CharacterLiteral extends Literal {
    public char value;

    public CharacterLiteral(char c) {
        this.value = c;
    }
}
