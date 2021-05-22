package AST;

import java.util.ArrayList;

public class FunctionDecl extends ASTNode {
    private Declaration decl;
    private FormalParameters fp;

    public FunctionDecl (Declaration d, FormalParameters f) {
        this.decl = d;
        this.fp = f;
    }

    public Declaration getDeclaration(){
        return this.decl;
    }

    public FormalParameters getFormalParameters() {
        return this.fp;
    }
}