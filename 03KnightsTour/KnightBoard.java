public class KnightBoard{
    private int[][]board;
    private int m;
    private int n;
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	m=startingRows;
	n=startingCols
    }


    public String toString(){} //blank if you never called solve or when there is no solution

    public void solve(){
	return solveH(0,0);
    }
  
    private boolean solveH(int r,int c, int num){
	if(count > m * n){
	    return true;
	}
	if isOnGoodSpot(){
		placeQueen();
		//try possible moves
		removeQueen();
		return false;
    }

}
