package IR;

public class Label extends IRInstruction {
    public int number;

    public Label(int number) {
        this.number = number;
    }

    public String toString(){
        return "L"+Integer.toString(this.number)+":;";
    }

}
