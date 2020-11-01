

public class StateNim extends State {
    public int human;
    public int rest;
    public int computer;

    public StateNim(){
        human = 0;
        rest = 13;
        computer = 0;
        player = 1;
    }
    public StateNim(StateNim pre, int t){
        if(pre.player == 0){
            player = 1;
            human = pre.human;
            computer = pre.computer+t;
            rest = pre.rest - t;
        }
        else{
            player = 0;
            human = pre.human+t;
            computer = pre.computer;
            rest = pre.rest - t;
        }
    }

    public String toString(){
        return "Human: "+human+" ; Rest: "+rest+" ; Computer: "+computer;
    }
}
