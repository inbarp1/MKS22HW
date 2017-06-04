import java.util.*;
public class FrontierStack implements Frontier{
    private int size;
    private Stack<Location> allLs;

    public FrontierStack(){
       allLs= new Stack<Location>();
       size = 0;
    }
    
    public int size(){
	return allLs.size();
    }
    
    public String toString(){
	return allLs.toString();
    }
    
    public Location next(){
	size --;
	return allLs.pop();
    }
    
    public void add(Location loc){
	allLs.push(loc);
	size++;
    }
    
}
