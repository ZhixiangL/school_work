package IR;

public class IRFloatLiteral extends IRInstruction {
    public Temp dest;
    public float value;

    public IRFloatLiteral (Temp dest, float value){
        this.dest = dest;
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := ");
        sb.append(Float.toString(this.value));
        sb.append(";");
        return sb.toString();
    }
}