import java.util.*;
    public class MyHeap{
	private int size;
	private ArrayList<Location> maHeap;
	private int  maxOrmin;
	public MyHeap(){
	    size =0;
	    maHeap  = new ArrayList<Location>();
	    maHeap.add(null);
	    maxOrmin=1;
	    
	}
	public MyHeap(boolean mm){
	    if(mm){
		maxOrmin= 1;
	    }
	    else{
		maxOrmin = -1;
	    }
	    maHeap  = new ArrayList<Location>();
	    maHeap.add(null);
	}
   
	public String toString(){
	    String f = "";
	    for(int i=0; i<=size; i++){
		f+= maHeap.get(i) + " ";
	    }
	    return f;
	}
	      
	public void add(Location s){
	    maHeap.add(s);
	    if(size >= 2){
		pushUp(size);
	    }
	    size+=1;
	}
	public Location remove(){
	    Location  oldie = maHeap.get(1);
	    maHeap.set(1, maHeap.get(size));
	    pushDown(1);
	    size--;
	    return oldie; 
	}
	public Location  peek(){
	    return maHeap.get(0);
	}
        
	    
	private void pushUp(int i){
	    if(myCompareTo(maHeap.get(i),maHeap.get(i/2))&& i/2> 0){
		Location  oldie = maHeap.get(i/2);
		maHeap.set(i/2, maHeap.get(i));
		maHeap.set(i, oldie);
		pushUp(i/2);
	    }
	}
	private void pushDown(int i){
	    if( 2 * i + 1 <= size){
		Location  parent  =  (maHeap.get(i));
		Location  firstKid =( maHeap.get(2*i+1));
		Location  secondKid= (maHeap.get(2*i));
	    if(parent.compareTo(firstKid) < 1 || parent.compareTo(secondKid) < 1){
		if(myCompareTo(firstKid, secondKid)){
		    maHeap.set(2*i+1, parent);
		    maHeap.set(i, firstKid);
		    pushDown(2*i+1);
		    
		    }
		else{
		    maHeap.set(2*i, parent);
		    maHeap.set(i, secondKid);
		    pushDown(2*i);
		}
	    }
	    }
	}
	     	    
	private  boolean myCompareTo(Location  a,Location b){
	    return a.compareTo(b) >= 0;
	}
	
	public int getSize(){
	    return size;
	}

    }
