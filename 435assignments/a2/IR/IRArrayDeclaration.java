package IR;

import Type.*;
import java.lang.StringBuilder;

public class IRArrayDeclaration extends IRInstruction {
    public Temp dest;
    public ArrayType type;

    public IRArrayDeclaration (Temp dest, ArrayType type){
        this.dest = dest;
        this.type = type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := NEWARRAY ");
        sb.append(this.type.type.toChar());
        sb.append(" ");
        sb.append(this.type.size);
        sb.append(";");
        return sb.toString();
    }
}