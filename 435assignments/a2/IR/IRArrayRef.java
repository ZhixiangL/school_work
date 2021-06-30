package IR;

public class IRArrayRef extends IRInstruction {
    public Temp dest;
    public Temp id;
    public Temp expr;

    public IRArrayRef(Temp dest, Temp id, Temp expr){
        this.dest = dest;
        this.id = id;
        this.expr = expr;
    }
}