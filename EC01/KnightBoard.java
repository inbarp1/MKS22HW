public class KnightBoard{

    private int[][] board;
    private int[][] moveChecker;
    private int m;
    private int n;
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	moveChecker=  new int[startingRows][startingCols];
	m=startingRows;
	n=startingCols;
	for(int row = 0; row < m; row++){
	    for(int col=0; col< n; col++){
		if((row == 0) || (row == m -1)){
		    if((col == 0) || (col == n - 1)){
		    moveChecker[row][col] = 2;
		    }
		    else {
			if(( col == 1) ||( col == n - 2)){
			    moveChecker[row][col] = 3;
			}
			else{
			    moveChecker[row][col]= 4;
			}
		    }
		}
		else {
		    if(( row == 1)|| (row == m - 2)){
			if((col == 0) || (col == n - 1)){
			    moveChecker[row][col]= 3;
			}
			if ( (col == 1) || (col == n - 2)){
			    moveChecker[row][col] = 4;
			}
			else{
			    moveChecker[row][col] = 6;
			}
		    }
		    else {
			if((col == 0) || (col == n - 1)){
			    moveChecker[row][col]= 4;
			}
			if ( (col == 1) || (col == n - 2)){
			    moveChecker[row][col] = 6;
			}
			else{
			    moveChecker[row][col] = 8;
			}
		    }
		}
			    
		}
	 
	}
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
                for (int delta_r_sign = -1; delta_r_sign <=1 ; delta_r_sign+=2){
		    for (int delta_c_sign = -1; delta_c_sign <=1 ; delta_c_sign+=2){
			for (int delta_r_abs = 1; delta_r_abs <=2 ; delta_r_abs++){
		    delta_c_abs = 3-delta_r_abs;
		    if( solveH((r+ delta_r_sign*delta_r_abs) , (c+ delta_c_sign*delta_c_abs), num+1)){
			    return true;
			}}}}
		removeKnight(r,c);
	    }
	return false;
    }

      private void placeKnight(int r, int c, int num){
	    //System.out.println("placing night" + num);
	    board[r][c] = num;
	    for (int delta_r_sign = -1; delta_r_sign <=1 ; delta_r_sign+=2){
		for (int delta_c_sign = -1; delta_c_sign <=1 ; delta_c_sign+=2){
		    for (int delta_r_abs = 1; delta_r_abs <=2 ; delta_r_abs++){
		    delta_c_abs = 3-delta_r_abs;
		    if(isOnGoodPlace(r + delta_r_abs*delta_r_sign, c + delta_c_abs*delta_c_sign)){
			boardChecker[r + delta_r_abs*delta_r_sign][c + delta_c_abs*delta_c_sign] --;
		    }
		}
	      }
	    }
		    
      }

	private boolean isOnGoodPlace(int r, int c){
	    // System.out.println("checkign if good place");
	    return( (r < m) && (c < n) && (r >= 0) &&( c >= 0) &&(board[r][c]==0));
	}
	
	private void removeKnight(int r, int c){
	    board[r][c] = 0;
	    for (int delta_r_sign = -1; delta_r_sign <=1 ; delta_r_sign+=2){
		 for (int delta_c_sign = -1; delta_c_sign <=1 ; delta_c_sign+=2){
		     for (int delta_r_abs = 1; delta_r_abs <=2 ; delta_r_abs++){
		    delta_c_abs = 3-delta_r_abs;
		    if(isOnGoodPlace(r + delta_r_abs*delta_r_sign, c + delta_c_abs*delta_c_sign)){
			boardChecker[r + delta_r_abs*delta_r_sign][c + delta_c_abs*delta_c_sign] ++;
		    }
		}
	      }
	    }
	}

    public void solveFast(){
	betterSolveH(m/2, n/2, 0);
	}

    private boolean betterSolveH(int r, int c, int num){
	int[][]moveList = new int [8][2];
	if(num > m * n){
	    return true;
	}
	if(isOnGoodPlace(r,c)){
	    placeKnight(r,c,num);
	    moveList=orderMoves(r,c);
	    for(int move= 0; move < 8; move++){
		if(moveList[move][0]=! -1){
		    if(betterSolveH(moveList[move][0], moveList[move][1])){
			return true;
		    }
		}
	    }
	    removeKnight(r, c);
	}
    }
		    
		    
		    

	private int[][]  addMove(int r, int c, int [][] m, int moveSoFar){
	    m[moveSoFar][0]= r;
	    m[moveSoFar][1] = c;
	    return m;
	}
	private int[][] getList(int r, int c){
	    int[][] moves = new int[8][2]; 
	    int movesSoFar = 0;
	    for(int sol = 0; sol < 8; sol++){
	    for(int i=0; i< 2; i++){
	        m[sol][i]= -1;
		    }
	    }
	}
	private int findLength(int[][] b){
	    int length;
	    for(int row = 0; row < 8; row++){
	        if(b[row][0] != -1){
		    length ++;
		}
	    }
	  return length;
	}
	      
	    
	private boolean compareMoves(int irow, int icol , int jrow, int jcol){
	    return (moveChecker[irow][icol] <  moveChecker[jrow][jcol]);
	}
	
	public int[][] sortC(int[][] temp, int length)
    {
        if (length == 1)       
        {
            return temp;
        }
        else if (length >= 2)
        {
               for (int i = 1; i <= length - 1; i++)
               {
                   int holdRow = temp[i][0];
                   int holdCol = temp[i][1];
                   // hold past index
                   int holdRowP = temp[i - 1][0];
                   int holdColP = temp[i - 1][1];

                   int j = i;

                   while (j > 0 && (compareMoves(holdRow, holdCol, holdRowP, holdColP)))
                   {
                       holdRow = temp[j][0];
                       holdCol = temp[j][1];
                       // hold past index
                       holdRowP = temp[j - 1][0];
                       holdColP = temp[j - 1][1];   

                       // make single swap
                       temp[j][0] = holdRowP;
                       temp[j][1] = holdColP;

                       temp[j-1][0] = holdRow;
                       temp[j-1][1] = holdCol;

                       j--;
                   }
               }
        }

        return temp;
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
// 2 moveCheckers, check for least possible moves
// create an array of the moves
// order the array
// the better solve will go down the aray of the moves

