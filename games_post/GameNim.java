import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class GameNim extends Game{
    int WinningScore = 10;
    int LosingScore = -10;
    int NeutralScore = 0;  

    public GameNim(){
        currentState = new StateNim();
    }

    public boolean isWinState(State state){
        StateNim nstate = (StateNim) state;
        if(nstate.rest <= 0){
            return true;
        }
        return false;
    }

    public boolean isStuckState(State state){
        return false;
    }

    public Set<State> getSuccessors(State state)
    {
		if(isWinState(state) || isStuckState(state))
			return null;
		
		Set<State> successors = new HashSet<State>();
        StateNim nstate = (StateNim) state;
        
        StateNim successor_state;
        for(int i=1; i<=3; i++){
            successor_state = new StateNim(nstate, i);
            successors.add(successor_state);
        }
        return successors;
    }

    public double eval(State state){
        if(isWinState(state)) {
    		//player who made last move
    		int previous_player = (state.player==0 ? 1 : 0);
    	
	    	if (previous_player==1) //computer wins
	            return WinningScore;
	    	else //human wins
	            return LosingScore;
    	}

        return NeutralScore;
    }

    public static void main(String[] args) throws Exception {
        
        Game game = new GameNim(); 
        Search search = new Search(game);
        int depth = 13;
        int take;
        
        //needed to get human's move
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
        	
        	StateNim 	nextState = null;
        	
            switch ( game.currentState.player ) {
              case 1: //Human
                  
            	  //get human's move
                  System.out.print("Enter your *valid* take (1, 2 or 3)> ");
                  take = Integer.parseInt( in.readLine() );
            	  if(take < 1 || take > 3){
                    System.out.println("The value can only be 1, 2 or 3!");
                      continue;
                  }
                  nextState = new StateNim((StateNim)game.currentState, take);
                  nextState.player = 1;
                  System.out.println("Human takes "+take+": \n" + nextState);
                  break;
                  
              case 0: //Computer
            	  
            	  nextState = (StateNim)search.bestSuccessorState(depth);
                  nextState.player = 0;
                  take = nextState.computer-((StateNim)game.currentState).computer;
            	  System.out.println("Computer takes "+take+" : \n" + nextState);
                  break;
            }
                        
            game.currentState = nextState;
            //change player
            game.currentState.player = (game.currentState.player==0 ? 1 : 0);
            
            //Who wins?
            if ( game.isWinState(game.currentState) ) {
            
            	if (game.currentState.player == 0) //i.e. last move was by the computer
            		System.out.println("Computer wins!");
            	else
            		System.out.println("You win!");
            	
            	break;
            }
            
            if ( game.isStuckState(game.currentState) ) { 
            	System.out.println("Cat's game!");
            	break;
            }
        }
    }
}
