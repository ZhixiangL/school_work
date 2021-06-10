package AST;
import Type.*;

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

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}