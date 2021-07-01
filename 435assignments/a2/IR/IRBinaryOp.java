package IR;
import java.lang.StringBuilder;

public class IRBinaryOp extends IRInstruction {
    public enum IRBiOp {
        ADD,
        SUBSTRACT,
        LESSTHAN,
        EQUAL,
        MULTIPLY
    };
    public Temp dest;
    public Temp lhs;
    public Temp rhs;
    public IRBiOp op;

    public IRBinaryOp(Temp dest, Temp left, Temp right, IRBiOp op){
        this.dest = dest;
        this.lhs = left;
        this.rhs = right;
        this.op = op;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := ");
        sb.append(this.lhs);
        sb.append(" ");
        sb.append(this.lhs.type.toChar());
        if (op==IRBiOp.ADD){
            sb.append("+");
        }
        else if (op==IRBiOp.SUBSTRACT){
            sb.append("-");
        }
        else if (op==IRBiOp.LESSTHAN){
            sb.append("<");
        }
        else if (op==IRBiOp.EQUAL){
            sb.append("==");
        }
        else {
            sb.append("*");
        }
        sb.append(" ");
        sb.append(this.rhs);
        sb.append(";");
        return sb.toString();
    }
}