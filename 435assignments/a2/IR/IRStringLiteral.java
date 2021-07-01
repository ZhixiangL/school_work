package IR;

public class IRStringLiteral extends IRInstruction {
    public Temp dest;
    public String value;

    public IRStringLiteral (Temp dest, String value){
        this.dest = dest;
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := \"");
        sb.append(this.value);
        sb.append("\";");
        return sb.toString();
    }
}