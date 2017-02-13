public class QueenBoard{
    
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
        clearBoard();
    }
    
    public boolean solve(){
	return solveH(0);
    }
    
    private boolean solveH(int start){
	if(start == board.length){
	    return true;
	}
	for(int row=0; row < board.length; row++){
	    if (addQueen(row, start)){
		
		if(! solveH(start + 1)){
		    removeQueen(row, start);
		}
		else {
		    return true;
		}
	    }
	}
	return false;
    }
    
    private boolean addQueen(int r, int c){
	if(board[r][c] == 0){
	    board[r][c] = -1;
	    for(int n = 1 ; n+c < board.length; n++){
		board[r][c+n]+=1;
		if(r+n<board.length){
		    board[r+n][c+n]+=1;
		}
		if(r-n>=0){
		    board[r-n][c+n]+=1;
		}	
	    }
	    return true;
	}
	return false;
    }
    
    private void removeQueen(int r,int c){
	board[r][c] = 0;
	for(int n = 1 ; n+c < board.length; n++){
		board[r][c+n]-=1;
		if(r+n<board.length){
		    board[r+n][c+n]-=1;
		}
		if(r-n>=0){
		    board[r-n][c+n]-=1;
		}	
	    }
    }
    
	
    public void countSolutions(){
	clearBoard();
	countSolutionsH(0);		
    }
    private void countSolutionsH(int start){
	solutionCount=0;
	if(start==board.length){
	    solutionCount+=1;
	}
	else{
	    // System.out.println("In countSolutionsH "+start);
	    for(int row=0; row < board.length; row++){
		//System.out.println("Trying to add queen at "+start+"," +row);
		if (addQueen(row, start)){
		    
		    //System.out.println("added queen at "+start+"," +row);
		    countSolutionsH(start+1);
		    //System.out.println("removing queen at "+start+"," +row);
		    removeQueen(row, start);
		}
	    }
	}
    }
    public int getCount(){
	return solutionCount;
    }
    
    public String toString(){
	String bboard = "";
	for(int c = 0; c< board.length; c++){
	    for(int r = 0; r< board.length; r++){
		bboard+= Integer.toString(board[r][c]) + "  ";
	    }
	    bboard+= "\n";
	}
	return bboard;
    }
    private void clearBoard(){
	for(int row = 0; row < board.length; row++){
	    for(int col=0; col< board.length; col++){
	        board[row][col]= 0;
		    }
	}
    }
    public static void main(String args[]) {
	QueenBoard test = new QueenBoard(8);
	System.out.println(test.solve());
	System.out.println(test.toString());
        test.countSolutions();
	System.out.println(Integer.toString(test.getCount()));
    
    }
}
