package IR;

import type.*;

public enum TempClass {
        PARAMETER,
        LOCAL,
        TEMP
    };

public class Temp {
    public int number;
    public boolean inUse;
    public TempClass class;
    public Type type;
    public String name;

    public TempEntry (int number, Type type) {
        this.type = type;
        this.number = number;
        this.class = TEMP;
        this.name = "";
        this.inUse = true;
    }

    public Temp(int number, Type type, TempClass class, String name) {
        this.number = number;
        this.type = type;
        this.class = class;
        this.name = name;
        this.inUse = true;
    }

    public boolean isParameterOrLocal() {
        return this.tempClass == TempClass.PARAMETER || this.tempClass == TempClass.LOCAL;
    }
}
