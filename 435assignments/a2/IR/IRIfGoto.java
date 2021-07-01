package IR;

public class IRIfGoto extends IRInstruction {
    public Label go;

    public IRIfGoto(Label g) {
        this.go = g;
    }

    public String toString(){
        return "GOTO L"+Integer.toString(go.number)+";"; 
    }
}