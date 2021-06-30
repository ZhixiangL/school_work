package IR;

public class IRArrayAssignmentInstruction extends IRInstruction {
    public Temp id;
    public Temp index;
    public Temp right;


    public IRArrayAssignmentInstruction(Temp id, Temp index, Temp right){
        this.id = id;
        this.index = index;
        this.right = right;
    }
}