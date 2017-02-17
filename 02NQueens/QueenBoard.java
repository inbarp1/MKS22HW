import java.lang.*;
public class QueenBoard{
    
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	if(size<1){
		throw new IndexOutOfBoundsException("Index " +size + " is out of bounds! Please enter a board size greater than 0!");
	}
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
		System.out.println(this.toString());
		if(! solveH(start + 1)){
		    removeQueen(row, start);
		System.out.println(this.toString());
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
	solutionCount=0;
	clearBoard();
	countSolutionsH(0);		
    }
    private void countSolutionsH(int start){
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
	System.out.println("This is an 8x8 board");
	test.solve();
	System.out.println(test.toString());
        test.countSolutions();
	System.out.println(Integer.toString(test.getCount()));
    	QueenBoard test2 = new QueenBoard(1);
	System.out.println("This is an 1x1 board");
	test2.solve();
	System.out.println(test2.toString());
        test2.countSolutions();
	System.out.println(Integer.toString(test2.getCount()));
	QueenBoard test3 = new QueenBoard(3);
	System.out.println("This is an 3x3 board");
	test3.solve();
	System.out.println(test3.toString());
        test3.countSolutions();
	System.out.println(Integer.toString(test3.getCount()));
	QueenBoard test4 = new QueenBoard(10);
	System.out.println("This is an 10X10 board");
	test4.solve();
	System.out.println(test4.toString());
        test4.countSolutions();
	System.out.println(Integer.toString(test4.getCount()));
	QueenBoard test6 = new QueenBoard(4);
	System.out.println("This is an 4X4 board");
	test6.solve();
	System.out.println(test6.toString());
        test6.countSolutions();
	System.out.println(Integer.toString(test6.getCount()));
	QueenBoard test5 = new QueenBoard(-3);
	
    }
}
