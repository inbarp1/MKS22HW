import java.util.*;
public class MyLinkedList{
	LNode start;
	int size;
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
	public boolean addtoStart(int value){
	    LNode x = new LNode(value,start);
	    size+=1;
	    return true;
	}
    public boolean add(int value){
	LNode current = start;
	while(current!=null){
	    current = current.next;
	}
	current.next = new LNode(value);
	return true;
    }
	//adds to front 
	public int size(){
	    return size;
	}
	public String toString(){
	    String fin = "[";
	    LNode current = start;
	    while(current.next!= null){
		fin+=Integer.toString(current.value)+",";
		current= current.next;
	    }
	    fin+=Integer.toString(current.value)+"]";
	    return fin;
	}
    public int get(int index){
	LNode current = start;
        while(index!=0){
	    current= current.next;
	    index--;
	}
	return current.value;
    }
        	//return value of specified element
    public int set(int index, int newValue){
	LNode current = start;
	while(index!=0){
	    current = current.next;
	    index--;
	}
	int oldie = current.value;
	current.value = newValue;
	return oldie;
    }
	//changes val at specified index and returns old value
}
