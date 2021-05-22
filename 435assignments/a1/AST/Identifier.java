package AST;

public class Identifier extends Expression {
    private String id;

    public Identifier (String s) {
        this.id = s;
    }

    public String getIdentifier() {
        return this.id;
    }
}