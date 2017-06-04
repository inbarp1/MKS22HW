import java.util.*;
public class MazeSolver{
    private boolean starry, animate, complete;
    private Frontier front;
    private Maze amazing;

    public MazeSolver(String s){
	amazing = new Maze(s);
    }

    public MazeSolver(String s, boolean a){
	animate =a;
	amazing = new Maze(s);
    }
    
    public void solve(){
	solve(1);
    }
    private chooseStyle(int style){
	if(style==0){
	    front = new FrontierStack();
	}
	if(style==1){
	  front = new FrontierQueue();   
	}
	if(style==2){
	    front = new FrontierPriorityQueue();
	}
	if(style==3){
	    front = new FrontierPriorityQueue();
	    starry= true;
	}
    }
    public void solve(int style){
	complete= false;
	starry=false;
	chooseStyle(style);
	Location nextAddition;
	Location startL = amazing.getStart();
	Coordinate startC = new Coordinate(startL.getRow(), startL.getColumn());
	Location endL = amazing.getEnd();
	Coordinate endC = new Coordinate(endL.getRow(), endL.getColumn());
	ArrayList<Location> n = getn(startL, startC, endC);
	while(!n.isEmpty()){
	    Location l = n.remove(0); 
	    front.add(l);
	}
	int i = 0;
	while(front.size()> 0 && !complete){
	    	while(!n.isEmpty()){
	        Location l = n.remove(0); 
		front.add(l);
		}
	    Location loc = front.next();
	    if(loc.equals(endL)){
		complete(loc);
	    }
	    else{
		 amazing.set(loc.getRow(), loc.getColumn(), '.');
	    }
	
	    n = getn(loc, startC, endC);
	    if(animate){
		    System.out.println(amazing.toString(10));
		}
		else{
		    System.out.println(amazing);
		}
	}
    }
	private int distanceCalc(Coordinate one, Coordinate two){
	    return Math.abs(one.ycor - one.ycor)+ Math.abs(one.xcor - two.xcor);
	}
	    
	private ArrayList<Location> getn(Location p, Coordinate s, Coordinate e){
	    ArrayList<Location> n= new ArrayList<Location>();
	    int r = p.getRow();
	    int c = p.getColumn();
	    char l = amazing.get(r, c-1);
	    char ri = amazing.get(r, c +1);
	    char t = amazing.get(r-1,c);
	    char b = amazing.get(r+1, c);
	    if(t ==' '){
		Coordinate curr = new Coordinate(r-1, c);
		n.add(new Location(r -1, c, p, distanceCalc(s, curr), distanceCalc(e, curr)));
	    }	    
	    if( b  == ' '){
		Coordinate curr = new Coordinate(r+1, c);
		n.add(new Location(r +1, c, p, distanceCalc(s, curr), distanceCalc(e, curr)));
	    }
	    if(l == ' '){
		Coordinate curr = new Coordinate(r, c-1);
		n.add(new Location(r, c-1, p, distanceCalc(s, curr), distanceCalc(e, curr)));
	    }
	    if(ri == ' '){
		Coordinate curr = new Coordinate(r, c+1);
		n.add(new Location(r, c+1, p, distanceCalc(s, curr), distanceCalc(e, curr)));
	    }
	    return n;
	}
    			   
		
	   
	private void complete(Location e){
	    complete = true;
	    amazing.set(e.getRow(), e.getColumn(), 'E');
	    while(e.getPrevious()!=null){
		e = e.getPrevious();
		amazing.set(e.getRow(), e.getColumn(), '@');
	    }
	}

    
    }
