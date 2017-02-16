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
    }

    public String toString(){
        String f = "";
	for(int row = 0; row < m; row++){
	    f += "\n";
	    for(int col = 0; col < n; col++){
		if(board[row][col] < 10){
		    f += " ";
		}
		f += (Integer.toString(board[row][col])) +  " ";
	    }
	}
	return f;
    }
    public void solve(){
       solveH(m/2, n/2, 1);
    }
  
    private boolean solveH(int r,int c, int num){
	if(num > m * n){
	    return true;
	}
	//System.out.println(r + " " + c); 
	if(isOnGoodPlace(r,c)){
	    //System.out.println("good place");
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
	    //System.out.println("placing night" + num);
	    board[r][c] = num;
	}

	private boolean isOnGoodPlace(int r, int c){
	    // System.out.println("checkign if good place");
	    return r < m && c < n && r >= 0 && c >= 0 && board[r][c]==0;
	}
	
	private void removeKnight(int r, int c){
	    board[r][c] = 0;
	}
    public static void main(String args[]){
	System.out.println ("TEST NUMERO UNO");
	KnightBoard test = new KnightBoard(7,7);
	test.solve();
	System.out.println(test.toString());
	System.out.println ("TEST NUMERO DOS");
	KnightBoard test2 = new KnightBoard(8,8);
	test2.solve();
	System.out.println(test2.toString());
    }
	
}



	//prioritize moves based on fewest outgoing moves.
// 2 boards, check for least possible moves
