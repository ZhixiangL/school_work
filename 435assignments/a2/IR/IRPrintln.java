package IR;

public class IRPrintln extends IRInstruction {
    public Temp temp;

    public IRPrintln(Temp temp) {
        this.temp = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRINTLN");
        sb.append(this.temp.type.toChar());
        sb.append(" ");
        sb.append(this.temp);
        sb.append(";");
        return sb.toString();
    }
}