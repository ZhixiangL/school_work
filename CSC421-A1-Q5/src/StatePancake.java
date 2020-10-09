import java.util.ArrayList;

public class StatePancake {
    ArrayList<Integer> tuple;

    public StatePancake(ArrayList<Integer> input){
        tuple = input;
    }

    public String toString(){
        String result = "The tuple is: ";
        int size = tuple.size();
        for(int i=0; i< size; i++){
            result += tuple.get(i).toString() +" ";
        }
        return result+"\n";
    }
}
