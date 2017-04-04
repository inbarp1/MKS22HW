import java.util.*;
public class MyLinkedList{
    LNode start;
    int size;
    LNode end;
    
    
    public MyLinkedList(){
	start = null;
	end = null;
	size =0;
    }
    public class LNode{
	int value;
	LNode next;
	LNode prev;
       
	public LNode(int val, LNode nex, LNode pre){
		value=val;
		next=nex;
		prev= pre;
	    }
	    public LNode(int val){
		value=val;
		next=null;
		prev=null;
	    }
	public LNode(int val, LNode nex){
	    value=val;
	    next=nex;
	    prev=null;
	}
	public LNode(int val, LNode pre){
	    value=val;
	    next=null;
	    prev=pre;
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
    public static int get(int index){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}  
	LNode current = this.getNode(current);
        return current.value;
    }
        	//return value of specified element
    public static int set(int index, int newValue){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}  
	LNode current = this.getNode(index);
	int oldie = current.value;
	current.value = newValue;
	return oldie;
    }
    public static  int indexOf(int value){
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
	    current = this.getNode(index);
	}
	LNode oldie = new LNode(current.value,current.next);
	current.value = value;
	current.next = oldie;
	size++;
	}
    }
    public static int remove(int index){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}   
	LNode current = this.getNode(index);
        remove(current);
	size--;
	return val;
    }
    private LNode getNode(index){
	LNode current = start;
	while(index!=0){
	    current = current.next;
	    index--;
	}
	return current;

    }
private void remove(LNode x){
    if(start!=x && end!=x){
	(x.prev).next=x,nest;
	(x.next).prev=x.prev;
    }
    else{
	if(start=x){
	    start=x.next;
	    (x.next).prev = null;
	}
	if(end=x){
	    end=x.prev;
	    (x.prev).next= null;
	}
    }
}
private void insertAfter(node toBeAdded, node location){
    if(end!=x){
	(location.next).prev= toBeAdded;
	location.next = toBeAdded;
	toBeAdded.prev= location;
	toBeadded.next= location.next;
    }
    else{
	location.next = toBeAdded;
	toBeAdded.prev= location;
	toBeAdded.next= null;
    }
    size--;     
}
private void insertBefore(node toBeAdded, node location){
    if(start!=x){
	(location.next).prev = toBeAdded;
	toBeAdded.next= location;
	toBeadded.prev= location.prev;
        (location.prev).next= toBeAdded;
    }
    else{
	location.prev = toBeAdded;
	toBeAdded.next= location;
	toBeAdded.prev= null;
    }
    size++;
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
