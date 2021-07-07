package IR;

public class IRFloatLiteral extends IRInstruction {
    public Temp dest;
    public float value;

    public IRFloatLiteral (Temp dest, float value){
        this.dest = dest;
        this.value = value;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.dest);
        s.append(" := ");
        s.append(Float.toString(this.value));
        s.append(";");
        return s.toString();
    }
}