package ast;

import java.util.ArrayList;

public class Block extends ASTNode {
    private ArrayList<Statement> stats;

    public Block(StatementList statementList) {
        this.stats = new ArrayList<Statement>();
    }

    public void add(Statement s) {
        this.stats.add(s);
    }

    public ArrayList<Statement> getStatements(){
        return this.stats;
    }
}