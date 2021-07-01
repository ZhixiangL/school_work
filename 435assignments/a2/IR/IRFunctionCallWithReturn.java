package IR;

import java.util.ArrayList;

public class IRFunctionCallWithReturn extends IRInstruction {
    public Temp dest;
    public String functionName;
    public ArrayList<Temp> expressionList;

    public IRFunctionCallWithReturn (Temp d, String fName, ArrayList<Temp> exprs){
        this.dest = d;
        this.functionName = fName;
        this.expressionList = exprs;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.dest);
        sb.append(" := ");
        sb.append("CALL ");
        sb.append(functionName);
        sb.append("(");
        for (int i=0; i<this.expressionList.size();i++){
            sb.append(this.expressionList.get(i).type.toChar());
        }
        sb.append(");");
        return sb.toString();
    }
}