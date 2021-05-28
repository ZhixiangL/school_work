package AST;

public class Identifier extends Expression {
    public String id;

    public Identifier (String s) {
        this.id = s;
    }
}