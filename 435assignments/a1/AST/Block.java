package AST;

import java.util.ArrayList;

public class Block extends ASTNode {
    public ArrayList<Statement> statementArray;

    public Block() {
        this.statementArray = new ArrayList<Statement>();
    }

    public void add(Statement s) {
        this.statementArray.add(s);
    }
}