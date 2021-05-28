package AST;

import java.util.ArrayList;

public class FunctionBody extends ASTNode {
    public ArrayList<VariableDeclaration> variableDeclarationArray;
    public ArrayList<Statement> statementArray;

    public FunctionBody() {
        this.variableDeclarationArray = new ArrayList<VariableDeclaration>();
        this.statementArray = new ArrayList<Statement>();
    }

    public void addVarDecl(VariableDeclaration v) {
        this.variableDeclarationArray.add(v);
    }

    public void addStatement(Statement s) {
        this.statementArray.add(s);
    }
}