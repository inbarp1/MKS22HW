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

	public LNode(int val, LNode pre){
	    value=val;
	    next=null;
	    prev=pre;
	}
	public String toString(){
	    String f="";
	    if(prev==null){
		f+="(null)";
	}
	else{
	    f+="("+ prev.value +")";
		}
	    
	    f+=value;
	  if(next==null){
		f+="(null)";
	}
	else{
	    f+="("+ next.value +")";
		}
	  return f;
	}
    }
	public boolean addtoStart(int value){
	    LNode x = new LNode(value);
	    if(start==null){
		start=x;
		size++;
		    }
	    else{
	    x.next=start;
	    start.prev=x;
	    start=x;
	    size+=1;
	    }
	    return true;
	}
    public boolean add(int value){
	LNode current = start;
	//System.out.println(start.value);
	while(current.next!=null){
	    current = current.next;
	    //System.out.println(current.value);
	}
	current.next = new LNode(value,current);
	size++;
	end =current.next;
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
		fin+=current.toString();
		fin+= " ";
		current= current.next;
	    }
	    fin+=current.toString()+"]";
	    return fin;
	}
    public  int get(int index){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}  
	LNode current = this.getNode(index);
        return current.value;
    }
        	//return value of specified element
    public        int set(int index, int newValue){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}  
	LNode current = this.getNode(index);
	int oldie = current.value;
	current.value = newValue;
	return oldie;
    }
    public   int indexOf(int value){
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
	System.out.println(current.toString());
	if(index==size){
	    this.add(value);
	}
	else{
	    current = this.getNode(index);
	    System.out.println(current.toString());
	}
        LNode newbie = new LNode(value);
	System.out.println("inserting before");
	insertBefore(newbie, current);
    }
    
    public int remove(int index){
	if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}
	else{
	LNode current = this.getNode(index);
	int val = current.value;
        remove(current);
	size--;
	return val;
	}
    }
    private LNode getNode(int index){
	LNode current = start;
	while(index!=0){
	    current = current.next;
	    index--;
	}
	return current;
    }

    
private void remove(LNode x){
    if(start!=x && end!=x){
	(x.prev).next=x.next;
	(x.next).prev=x.prev;
    }
    else{
	if(start==x){
	    start=x.next;
	    (x.next).prev = null;
	}
	if(end==x){
	    end=x.prev;
	    (x.prev).next= null;
	}
    }
}
private void insertAfter(LNode toBeAdded, LNode location){
    System.out.println(end.toString());
    if(end!=location){
	System.out.println("running end!=loc code");
	(location.next).prev= toBeAdded;
	location.next = toBeAdded;
	toBeAdded.prev= location;
	toBeAdded.next= location.next;
    }
    else{
	location.next = toBeAdded;
	toBeAdded.prev= location;
	toBeAdded.next= null;
    }
    size++;     
}
private void insertBefore(LNode toBeAdded, LNode location){
    if(start!=location){
	(location.next).prev = toBeAdded;
	toBeAdded.next= location;
	toBeAdded.prev= location.prev;
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
	System.out.println(l.toString());
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
