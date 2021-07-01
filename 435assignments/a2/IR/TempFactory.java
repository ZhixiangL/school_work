package IR;

import Type.*;
import java.lang.StringBuilder;

public class TempFactory {
    private TempEntry[] tempArray;
    private int pos;

    public TempFactory() {
        this.tempArray = new TempEntry[65536];
        this.pos = -1;
    }

    public Temp getTemp(Type type) {
        this.pos++;
        this.tempArray[pos] = new TempEntry(pos, type);
        return new Temp(type, pos);
    }

    public Temp getTemp(Type type, TempEntry.TempClass c, String name) {
        this.pos++;
        this.tempArray[pos] = new TempEntry(pos, type, c, name);
        return new Temp(type, pos);
    }

    public void returnTemp(Temp t) {
        return;
    }

    public boolean isParameterOrLocal(Temp t){
        return this.tempArray[t.number].isParameterOrLocal();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        TempEntry t;
        for (int i=0; i<tempArray.length; i++) {
            t = tempArray[i];
            if (t==null){
                break;
            }
            sb.append("    TEMP ");
            sb.append(t.number);
            sb.append(":");
            sb.append(t.type.toChar());
            // if (t.tClass == TempEntry.TempClass.PARAMETER) {
            //     sb.append("\t[P(\"");
            //     sb.append(t.name);
            //     sb.append("\")]");
            // } else if (t.tClass == TempEntry.TempClass.LOCAL) {
            //     sb.append("\t[L(\"");
            //     sb.append(t.name);
            //     sb.append("\")]");
            // }
            sb.append(";\n");
        }
        return sb.toString();
    }
}
