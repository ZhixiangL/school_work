package IR;

public class IRCharacterLiteral extends IRInstruction {
    public Temp dest;
    public char value;

    public IRCharacterLiteral (Temp dest, char value){
        this.dest = dest;
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := \u0027");
        sb.append(this.value);
        sb.append("\u0027;");
        return sb.toString();
    }
}