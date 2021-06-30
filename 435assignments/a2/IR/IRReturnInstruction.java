package ir;

public class IRReturnInstruction extends IRInstruction {
    public Temp temp;
    
    public IRReturnInstruction() {
        this.temp = null;
    }

    public IRReturnInstruction(Temp temp) {
        this.temp = temp;
    }

}
