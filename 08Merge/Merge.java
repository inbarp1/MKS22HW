import java.util.*;
public class Merge{
    public static void mergesort(int[]ary){
	int[] right;
	int[]left;
	System.out.println(toString(ary));				    
	if(ary.length<=1){
	    System.out.println("im the basecase!! and ive reached myself");
	}
	else{
	    int arysize= ary.length;
	    if(arysize%2==0){
		 left = new int[arysize/2] ;
		 right = new int[arysize/2];
	    }
	    else{
		left = new int[arysize/2] ;
		right = new int[arysize/2-1];
	    }
	    for(int i =0; i<(arysize/2); i++){
		left[i]=ary[i];
		if(i<right.length){
		    right[i]= ary[i+arysize/2];
		}
	    }
	    System.out.println("left:");
	     System.out.println(toString(right));
	    System.out.println("right:");
	    System.out.println(toString(right));
	    mergesort(left);
	    if(right.length==1){
	    }
	    else{
		mergesort(right);
	    }
	    System.out.println("IM MERGING!"+ arysize/2);
	    merge(ary, left, right);
	    System.out.println("I MERGED YO ");

	}
    }
    public static void merge(int[]ary, int[]left, int[]right){
	int i= 0;
	int j=0;
        int x=0;
	System.out.println(toString(ary));
	while(x<ary.length){
	    if(i<left.length && j<right.length){
		if(left[i]<=right[j]){
		    ary[x]=left[i];
		    i++;
		    x++;
		}
		else{
		    ary[x]=right[j];
		    j++;
		    x++;
		}}
	    else {
		System.out.println("heyyo im i:" +i+left.length + " and im j:" + j+right.lengt+ " and im x" + x+ " and this is the length"+ ary.length);
		while(i<left.length){
		    ary[x]=left[i];
		    i++;
		    x++;
		}
		while(j<right.length){
		    ary[x]=right[j];
		    j++;
		    x++;
		}
	    }
	}	    
    }
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
		System.out.println(toString(ary));
		mergesort(ary);
		System.out.println(toString(ary));
   }
}
	
		
	
