package IR;
import java.lang.StringBuilder;

public class IRAssignmentInstruction extends IRInstruction {
    public Temp lhs;
    public Temp rhs;


    public IRAssignmentInstruction(Temp left, Temp right){
        this.lhs = left;
        this.rhs = right;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(lhs);
        sb.append(" := ");
        sb.append(rhs);
        sb.append(";");
        return sb.toString();
    }
}