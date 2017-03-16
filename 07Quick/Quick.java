import java.util.*;
public class Quick{
	public static int quickselect(int []data, int k){
	    //System.out.println(toString(data));
	int start = 0;
	int end = data.length - 1;
	return quickSelectHelper(data, start, end, k);
	}
        
       	

	
    public static int quickSelectHelper(int[]data, int start, int end, int k){
	int check = part(data, start, end);
	 if(check==k){
	    return data[check];
	 }
	else{
	    if(check > k){
		return quickSelectHelper(data,start,check, k); 
		// look at smaller half
	    }
	    else{
		return quickSelectHelper(data,check,end, k-check);
		//have to reduce the k value bc you are looking at the larger half of the array
	    }
	}
	 
    }
    // this is a  helper fxn that runs recursively 
	
    public static int part(int[] data, int start, int end){
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
	//System.out.println(movehere);
	swap(data, movehere,parter);
	//System.out.println(toString(data));
	while(needToContinue){
	    int a = findElement(data,movehere,start, false);
	    int b = findElement(data, movehere,end, true);
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
	for(int i = start; i<end; i++){
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
		int [] ary = new int[8];
		ary[0]=2;
		ary[1]=7;
		ary[2]=5;
		ary[3]=9;
		ary[4]=1;
		ary[5]=13;
		ary[6]=6;
		ary[7]=19;
		//System.out.println(part(ary, 0, 7));
		//System.out.println(quickselect(ary,5));

	}
}
    

	    
