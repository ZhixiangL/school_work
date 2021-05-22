package AST;

public class Function extends ASTNode {
    private FunctionDecl fd;
    private FunctionBody fb;

    public Function (FunctionDecl fd, FunctionBody fb){
        this.fd = fd;
        this.fb = fb;
    }

    public FunctionDecl getFunctionDecl() {
        return this.fd;
    }

    public FunctionBody getFunctionBody() {
        return this.fb;
    }

}