import java.util.*;
public class MyLinkedList{
	LNode start;
	int size;
    public MyLinkedList(){
	start = null;
	size =0;
    }
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
	    start=x;
	    size+=1;
	    return true;
	}
    public boolean add(int value){
	LNode current = start;
	//System.out.println(start.value);
	while(current.next!=null){
	    current = current.next;
	    //System.out.println(current.value);
	}
	current.next = new LNode(value);
	size++;
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
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}  
	LNode current = start;
        while(index!=0){
	    current= current.next;
	    index--;
	}
	return current.value;
    }
        	//return value of specified element
    public int set(int index, int newValue){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}  
	LNode current = start;
	while(index!=0){
	    current = current.next;
	    index--;
	}
	int oldie = current.value;
	current.value = newValue;
	return oldie;
    }
    public int indexOf(int value){
	LNode current=start;
	int index =0;
	while(current.value!=value){
	    current=current.next;
	    index++;
	    if(index==size){
		return -1;
	    }
	}
	return index;
    }
    public void add(int index, int value){
	if(index>size || index<0){
	    throw new IndexOutOfBoundsException();
	}   
	LNode current = start;
	if(index==size){
	    this.add(value);
	}
	else{
	while(index!=0){
	    current = current.next;
	    index--;
	}
	LNode oldie = new LNode(current.value,current.next);
	current.value = value;
	current.next = oldie;
	size++;
	}
    }
    public int remove(int index){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}   
	LNode current = start;
	while(index!=1){
	    current = current.next;
	    index--;
	}
	int val = (current.next).value;
	current.next= (current.next).next;
	size--;
	return val;
    }

	//changes val at specified index and returns old value
    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
	l.addtoStart(1);
	l.addtoStart(0);
	l.add(2);
	l.add(4);
	//System.out.println(l.toString());
	//System.out.println(l.get(2));
	// l.set(2,5);
	//System.out.println(l.toString());
	//System.out.println(l.indexOf(3));
	l.add(3,3);
	System.out.println(l.toString());
	//l.remove(3);
	//System.out.println(l.toString());
	//System.out.println(l.indexOf(6));
	l.add(5,6);
        System.out.println(l.toString());


    }

}
