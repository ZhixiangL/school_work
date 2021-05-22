package AST;

import java.util.ArrayList;

public class Program extends ASTNode {
    private ArrayList<Function> funcList;
    private int size;

    public Program (){
        funcList = new ArrayList<Function>();
        size = 0;
    }

    public void add(Function f) {
        this.funcList.add(f);
        size++;
    }

    public Function get(int index) {
        this.funcList.get(index);
    }

    public int size() {
        return this.size;
    }

}