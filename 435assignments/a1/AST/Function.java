package AST;

public class Function extends ASTNode {
    public FunctionDecl functionDecl;
    public FunctionBody functionBody;

    public Function (FunctionDecl fd, FunctionBody fb){
        this.functionDecl = fd;
        this.functionBody = fb;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}