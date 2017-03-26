import java.util.*;
public class Merge{
    public static void mergesort(int[]ary){
	int[] right;
	int[]left;
	//System.out.println(toString(ary));				    
	if(ary.length<=1){
	    //System.out.println("im the basecase!! and ive reached myself");
	}
	else{
	    int arysize= ary.length;
	    if(arysize%2==0){
		 left = new int[arysize/2] ;
		 right = new int[arysize/2];
	    }
	    else{
		left = new int[arysize/2+1] ;
		right = new int[arysize/2];
	    }
	    for(int i =0; i<(arysize/2); i++){
		left[i]=ary[i];
		if(i<right.length){
		    right[i]= ary[i+arysize/2];
		}
	    }
	    //System.out.println("left:");
	    // System.out.println(toString(left));
	    // System.out.println("right:");
	    // System.out.println(toString(right));
	    mergesort(left);
	    if(right.length==1){
	    }
	    else{
		mergesort(right);
	    }
	    // System.out.println("IM MERGING!"+ arysize/2);
	    merge(ary, left, right);
	    // System.out.println("I MERGED YO ");

	}
    }
    public static void merge(int[]ary, int[]left, int[]right){
	int i=0;
	int j=0;
        int x=0;
	//System.out.println(toString(ary));
	while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                ary[x] = left[i];
                i++;
            }
            else{
                ary[x] = right[j];
                j++;
            }
            x++;
        }
	//System.out.println("up to" + x);
	//System.out.println(toString(ary));
        if(j < right.length){
            for(;j < right.length;j++,x++){
                ary[x] = right[j];
            }
        }
        else{
            for(;i < left.length;i++,x++){
                ary[x] = left[i];
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
       
    }
}
	
		
	
