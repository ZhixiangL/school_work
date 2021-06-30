package IR;

public class IRAssignmentInstruction extends IRInstruction {
    public Temp lhs;
    public Temp rhs;


    public IRAssignmentInstruction(Temp left, Temp right){
        this.lhs = left;
        this.rhs = right;
    }
}