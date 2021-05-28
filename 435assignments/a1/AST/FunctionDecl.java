package AST;

import java.util.ArrayList;

public class FunctionDecl extends ASTNode {
    public Declaration declaration;
    public FormalParameters formalParameters;

    public FunctionDecl (Declaration d, FormalParameters f) {
        this.declaration = d;
        this.formalParameters = f;
    }

}