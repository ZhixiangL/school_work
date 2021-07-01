package IR;

public class IRIntegerLiteral extends IRInstruction {
    public Temp dest;
    public int value;

    public IRIntegerLiteral (Temp dest, int value){
        this.dest = dest;
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := ");
        sb.append(Integer.toString(this.value));
        sb.append(";");
        return sb.toString();
    }
}