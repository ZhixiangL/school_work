package IR;
import java.lang.StringBuilder;

public class IRArrayAssignmentInstruction extends IRInstruction {
    public Temp id;
    public Temp index;
    public Temp right;


    public IRArrayAssignmentInstruction(Temp id, Temp index, Temp right){
        this.id = id;
        this.index = index;
        this.right = right;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append("[");
        sb.append(this.index);
        sb.append("]");
        sb.append(" := ");
        sb.append(this.right);
        sb.append(";");
        return sb.toString();
    }
}