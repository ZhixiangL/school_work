package AST;

import java.util.ArrayList;

public class FormalParameters extends ASTNode {
    private ArrayList<Declaration> fp;
    private int size;

    public FormalParameters() {
        this.fp = new ArrayList<Declaration>();
        size = 0;
    }

    public ArrayList<Declaration> getParameterArray() {
        return this.fp;
    }

    public void add(Declaration d) {
        this.fp.add(d);
        size++;
    }

    public Declaration get(int index) {
        return this.fp.get(index);
    }

    public int size() {
        return this.size;
    }
}