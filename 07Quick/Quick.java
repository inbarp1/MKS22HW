import java.util.*;
public class Quick{
    public static void quicksort(int[] data){
	qsh(data, 0, data.length -1); 
    }
    public static void qsh(int[] data, int start, int end){
	//	System.out.println(toString(data));
       	//System.out.println(start+" to "+end);
	if(start>=end){
	    //  System.out.println("I have arrived" + start + end);

	}
	else{
	    Random random = new Random();
	    int limit = end - start + 1 ;
	    int parter = random.nextInt(limit) + start;
	    int v = data[parter];
	    int n =start;
	    int lt=start;
	    int gf=end;
	    int j=end;
	    //System.out.println("v "+v);
	    while(n<=gf){
		//System.out.println("v:"+v+ " lt:"+lt+" gf:"+gf+" j:"+j+ " n"+n);
		if(data[n]==v){
		    	n++;
		    }
		else if(data[n]<v){
		    swap(data,n,lt);
		    lt++;
		    n++;
		}
		else{
		    swap(data,n,gf);
		    gf--;
			}
	    }
	    //System.out.println("out of loop. will recurse ["+start+","+lt+") and ("+gf+","+end+")");
	    //System.out.println("the i" + i);
	    if(lt==gf){
		qsh(data, start, lt);
		qsh(data,gf+1,end);
	    }
	    else{
	    qsh(data, start, lt);
	    qsh(data, gf, end);
	    }
	}
	
    }
	public static int quickselect(int []data, int k){
	    //System.out.println(toString(data));
	int start = 0;
	int end = data.length - 1;
	return quickSelectHelper(data, start, end, k);
	}
        
       	
    
	
    public static int quickSelectHelper(int[]data, int start, int end, int k){
	int check = part(data, start, end);
	 if(check==k){
	     System.out.println("FINISHED");
	    return data[check];
	 }
	else{
	    if(check > k){
		return quickSelectHelper(data,start,check, k); 
		// look at smaller half
	    }
	    else{
		return quickSelectHelper(data,check,end, k);
		//looking at the larger half of the array
	    }
	}
	 
    }
    // this is a  helper fxn that runs recursively 
    public static int part(int[]data, int start, int end){
	    Random random = new Random();
	    int limit = end - start + 1 ;
	    int parter = random.nextInt(limit) + start;
	    int v = data[parter];
	    int n =start;
	    int lt=start;
	    int gf=end;
	    int j=end;
	    System.out.println("v "+v);
	    while(n<=gf){
		//System.out.println("v:"+v+ " lt:"+lt+" gf:"+gf+" j:"+j+ " n"+n);
		if(data[n]==v){
		    	n++;
		    }
		else if(data[n]<v){
		    swap(data,n,lt);
		    lt++;
		    n++;
		}
		else{
		    swap(data,n,gf);
		    gf--;
			}
	    }
	    return lt;
    }
	   
	  
    public static int partTRY(int[] data, int start, int end){
	//System.out.println(toString(data));
	Random random = new Random();
	int limit = end - start + 1 ;
	int parter = random.nextInt(limit) + start;
       	int parterVal = data[parter];
	//System.out.println("this is the partition value");
	//System.out.println(parterVal);
	boolean needToContinue = true;
	int movehere= sweepThru(data, start, end, parterVal);
       	//System.out.println("this is where its moving");
	//System.out.println(movehere+start);
	swap(data, movehere+start,parter);
	//System.out.println(toString(data));
	while(needToContinue){
	    int a = findElement(data,movehere+start,start, false);
	    int b = findElement(data, movehere+start,end, true);
	    if( a!= -1 &&  b!=-1){
		swap(data, a, b);
	    }
	    else{
		needToContinue = false;
	    }
	    //in place partitioning
	}
	//System.out.println("after part");   
	//System.out.println(toString(data));
	return movehere;
       
    }
    private static int sweepThru(int[]data, int start, int end, int val){
	int count = 0;
	for(int i = start; i<=end; i++){
	    if(data[i]<val){
		count++;
	    }
	}
	return count;
	// returns the proper index for the element ur looking at by counting vals smaller than it. 
    }
			   
    private static void  swap(int[] data, int a, int b){
	int change= data[a];
	data[a]=data[b];
	data[b]=change;	
    }
    private static int findElement(int[]data, int end, int startplace, boolean side){
	int pivot = data[end];
	// true is right, false is left
	if(side){
	    for(int i=startplace; i>end; i--){
		if(data[i]<pivot){
		    return i;
		}
	    }
	    return -1;
	}
	else{
	    for(int i =startplace; i<end; i++){
		if(data[i]> pivot){
		    return i;
			}
	    }
	    return -1;
	}
    }
    //checks to see if there are values larger than the element or smaller than it on the wrong side
    
public static String toString(int[]ary){
	String b = "";
	for(int i = 0; i < ary.length; i++){
		b+= Integer.toString(ary[i]);
		b += ",";
	}
	return b;
}
	public static void main(String[] args){
		int [] ary = new int[9];
		ary[0]=3;
		ary[1]=8;
		ary[2]=5;
		ary[3]=5;
		ary[4]=5;
		ary[5]=8;
		ary[6]=2;
		ary[7]=8;
		ary[8]=6;
		//System.out.println(toString(ary));		   
		//System.out.println(part(ary, 0, 8));
		//System.out.println(quickselect(ary,2));
		//System.out.println(toString(ary));
		//quicksort(ary);		   
		//System.out.println(toString(ary));		   

	}
}
    

