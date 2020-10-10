import java.util.*;

public class StateCannibals 
{    
    int canArray[];
    
    public StateCannibals(int[] canArray) { 
        this.canArray = canArray; 
    }
    
    public StateCannibals(StateCannibals state) {
    	canArray = new int[6];
        for(int i=0; i<6; i++) 
            this.canArray[i] = state.canArray[i];
    }
    
    public boolean equals(Object o){
        StateCannibals state = (StateCannibals) o;
        
        for (int i=0; i<6; i++)
            if (this.canArray[i] != state.canArray[i])
                return false;
        
        return true;
    }
    
    public int hashCode() {
        return Arrays.hashCode(canArray);
    }    
    
    public String toString()
    {
        String result = "";
        for (int i=0; i<6; i++)
            result += " " + this.canArray[i];
        return result;
    }
}