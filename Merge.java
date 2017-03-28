public class Merge {
    public static mergesort(int[] ary){
	if(ary.length==1){
	}
	else{
	    if(ary.length%2==0){
		int[]left = new int[ary.length/2];
		int[]right = new int[ary.length/2];
	    }
	    else{
		int[]left= new int[ary.length/2];
		int[]right = new int[ary.lenth/2 -1];
	    }
	    for(int i= 0; int i<left.length;i++){
		left[i]=ary[i];
		right[i]=ary[i+left.length];
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(ary,left, right);  
	}  
	    
    }
    public static merge(int[] original, int[]aryA, int[] aryB){
	int i =0;
	int j=0;
	while(i<aryA.length,i<aryB.length

}
