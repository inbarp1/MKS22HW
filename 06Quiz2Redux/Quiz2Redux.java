import java.util.*;
public class Quiz2Redux{

    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words, "", s,0);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words, String word, String s, int index){
	if (index<s.length()){
	    help(words,word, s,index+1);
	    help(words,word + Character.toString(s.charAt(index)),s, index+1);
	}
	else{
	    words.add(word);
	}
    }
	
 
 public static void main(String[] args){
     
     System.out.println(combinations("abcd"));
    }
	        

}
