public class KnightBoard{
    private int[][]board;
    private int m;
    private int n;
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	m=startingRows;
	n=startingCols;
	for(int row = 0; row < m; row++){
	    for(int col=0; col< n; col++){
	        board[row][col]= 0;
		    }
    }


    public String toString(){
} //blank if you never called solve or when there is no solution

    public void solve(){
	return solveH(0,0,1);
    }
  
    private boolean solveH(int r,int c, int num){
	if(count > m * n){
	    return true;
	}
	if isOnGoodSpot(r,c){
	       	placeKnight(r,c,num);
		if(solveH(r - 2, c + 1, num +1)){
		    return true;
		}
		if(solveH(r - 1, c + 2, num +1)){
		    return true;
		} 
		if(solveH(r + 1, c + 2, num +1)){
		    return true;
		}
		if(solveH(r + 2, c + 1, num +1)){
		    return true;
		}
		if(solveH(r + 2, c - 1, num +1)){
		    return true; 
		}
		if(solveH(r + 1, c - 2, num +1)){
		    return true;
		}
		if(solveH(r - 1, c - 2, num +1)){
		    return true; 
		}
                if(solveH(r - 2, c - 1, num +1)){
		    return true;
		}
		removeKnight(r,c);
	    }
	return false;
    }


	private void placeKnight(int r, int c, int num){
	    board[r][c] = num;
	}

	private boolean isGoodPlace(int r, int c){
	    return board[r][c] == 0 && r < n && c < m && r > = 0 && c > = 0; 
	}
	
	private void removeKnight(int r, int c){
	    board[r][c] = 0;
	}
}
