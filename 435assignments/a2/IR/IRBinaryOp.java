package IR;

public enum IRBiOp {
        ADD,
        SUBTRACT,
        LESSTHAN,
        EQUAL,
        MULTIPLY
    };

public class IRBinaryOp extends IRInstruction {
    public Temp dest;
    public Temp lhs;
    public Temp rhs;
    public String op;

    public IRBinaryOp(Temp dest, Temp left, Temp right, String op){
        this.dest = dest;
        this.lhs = left;
        this.rhs = right;
        this.op = op;
    }
}