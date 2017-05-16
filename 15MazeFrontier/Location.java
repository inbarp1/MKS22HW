public class Location implements Comparable<Location>{
    private int distToGoal,row, col, distToStart;
    private Location previous;
    private boolean aStar; 
    public Location(int r, int c, Location p, int dts, int dtg){
	row = r;
	col = c; 
	previous = p;
	distToStart= dts;
	distToGoal; dtg; 
    }
	
