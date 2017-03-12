import java.lang.Math;
public class Recursion{
    public static String name(){
	return "Peer,Inbar";
    }
    public static double sqrt(double n){
        return helperSqrt( n , 1 ) ;
    }
    public static double helperSqrt( double n , double guess ){
	if(guess == 0){
	    return 0;
	}
	if( guess < 0 || n < 0 ){
	    throw new IllegalArgumentException("no negative numbers!");
	}
	if ( compareValues( guess * guess , n ) ) {
		return guess;
	}
	return helperSqrt ( n , ( ( n / guess + guess ) / 2 ) ) ;
    }
    public static boolean compareValues( double n1 , double n2){
	return (Math.abs( n1 - n2 ) <= 0.00000000001) ;
    }
    public static void main(String [] args){
	System.out.println(String.valueOf(sqrt(50)));
	System.out.println(String.valueOf(sqrt(49)));
	System.out.println(String.valueOf(sqrt(-1)));
	System.out.println(String.valueOf(sqrt(0)));
	System.out.println(String.valueOf(sqrt(16)));
    }
}
