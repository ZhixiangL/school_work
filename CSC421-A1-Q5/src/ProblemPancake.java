import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

public class ProblemPancake extends Problem{
    boolean goal_test(Object s) {
        StatePancake state = (StatePancake) s;
        int size = state.tuple.size();
        for(int i=0; i < size; i++){
            if(state.tuple.get(i) != i){
                return false;
            }
        }
        return true;
    }
    StatePancake flip(StatePancake prev, int flipLayer){
        int size = prev.tuple.size();
        int i;
        ArrayList<Integer> flipped = new ArrayList<>(size);
        flipped.add(0);
        flipped.add(0);
        flipped.add(0);
        flipped.add(0);
        flipped.add(0);
        flipped.add(0);
        for(i=0; i<= flipLayer; i++){
            flipped.set(flipLayer - i, prev.tuple.get(i));
        }
        for(i=flipLayer+1; i<size; i++){
            flipped.set(i, prev.tuple.get(i));
        }
        return new StatePancake(flipped);
        
    }
    Set<Object> getSuccessors(Object s) {
        StatePancake state = (StatePancake) s;
        Set<Object> set = new HashSet<Object>();
        for(int i = 0; i < state.tuple.size(); i++){
            set.add(flip(state, i));
        }
        return set;
    }

    double step_cost(Object fromState, Object toState) {
        StatePancake from = (StatePancake) fromState;
        StatePancake to = (StatePancake) toState;
        int size = from.tuple.size();
        for(int i=size-1; i>=0; i--){
            if(from.tuple.get(i) != to.tuple.get(i)){
                return i+1;
            }
        }
        return 1;
    }

    public double h(Object s) { 
        StatePancake state = (StatePancake) s; 
        int size = state.tuple.size();
        int h=0;
        for(int i=0; i<size-1; i++){
            h += Math.abs(state.tuple.get(i) - state.tuple.get(i+1));
        }
        return h;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        tuple.add(1);
        tuple.add(0);
        tuple.add(3);
        tuple.add(5);
        tuple.add(2);
        tuple.add(4);
        
        ProblemPancake problem = new ProblemPancake();
        problem.initialState = new StatePancake(tuple);
        Search search  = new Search(problem);

        System.out.println("TreeSearch------------------------");
		System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
		//System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
		System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
		System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
		System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());
		
		System.out.println("\n\nGraphSearch----------------------");
		System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
		System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
		System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
		System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
		System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());
		
		System.out.println("\n\nIterativeDeepening----------------------");
		System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
        System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
        System.out.println("TreeSearch------------------------");
        System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
    }
    
}