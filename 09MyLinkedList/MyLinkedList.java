import java.util.*
    public class MyLinkedList{
	LNode start;
	int size;
	import java.util.*;
	public class LNode{
	    int value;
	    LNode next;
	    public LNode(int val, LNode ref){
		value=val;
		next=ref;
	    }
	    public LNode(int val){
		value=val;
		next=null;
	    }
	}
	public boolean add(int value){
	    LNode x = new LNode(value,start);
	    size+=1;
	    return true;
	}
	//adds to front 
	public int size(){
	    return size;
	}
	public String toString(){
	    String final = "[";
	    LNode current = start;
	    while(LNode.next=!null){
		final+=Integer.toString(LNode.value)+",";
		current= current.next;
	    }
	    final+=Integer.toString(LNode.value)+"]";
	    return final;
	}
	public int get(int index){
	}
	//return value of specified element
	public int set(int index, int newValue){
	}
	//changes val at specified index and returns old value
    }
