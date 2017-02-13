import java.lang.Math;
public class Recursion{
    public static String name(){
	return "Peer,Inbar";
    }
    public static double sqrt(double n){
        return helperSqrt( n , 0 ) ;
    }
    public static double helperSqrt( double n , double guess ){
	if ( compareValues( guess * guess , n ) ) {
		return guess;
	}
	return helperSqrt ( n , ( ( n / guess + guess ) / 2 ) ) ;
    }
    public static boolean compareValues( double n1 , double n2){
	return Math.abs(n1 - n2 - 1.0) <= 0.000000001 ;
    }
}
	
	
