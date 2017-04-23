import java.util.*;
public class MyDeque{
    int front, back,size;
    String[] Thedeque;
    boolean isEmpty;
    public MyDeque(){
        isEmpty=true;
	Thedeque=new String[10];
	size=0;
    }
    public void print() {
	String s = "";
	for(int i=0; i<Thedeque.length; i++){
	    s+=Thedeque[i] + "] [";
	}
	System.out.println(s);
	System.out.println(front);
	System.out.println(back);
    }
    public void addFirst(String s){
	if(s== null){
	    throw new NullPointerException();
	}		
	else{
	    if(size==Thedeque.length){
		resize();
	    }
	    if ( isEmpty ) {
		front=1;
		back=1;
	    } else {
		front--;
		if(front<0){
		    front=Thedeque.length -1;
		}
	    }
	    Thedeque[front]=s;
	    isEmpty=false;
	    size++;
	}
    }
    
    public void addLast(String s){
	if(s == null){
	    throw new NullPointerException();
	}
	else{
	    if(isEmpty){
		front=-1;
		back=-1;
	    }
	    if(size== Thedeque.length-1){
		resize();
	    }
	    back++;
	   
	    if(back== Thedeque.length-1){
		back=0;
	    }
	    Thedeque[back]=s;
	    isEmpty=false;
	    size++;
	}	    
    }
    private void resize(){
	String[]resized = new String[Thedeque.length*2];
	for(int i= 0; i<Thedeque.length; i++){
	    resized[i]= Thedeque[i];
	}
	Thedeque= resized;    	    
    }
    //NullPointerException
    public void removeFirst(){
	if(isEmpty){
	    throw new NoSuchElementException();
		}
	else{
	    if(front==back){
		isEmpty=true;
	    }
	    Thedeque[front]= null;
	    front++;
	    if(front==Thedeque.length){
		front=0;
	    }
	    size--;
	}
    }
    public void removeLast(){
	if(isEmpty){
	    throw new NoSuchElementException();
	}
	else{
	    if(front==back){
		isEmpty=true;
	    }
	    Thedeque[back]=null;
	    back--;
	    System.out.println("removed and now " + Thedeque[back]);
	    if(back<0){
		back=Thedeque.length-1;
	    }		
	}
    }
    //NoSuchElementException
    public String getFirst(){
	if(isEmpty){
	    throw new NoSuchElementException();
	}
	return Thedeque[front];
    }
    public String getLast(){
	if(isEmpty){
	    throw new NoSuchElementException();
	}
	return Thedeque[back];
    }
    public static void main(String[] args){
	MyDeque d = new MyDeque();
	d.addFirst("my");
	d.addLast("name");
	d.addLast("is");
       	d.addFirst("Hi");
	d.addLast("Inbar");
        d.addLast("!");
	d.addLast("!");
	d.addLast("!");
	d.addLast("!");
	d.addLast("!");
	d.addLast("!");
	d.addLast("!");
	d.addLast("!");
	d.addLast("!");
	d.addLast("/");	  
	//System.out.println(d.getFirst());
	//System.out.println(d.getLast());
	d.print();
    }
	
	
}
