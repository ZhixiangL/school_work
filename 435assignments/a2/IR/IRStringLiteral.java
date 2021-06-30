package IR;

public class IRStringLiteral extends IRInstruction {
    public Temp dest;
    public String value;

    public IRStringLiteral (Temp dest, String value){
        this.dest = dest;
        this.value = value;
    }
}