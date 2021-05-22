package AST;

public class StringLiteral extends Literal {
    private String value;

    public StringLiteral(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }
}
