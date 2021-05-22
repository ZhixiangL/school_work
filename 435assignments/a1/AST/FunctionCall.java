package AST;

import java.util.ArrayList;

public class FunctionCall extends Expression {
    private Identifier id;
    private ArrayList<Expression> el;

    public FunctionCall (Identifier i) {
        this.id = i;
        this.el = new ArrayList<Expression>;
    }

    public void addExpression(Expression e) {
        el.add(e);
    }

    public Identifier getIdentifier() {
        return this.id;
    }

    public ArrayList<Expression> getExpressionList(){
        return this.el;
    }

    public void setExpressionList(ArrayList<Expression> e) {
        this.el = e;
    }
}