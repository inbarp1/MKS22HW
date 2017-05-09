public class RunningMedians{
    private MyHeap small, large;
    public void add(int n){
	if(n<=small.peek()){
	    small.add(n);
	}
	else{
	    large.add(n);
	}
	balance();
    }
    private void balance(){
	if(Math.abs(large.getSize()-small.getSize())> 1){
	    if(large.getSize()> small.getSize()){
		int a = large.peek();
		large.remove();
		small.add(a);
	    }
	    else{
		int b = small.peek();
		small.remove();
		large.add(b);
	    }
	}
    }
    public double getMedian(){
	if(large.getSize()==small.getSize()){
	    return (large.peek() + small.peek())/ 2.0;
	}
	if(large.getSize()> small.getSize()){
	    return large.peek();
	}
	return small.peek();
    }
}
