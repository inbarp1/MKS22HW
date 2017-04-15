import java.util.*;
public class MyLinkedList{

  private class LNode{
    LNode next,prev;
    int value;
    public LNode(int value){
      this.value=value;
    }
    public String toString(){
      return value+"";
    }
  }

  LNode head,tail;
  int size;

  public MyLinkedList(){
  }

  public int size(){
    return size;
  }

    
  private LNode getNthNode(int n){
      LNode current = head;
      while(n!=0){
	  current=current.next;
	  n--;
      }
      return current;
	  }
    
  private void addAfter(LNode location, LNode toBeAdded){
      if(location.next==null){
	  location.next=toBeAdded;
	  toBeAdded.prev=location;
	  toBeAdded.next=null;
	  tail = toBeAdded;
      }
      else{
	  (location.next).prev=toBeAdded;
	  toBeAdded.prev=location;
	  toBeAdded.next=location.next;
	  location.next=toBeAdded;
      }
      size++;
   }
    
  private void remove(LNode target){
      if(size==1){
	  head=null;
	  tail=null;
      }
      else{
      //System.out.println("here");
      if(target.prev==null){
	  //System.out.println("hi");
	  head=target.next;
	  (target.next).prev= null;  
	  if(target.next==null){
	      //System.out.println("hello");
	      tail=target.prev;
	      (target.prev).next=null;
	  }
      }
      else{
	  if(target.next==null){
	      //System.out.println("hello");
	      tail=target.prev;
	      (target.prev).next=null;
	  }
	  else{
	      //System.out.println("hey");
	(target.prev).next=target.next;
	(target.next).prev=target.prev;
	  }
      }
      }
       size--;
       
    }

  public String toString(){
      String fin = "[";
      LNode current = head;
      if(size==0){
	  return "";
      }
      else{
	  
      while(current.next!= null){
	  fin+=current.toString();
	  fin+= " ";
	  current= current.next;
      }
      fin+=current.toString()+"]";
      return fin;
      }
  }
    

  public boolean add(int value){
      if(size==0){
	  LNode newNode = new LNode(value);
	    if(head==null){
		head=newNode;
	    }
      }
	    
      else{
      LNode current = this.getNthNode(size-1);
      current.next= new LNode(value);
      (current.next).prev = current;
      (current.next).next = null;
      tail= current.next;
      }
      size++;
      return true;
  }

  public int get(int index){
      if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}  
	LNode current = this.getNthNode(index);
        return current.value;
  }

  public int set(int index, int value){
      if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}
      LNode current = this.getNthNode(index); 
      int old = current.value;
      current.value= value;
      return old;
  }

  public int indexOf(int value){
      LNode current = head;
      int index= 0;
      while(current.value!=value){
	    current=current.next;
	    index++;
	    if(index==size){
		return -1;
	    }
	}
	return index;
  }
	  
  public int remove(int index){
       if(index>=size || index<0){
	    throw new IndexOutOfBoundsException();
	}
      else{
	  LNode current = this.getNthNode(index);
	  int val = current.value;
	  remove(current);
	  return val;
      }
  }

  public void add(int index,int value){
    if(index>size || index<0){
	    throw new IndexOutOfBoundsException();
    }
    else{
	if(index== 0){
	    LNode newNode = new LNode(value);
	    if(head==null){
		head=newNode;
	    }
	    else{
		newNode.next=head;
		head.prev=newNode;
		head=newNode;
	    }
	    size++;	
	}
	else{
	LNode current = this.getNthNode(index-1);
	LNode newNode  = new LNode(value);
	this.addAfter(current,newNode);
	}
    }
  }
     public static void main(String[] args){
        MyLinkedList test = new MyLinkedList();

        for(int i = 0; i < 10; i++){
            test.add(i);
            //System.out.println(test.size);
            //System.out.println(test);
        }

        System.out.println("added");


        for(int i = 0; i < 10; i++){
            test.set(i, i + 15);
	    //System.out.println(test);
        }

        System.out.println("setted");

        for(int i = 0; i < 10; i++){
            test.remove(0);
            //System.out.println("Removed");
            //System.out.println(test);
	    // System.out.println("");
        }
    }
    
}
