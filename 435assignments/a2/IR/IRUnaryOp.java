package IR;



public class IRUnaryOp extends IRInstruction {
    public enum IRUOp {
        INVERT,
        NEGATIVE
    };
    public Temp dest;
    public Temp rhs;
    public IRUOp op;

    public IRUnaryOp(Temp dest, Temp right, IRUOp op){
        this.dest = dest;
        this.rhs = right;
        this.op = op;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := ");
        if (op==IRUOp.INVERT){
            sb.append("!");
        }
        else {
            sb.append("-");
        }
        sb.append(this.rhs);
        sb.append(";");
        return sb.toString();
    }
}