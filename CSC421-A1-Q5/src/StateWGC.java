import java.util.HashSet;
import java.util.Set;

public class StateWGC {
    Set<Integer> leftBank = new HashSet<Integer>(); //0 cabbage; 1 goat; 2 wolf
    Set<Integer> rightBank = new HashSet<Integer>();
    int boatPosition = 0; //0 left bank; 1 right bank

    public StateWGC (Set<Integer> left, Set<Integer> right, int position ){
        leftBank = left;
        rightBank = right;
        boatPosition = position;
    }
    public String toString(){
        String result = "";
        result += "left bank: ";
        for(int item : leftBank){
            result += Integer.toString(item) + " ";
        }
        result += ";  right bank: ";
        for(int item : rightBank){
            result += Integer.toString(item)+" ";
        }
        result += ";  boat position: "+ Integer.toString(boatPosition)+"\n";
        return result;
    }
    public boolean equals(Object o) {
        StateWGC obj = (StateWGC) o;
        return leftBank.equals(obj.leftBank) && rightBank.equals(obj.rightBank) && boatPosition == obj.boatPosition;
    }
    public int hashCode() {
        return leftBank.hashCode()+rightBank.hashCode()+boatPosition;
    } 
}
