public class Location implements Comparable<Location>{
    private int distToGoal,row, col, distToStart, totalD;
    private Location previous;
    private boolean aStar;
    public Location(int r, int c, Location p, int dts, int dtg){
	row = r;
	col = c; 
	previous = p;
	distToStart= dts;
	distToGoal=dtg;
	totalD= dts+dtg;
    }
    public Location(int r, int c, Location p, int dts, int dtg, boolean imAstar){
	row = r;
	col = c; 
	previous = p;
	distToStart= dts;
	distToGoal=dtg;
	aStar= imAstar;
	totalD= dts+dtg;
    }
    public String toString(){
	return "this location is : ("+ row + " , " + col + ")";
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
    public int getTotalDistance(){
	return totalD;
    }
    public int compareTo(Location other){
        if(aStar){
	    return totalD- other.getTotalDistance();
	}
	else{
	    return distToGoal-other.getDistToGoal();
	}
    }
    public boolean equals(Location other){
	if( (row == other.getRow()) && (col == other.getColumn())){
		return true;
	    }
	else {
	    return false;
	}	   
    }
	
    
}
	
