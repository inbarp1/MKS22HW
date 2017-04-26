/*This expression tree is a binary tree that represents
an arithmetic expression. The results are always doubles,
no int operations nor booleans/strings etc.
-Example:
  +
 / \
3   *
  /  \
 2   10
- Any node with children is treated like an operator.
- Any node without children is treated like a value.

Assumptions that can be made:
- A TreeNode has 0 or 2 children.
- A TreeNode with children must have an operator.
- For now all operators are binary and are one of these: '+', '-', '*', '/'.
*/

public class ExpressionTree{
  /*instance variables, constructors, and some methods not shown*/
  
  /*accessor method for the value, precondition is that isValue() is true.*/
  private double getValue(){    /*implementation not shown*/ }
  /*accessor method for the operation, precondition is that isOp() is true.*/
  private char getOp(){    /*implementation not shown*/  }    
  /* accessor method for left, precondition is that isOp() is true.*/
  private ExpressionTree getLeft(){    /*implementation not shown*/  }
  /* accessor method for right, precondition is that isOp() is true.*/
  private ExpressionTree getRight(){    /*implementation not shown*/  }

  private boolean isOp(){    /*implementation not shown*/  }
  private boolean isValue(){    /*implementation not shown*/  }


  /* you write these four methods, hint: think recursively */

  /*return the expression as an infix notation string with parenthesis*/
  /* The sample tree at the top would be: "( 3 + (2 * 10))"     */
  public String toString(){    /*you are to write this method*/  }

  /*return the expression as a postfix notation string without parenthesis*/
  /* The sample tree would be: "3 2 10 * +"     */
  public String toStringPostfix(){    /*you are to write this method*/  }

  /*return the expression as a prefix notation string without parenthesis*/
  /* The sample tree would be: "+ 3 * 2 10"     */
  public String toStringPrefix(){    /*you are to write this method*/  }

  /*return the value of the expression tree*/
  public double evaluate(){    /*you are to write this method*/  }

}
