package AST;
import Type.*;

public class StringLiteral extends Literal {
    public String value;

    public StringLiteral(String s) {
        this.value = s;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}