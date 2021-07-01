package IR;

public class IRBooleanLiteral extends IRInstruction {
    public Temp dest;
    public boolean value;

    public IRBooleanLiteral (Temp dest, boolean value){
        this.dest = dest;
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := ");
        sb.append(this.value ? "TRUE" : "FALSE");
        sb.append(";");
        return sb.toString();
    }
}