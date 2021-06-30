package IR;

public class IRFloatLiteral extends IRInstruction {
    public Temp dest;
    public float value;

    public IRFloatLiteral (Temp dest, float value){
        this.dest = dest;
        this.value = value;
    }
}