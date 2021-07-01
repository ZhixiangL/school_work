package IR;
import java.lang.StringBuilder;
import Type.*;

public class IRArrayRef extends Temp {
    public Temp index;
    public Temp id;

    public IRArrayRef(Temp id, Temp index){
        super(((ArrayType)id.type).type, 0);
        this.index = index;
        this.id = id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append("[");
        sb.append(this.index);
        sb.append("]");
        return sb.toString();
    }
}