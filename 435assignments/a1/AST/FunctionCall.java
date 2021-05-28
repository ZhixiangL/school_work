package AST;

import java.util.ArrayList;

public class FunctionCall extends Expression {
    public Identifier id;
    public ArrayList<Expression> expressionList;

    public FunctionCall (Identifier i) {
        this.id = i;
        this.expressionList = new ArrayList<Expression>();
    }

    public void add(Expression e) {
        expressionList.add(e);
    }
}