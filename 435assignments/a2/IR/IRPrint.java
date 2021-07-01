package IR;

public class IRPrint extends IRInstruction {
    public Temp temp;

    public IRPrint(Temp temp) {
        this.temp = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRINT");
        sb.append(this.temp.type.toChar());
        sb.append(" ");
        sb.append(this.temp);
        sb.append(";");
        return sb.toString();
    }
}