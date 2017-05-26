public class FrontierPriorityQueue implements Frontier{
    private int size;
    private MyHeap thelocations;
    public FrontierPriorityQueue(){
	thelocations = new MyHeap(false); 
    }
    public Location next(){
	size = size -1;
	return thelocations.remove();
    }
    public int size(){
	return size;
    }
    public void add(Location newbie){
	size = size +1;
	thelocations.add(newbie);
    }
    public String toString(){
	return thelocations.toString();
    }
}
