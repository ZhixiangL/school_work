package AST;

import java.util.ArrayList;

public class FunctionBody extends ASTNode {
    private ArrayList<VariableDeclaration> vds;
    private ArrayList<Statement> stats;

    public FunctionBody() {
        this.vds = new ArrayList<VariableDeclaration>();
        this.stats = new ArrayList<Statement>();
    }

    public ArrayList<VariableDeclaration> getVariableDeclarations() {
        return this.vds;
    }

    public ArrayList<Statement> getStatements() {
        return this.stats;
    }

    public void addVarDecl(VariableDeclaration v) {
        this.vds.add(v);
    }

    public void addStatement(Statement s) {
        this.stats.add(s);
    }
}