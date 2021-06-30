package IR;

public class IRIfStatement {
    public Temp expr;
    public Label go;

    public IRIfStatement(Temp e, Label g) {
        this.expr = e;
        this.go = g;
    }
}