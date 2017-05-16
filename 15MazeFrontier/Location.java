public class Location implements Comparable<Location>{
    private int distToGoal,row, col, distToStart;
    private Location previous;
    private boolean aStar; 
    public Location(int r, int c, Location p, int dts, int dtg, boolean imAstar){
	row = r;
	col = c; 
	previous = p;
	distToStart= dts;
	distToGoal=dtg;
	aStar= imAstar;
    }
    public boolean isAStar(){
	return aStar;
    }
    public int getRow(){
	return row;
    }
    public int getColumn(){
	return col;
    }
    public int getDistToGoal(){
	return distToGoal;
    }
    public int getDistToStart(){
	return distToStart;
    }
    public Location getPrevious(){
	return previous;
    }
    public int compareTo(Location other){
	if(this.isAStar()){
	    int totalD= this.getDistToStart()+ this.getDistToGoal();
	    int totalDOther=other.getDistToStart()+ other.getDistToGoal();
	    if(totalD>totalDOther){
		return 1;
	    }
	    if(totalD==totalDOther){
		return 0;
	    }
	    return -1;
	}
	else{
	    if(this.getDistToGoal()>other.getDistToGoal()){
		return 1;
	    }
	    if(this.getDistToGoal()==other.getDistToGoal()){
		return 0;
	    }
	    return -1;
	}
    }
	
    
}
	
