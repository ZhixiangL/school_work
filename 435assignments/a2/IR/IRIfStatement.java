package IR;

public class IRIfStatement extends IRInstruction {
    public Temp expr;
    public Label go;

    public IRIfStatement(Temp e, Label g) {
        this.expr = e;
        this.go = g;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("IF ");
        sb.append(expr);
        sb.append(" GOTO ");
        sb.append("L"+Integer.toString(go.number)+";");
        return sb.toString();
    }
}