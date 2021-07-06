package IR;

import java.util.ArrayList;

public class IRFunctionCallVoid extends IRInstruction {
    public String functionName;
    public ArrayList<Temp> expressionList;

    public IRFunctionCallVoid(String fName, ArrayList<Temp> exprs){
        this.functionName = fName;
        this.expressionList = exprs;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CALL ");
        sb.append(functionName);
        sb.append("(");
        for (int i=0; i<this.expressionList.size();i++){
            sb.append(this.expressionList.get(i));
        }
        sb.append(");");
        return sb.toString();
    }
}