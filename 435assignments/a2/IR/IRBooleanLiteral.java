package IR;

public class IRBooleanLiteral extends IRInstruction {
    public Temp dest;
    public boolean value;

    public IRBooleanLiteral (Temp dest, boolean value){
        this.dest = dest;
        this.value = value;
    }
}