import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        animate = false;
	List<String> lines = new List<String>; 
	lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
	int j = 0;
	for(int i = 0; j<lines.size(); i++){
	    if(lines.get() == "\n"){
		j++;
		
		//figure out how to freakin do the scan stuffz 

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J");
    }

    private int findstartx(){
	for(int x=0; x<maze.length(); x++){
	    for( int y=0; y<maze.length(); y++){
		if(maze[x][y]=='S'){
		    return x;
		}
	    }
	}
	return 0;
    }
	
    private int findstarty(){
	for(int x=0; x<maze.length(); x++){
	    for( int y=0; y<maze.length(); y++){
		if(maze[x][y]=='S'){
		    return y;
		}
	    }
	}
	return 0;
    }
    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startx, starty;
            //Initialize startx and starty with the location of the S.
	    startx=findstartx();
	    starty=findstarty();
            maze[startx][starty] = ' ';//erase the S, and start solving!
            return solve(startx,starty);
    }
    private isOnGoodPlace(int x, int y){
	return(x<maze.length && y<maze.length && x>=0 && y>=0 maze[x][y]==' ');
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(20);
        }
	if(maze[x][y]=='E'){
	    return true;
	}
	if(isGoodPlace(x,y)){
	    maze[x][y]=="@";
	    if(solve(x+1,y)){
		return true;
	    }
	    if(solve(x,y+1)){
		return true;
	    }
	    if(solve(x-1,y)){
		return true;
	    }
	    if(solve(x, y-1)){
		return true;
	    }
	    maze[x][y]==".";
	    return false
		}

        return false; //so it compiles
    }

}
