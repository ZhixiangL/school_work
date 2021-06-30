package IR;

public class IRCharacterLiteral extends IRInstruction {
    public Temp dest;
    public char value;

    public IRCharacterLiteral (Temp dest, char value){
        this.dest = dest;
        this.value = value;
    }
}