package IR;
import java.lang.StringBuilder;
import Type.*;

public class IRArrayRef extends IRInstruction {
    public Temp dest;
    public Temp index;
    public Temp id;

    public IRArrayRef(Temp dest, Temp id, Temp index){
        this.dest = dest;
        this.index = index;
        this.id = id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := ");
        sb.append(this.id);
        sb.append("[");
        sb.append(this.index);
        sb.append("];");
        return sb.toString();
    }
}