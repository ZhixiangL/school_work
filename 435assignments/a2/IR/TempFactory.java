package IR;

import type.*;

public class TempFactory {
    private TempEntry[65536] tempArray;
    private int pos;

    public TempFactory() {
        pos = -1;
    }

    public Temp getTemp(Type type) {
        pos++;
        tempArray[pos] = new TempEntry(pos, type);
        return new Temp(pos, type);
    }

    public Temp getTemp(Type type, TempClass class, String name) {
        pos++;
        tempArray[pos] = new TempEntry(pos, type, class, name);
        return new Temp(pos, type);
    }

    public void returnTemp(Temp t) {
        return;
    }

    public boolean isParameterOrLocal(Temp t){
        return this.tempArray[t.number].isParameterOrLocal();
    }
}
