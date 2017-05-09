import java.util.*;
    public class MyHeap{
	private int size;
	private ArrayList<Integer> maHeap;
	private int  maxOrmin;
	public MyHeap(){
	    size =0;
	    maHeap  = new ArrayList<Integer>(10000);
	    maHeap.add(1234567890);
	    
	}
	public MyHeap(boolean mm){
	    if(mm){
		maxOrmin= 1;
	    }
	    else{
		maxOrmin = -1;
	    }
	    maHeap  = new ArrayList<Integer>();
	    maHeap.add(null);
	}
   
	public String toString(){
	    String f = "";
	    for(int i=0; i<=size; i++){
		f+= maHeap.get(i) + " ";
	    }
	    return f;
	}
	      
	public void add(int s){
	    Integer n = new Integer(s);
	    maHeap.add(n);
	    if(size >= 2){
		pushUp(size);
	    }
	    size+=1;
	}
	public int remove(){
	    Integer  oldie = maHeap.get(1);
	    maHeap.set(1, maHeap.get(size));
	    pushDown(1);
	    size--;
	    return oldie.intValue(); 
	}
	public int  peek(){
	    return maHeap.get(0);
	}
        
	    
	private void pushUp(int i){
	    if(myCompareTo(maHeap.get(i),maHeap.get(i/2))&& i/2> 0){
		int oldie = maHeap.get(i/2);
		maHeap.set(i/2, maHeap.get(i));
		maHeap.set(i, oldie);
		pushUp(i/2);
	    }
	}
	private void pushDown(int i){
	    if( 2 * i + 1 <= size){
		Integer  parent  =  (maHeap.get(i));
		Integer  firstKid =( maHeap.get(2*i+1));
		Integer secondKid= (maHeap.get(2*i));
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
	     	    
	private  boolean myCompareTo(Integer  a,Integer b){
	    return a.compareTo(b) >= 0;
	}
	
	public int getSize(){
	    return size;
	}

    }
