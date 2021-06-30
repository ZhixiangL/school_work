package IR;

public enum IRUOp {
        INVERT,
        NEGATIVE
    };

public class IRUnaryOp extends IRInstruction {
    public Temp dest;
    public Temp rhs;
    public String op;

    public IRUnaryOp(Temp dest, Temp right, String op){
        this.dest = dest;
        this.rhs = right;
        this.op = op;
    }
}