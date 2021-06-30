package IR;

import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;
import Type.Type;

public class IRFunction extends IRInstruction {
    public String name;
    public Type returnType;
    public List<Type> parameterTypes;
    public String signature;

    public TempFactory tFactory;
    public LabelFactory lFactory;
    public List<Instruction> instructions;

    public Function(String name, Type returnType, List<Type> parameterTypes) {
        this.name = name;
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Type t : parameterTypes) {
            sb.append(t.toChar());
        }
        sb.append(")");
        sb.append(this.returnType.toChar());
        this.signature = sb.toString();
    }

    public TempFactory getTempFactory() {
        return this.tempFactory;
    }

}
