import java.util.*;
import java.io.*;

public class USACO{
    
    private int R, C, E, N;
    private int [][] land;
    private int[][]cowgrid;
    private int N2,M,T,R1,C1,R2,C2;
    private int [][] graze;
   
    
    public USACO() {
    }
    public int silver(String filename){
	try{
	    File name = new File(filename);
	    Scanner inf = new Scanner(name);
	    if(inf.hasNextLine()){
		N2=Integer.parseInt(inf.next());
		M=Integer.parseInt(inf.next());
		T=Integer.parseInt(inf.next());
	    }
	    cowgrid= new int[N2][M];
	    graze = new int[N2][M];
	    for( int r=0; r<N2; r++){
		if(inf.hasNextLine()){
		   inf.nextLine();
		}
		if(inf.hasNext()){
		   String s = inf.next();	
		   for(int c=0; c<M; c++){
		       if (s.charAt(c) == '.'){
			   cowgrid[r][c]=0 ;
			   graze[r][c]=0;
		       }
		       else{
			   cowgrid[r][c]=-1;
			   graze[r][c]=-1;
		       }
		   }
		}
	    }
	    //System.out.println(blahblah(cowgrid));
	    // System.out.println(blahblah(graze));
	    if(inf.hasNextLine()){
		inf.nextLine();
		R1=Integer.parseInt(inf.next());
		C1= Integer.parseInt(inf.next());
		R2= Integer.parseInt(inf.next());
		C2= Integer.parseInt(inf.next());
	    }
	   }
	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	return cowCalculate(R1, C1, R2, C2);
    }

   
    private int cowCalculate(int r1, int c1, int r2, int c2){
	cowgrid[r1-1][c1-1]= 1;
	graze[r1-1][c1-1] = 1;
	while(T > 0){
	    for( int r= 0; r < N2; r++){
		for( int c= 0; c< M; c++){   
		    if(cowgrid[r][c]!= -1){
			    graze[r][c]= 0;
			    try{
				if(cowgrid[r+1][c]!=-1){
				    graze[r][c]+=cowgrid[r+1][c];
				}
			    }
				 catch(IndexOutOfBoundsException e){}
			    
			    try{
				if(cowgrid[r-1][c]!=-1){
				    graze[r][c]+=cowgrid[r-1][c];
				}
			    }
				catch(IndexOutOfBoundsException e){}
			    
			    try{
				if(cowgrid[r][c-1]!=-1){
				    graze[r][c]+=cowgrid[r][c-1];
				}
			    }
				catch(IndexOutOfBoundsException e){}
			    try{
				if(cowgrid[r][c+1]!=-1){
				    graze[r][c]+=cowgrid[r][c+1];
				}
			    }
				catch(IndexOutOfBoundsException e){}
			    
		    }
		}
	    }
	    copyArray();
	    T = T - 1; 
			
    }
	//System.out.println(r2);
	//	System.out.println(c2);
	int answer = cowgrid[r2-1][c2-1];
	return answer; 
    }
    private void copyArray(){
	for(int r = 0; r < N2; r++){
	    for ( int c = 0; c < M; c++){
		cowgrid[r][c] = graze[r][c];
	    }
	}
    }
       
    
    public int bronze(String filename){
	try{
	    File name = new File(filename);
	    Scanner inf = new Scanner(name);
	          
	    if(inf.hasNextLine()){
		R = Integer.parseInt(inf.next());
		C = Integer.parseInt(inf.next());
		E = Integer.parseInt(inf.next());
		N = Integer.parseInt(inf.next());
	    }
	    land = new int[R][C];

	    for (int i = 0; i < R; i++){
		inf.nextLine();
		for (int j = 0; j < C; j++){
		    land[i][j] = Integer.parseInt(inf.next());
		}
	    }
	    //System.out.println(blah());
	    for (int x = 0; x < N; x++){
		inf.nextLine();
		//System.out.println(Integer.parseInt(inf.next()));
		// System.out.println(Integer.parseInt(inf.next()));
		cowStomp(Integer.parseInt(inf.next()),Integer.parseInt(inf.next()),Integer.parseInt(inf.next()));
		//System.out.println(blah());
		
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	return volumeCalc();
    }

    public String blahblah(int[][]  blah){
	String x = "";
	for(int i = 0; i < blah.length; i++){
	    for(int j = 0; j < blah[i].length; j++){
		x += blah[i][j]+" ";
	    }
	    x+= "\n";
	}
	return x;
    }
	
    public String blah(){
	String x = "";
	for(int i = 0; i < land.length; i++){
	    for(int j = 0; j < land[i].length; j++){
		x += land[i][j]+" ";
	    }
	    x+= "\n";
	}
	return x;
    }


    public void cowStomp(int r, int c, int e){
	r = r-1;
	c = c-1;
	//System.out.println(c);
	int locationr = r;
	int locationc = c;
	int max = land[r][c];
	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		//System.out.println(r+i);
		//System.out.println(c+j);
		if (land[r+i][c+j] > max){

		    max = land[r+i][c+j];
		    locationr = r + i;
		    locationc = c + j;
		}
	    }
	}
	int newMax = max - e;
	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (land[r+i][c+j] > newMax){
		    land[r+i][c+j] = newMax;
		}
	    }
	}
    }
    
    public void depthAnalyze(){
	//System.out.println("This is E: " +E);
	for(int i = 0; i < land.length; i++){
	    for(int j = 0; j < land[i].length; j++){

		if (land[i][j] < E){
		    land[i][j] = E - land[i][j];
		}
		else{
		    land[i][j] = 0;
		}
	    }
	}
    }

    public int volumeCalc(){
	depthAnalyze();
	int sum = 0;
	for(int i = 0; i < land.length; i++){
	    for(int j = 0; j < land[i].length; j++){
		sum += land[i][j];
	    }
	}
	return sum * 72 * 72;
    }
}
