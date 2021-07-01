package IR;
import java.lang.StringBuilder;

public class IRReturn extends IRInstruction {
    public Temp temp;

    public IRReturn(Temp temp) {
        this.temp = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RETURN");
        if (this.temp != null) {
            sb.append(" ");
            sb.append(this.temp);
        }
        sb.append(";");
        return sb.toString();
    }

}
