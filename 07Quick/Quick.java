import java.util.*;
public class Quick{
	public static int quickselect(int []data, int k){
	int start = 0;
	int end = data.length - 1;
	int check = part(data, start, end);
	while(check!=k){	
		if(check > k){
			end= check;
			check = part(data,start, end);
		}
		if(check < k){
			start=check;
			check = part(data, start, end);
		}
	}
	return data[check]; 
}	
	
    public static int part(int[] data, int start, int end){
	System.out.println(toString(data));
	int[] parted = new int[end-start];
	Random random = new Random();
	int limit = end - start + 1 ;
	int s= 0;
	int e= end - start - 1;
	int parter = random.nextInt(limit) + start;
	System.out.println("This is the parter value:");
	System.out.println(parter);
        for(int i=start; i<end+1; i++){
	    if(i!=parter){
		if(data[i]<data[parter]){
		    parted[s]= data[i];
		    s++;
		}
		else{
		    parted[e]=data[i];
		    e--;
		}
	    }	
	}
	data[s]=parter;
	int place = 0;
	for( int i = start; i<end; i++){
		data[i]=parted[place];
		place++;
	}
	System.out.println(toString(data));
	return s;
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
		int [] ary = new int[8];
		ary[0]=2;
		ary[1]=7;
		ary[2]=5;
		ary[3]=9;
		ary[4]=1;
		ary[5]=13;
		ary[6]=6;
		ary[7]=19;
		System.out.println(part(ary, 0, 7));

	}
}
    

	    
