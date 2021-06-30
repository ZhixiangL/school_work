package IR;

public class IRIntegerLiteral extends IRInstruction {
    public Temp dest;
    public int value;

    public IRIntegerLiteral (Temp dest, int value){
        this.dest = dest;
        this.value = value;
    }
}