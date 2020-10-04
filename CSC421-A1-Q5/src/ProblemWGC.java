import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class ProblemWGC extends Problem{
    boolean goal_test(Object s) {
        StateWGC state = (StateWGC) s;
        if (state.rightBank.size() == 3 && state.boatPosition == 1){
            return true;
        }
        return false;
    }
    boolean sideVerify(Set<Integer> side){
        if(side.size() <2 || !side.contains(1)){
            return true;
        }
        return false;
    }
    boolean verify(Set<Integer> left, Set<Integer> right, int position){
        if(position == 0 ){
            return sideVerify(right);
        }
        else{
            return sideVerify(left);
        }
    }
    StateWGC move(int item, StateWGC state){
        Set<Integer> new_left = new HashSet<Integer>(state.leftBank);
        Set<Integer> new_right = new HashSet<Integer>(state.rightBank);
        int dest = (state.boatPosition ==0)? 1:0;
        if(item == -1){
        }
        else if(dest == 1){
            new_left.remove(item);
            new_right.add(item);
        }
        else if(dest == 0){
            new_left.add(item);
            new_right.remove(item);
        }
        if(!verify(new_left, new_right, dest)){
            return null;
        }
        return new StateWGC(new_left, new_right, dest);
    }
    Set<Object> getSuccessors(Object s) {
        StateWGC state = (StateWGC) s;
        Set<Object> set = new HashSet<Object>();
        StateWGC successor;
        if (state.boatPosition ==0){
            Iterator<Integer> it = state.leftBank.iterator();
            while(it.hasNext()){
                successor = move(it.next(), state);
                if(successor != null){
                    set.add(successor);
                }
            }
            successor = move(-1, state);
            if(successor != null){
                set.add(successor);
            }
        }
        else{
            for( int item : state.rightBank){
                successor = move(item, state);
                if(successor != null){
                    set.add(successor);
                }
            }
            successor = move(-1, state);
            if(successor != null){
                set.add(successor);
            }
        }
        return set;
    }

    double step_cost(Object fromState, Object toState) { return 1; }

    public double h(Object s) { 
         StateWGC state = (StateWGC)s; 
         return(state.leftBank.size());
    }

    public static void main(String[] args) throws Exception {
        Set<Integer> left = new HashSet<Integer>();
        Set<Integer> right = new HashSet<Integer>();
        ProblemWGC problem = new ProblemWGC();
        left.add(0);
        left.add(1);
        left.add(2);
        problem.initialState = new StateWGC(left, right, 0);

        Search search  = new Search(problem);

        System.out.println("TreeSearch------------------------");
		System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
		System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
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
    }
    
}