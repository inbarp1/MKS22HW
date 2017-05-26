import java.util.*;
public class MazeSolver{
    private boolean starry, animate, complete;
    private Frontier front;
    private Maze amazing;

    public MazeSolver(String s){
	amazing = new Maze(s);
    }

    publiv MazeSolver(String s, boolean a){
	animate =a;
	amazing = new Maze(s);
    }
    
    public void solve(){
	front= new FrontierQueue();
    }
