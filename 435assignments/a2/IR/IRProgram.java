package IR;

import java.util.ArrayList;
import java.util.List;

public class IRProgram {
    public String name;
    public List<IRFunction> functions;

    public Program(String name) {
        this.name = name;
        this.functions = new ArrayList<IRFunction>();
    }

    public void addFunction(IRFunction function) {
        this.functions.add(function);
    }

}
