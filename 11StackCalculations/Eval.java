import java.util.*;
public class StackCalc{
    public static double eval(String s){
	String[] tokens= s.split(" ");
	Stack<Double> nums = new Stack<Double>();
	for(String token: tokens){
	    if(isOperation(token)){
		//	System.out.println("reached operator");
		Double test = (apply(token,nums.pop(),nums.pop()));
		nums.push(test);
		//System.out.println(test+ " adding");	    	       
	    }
	    else{ 
		nums.push(Double.parseDouble(token));
	   
	    }
	}
	    return nums.pop();	
    }
	private static boolean isOperation(String s){
	    return (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")|| s.equals("%"));
	}
	private static double apply(String operator, double A, double B){
	    if(operator.equals("+")){
		return A+B;
		}
	    if(operator.equals("-")){
		return Math.abs(A-B);
		}
	    if(operator.equals("*")){
		    return A*B;
	    }
	    if(operator.equals("/")){
		    return A/B;
	    }
	    if(operator.equals("%")){
		return A%B;
	    }
	    return 0.0;
	}

	public static void main(String[] args){
	    System.out.println(eval("10 2.0 +"));
	    System.out.println(eval("11 3 - 4 + 2.5 *"));
	    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	}
    }
       
