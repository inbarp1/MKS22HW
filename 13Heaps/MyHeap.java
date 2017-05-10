import java.util.*;
    public class MyHeap{
	private int size;
	private ArrayList<String> maHeap;
	private int  maxOrmin;
	public MyHeap(){
	    size =0;
	    maHeap  = new ArrayList<String>(10000);
	    maHeap.add(""); 
	    
	}
	public MyHeap(boolean mm){
	    if(mm){
		maxOrmin= 1;
	    }
	    else{
		maxOrmin = -1;
	    }
	    maHeap  = new ArrayList<String>();
	    maHeap.add(null);
	}
   
	public String toString(){
	    String f = "";
	    for(int i=0; i<=size; i++){
		f+= maHeap.get(i) + " ";
	    }
	    return f;
	}
	      
	public void add(String s){
	    maHeap.add(s);
	    if(size >= 2){
		pushUp(size);
	    }
	    size+=1;
	}
	public String remove(){
	    String oldie = maHeap.get(1);
	    maHeap.set(1, maHeap.get(size));
	    pushDown(1);
	    size--;
	    return oldie; 
	}
	public String  peek(){
	    return maHeap.get(0);
	}
        
	    
	private void pushUp(int i){
	    if(myCompareTo(maHeap.get(i),maHeap.get(i/2))&& i/2> 0){
		String oldie = maHeap.get(i/2);
		maHeap.set(i/2, maHeap.get(i));
		maHeap.set(i, oldie);
		pushUp(i/2);
	    }
	}
	private void pushDown(int i){
	    if( 2 * i + 1 <= size){
	    String parent  =  maHeap.get(i);
	    String firstKid = maHeap.get(2*i+1);
	    String secondKid= maHeap.get(2*i);
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
	     	    
	private  boolean myCompareTo(String a, String b){
	    return a.compareTo(b) * maxOrmin >= 0;
	}

	
	public int getSize(){
	    return size;
	}
	public static void main(String[] args){
	MyHeap h = new MyHeap(true);
        String[] test = {"i","f","g","h","c","a","b","d","e"};
        for (String s : test) {
            h.add(s);
            System.out.println(h);
	}       
	for (String s : test) {
	    h.remove();
	    System.out.println(h);
	 }
    }
    }
