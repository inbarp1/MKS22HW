import java.util.*;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> allLocations;
    public FrontierQueue(){
	allLocations = new LinkedList<Location>();
    }
    public String toString(){
	return allLocations.toString();
    }
    public Location  next(){
	return allLocations.remove();
    }

    public void add(Location loc){
	allLocations.add(loc);
    }

    public int size(){
	return allLocations.size();
    }
}
