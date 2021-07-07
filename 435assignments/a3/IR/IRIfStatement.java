package IR;

public class IRIfStatement extends IRInstruction {
    public Temp expr;
    public Label go;

    public IRIfStatement(Temp e, Label g) {
        this.expr = e;
        this.go = g;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("IF ");
        s.append(expr);
        s.append(" GOTO ");
        s.append("L"+Integer.toString(go.number)+";");
        return s.toString();
    }
}