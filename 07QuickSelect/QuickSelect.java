
public class QuickSelect{
    public static QuickSelect(){}
    public int part(int[] data, int start, int end){
	int[] parted = new int[end-start];
	Random random = new Random();
	int limit = end - start + 1 ;
	int s= 0;
	int e= parted.length - 1
	int parter = random.nextInt(limit) + start;
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
	return s;
    }
    

	    
