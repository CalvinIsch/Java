/** 
  *  ExpressionCalculator.java
  * 
  *  This program creates and tests a class called ExpressionCalculator which 
  *  takes an input from fixed notation and outputs it in polish post-fix form.
  * 
  * Date: 10/22/2017 @8:00pm
  * 
  * Simply compile and run the program. Then give it a mathematic expression
  * in in-fixed notation to see it output in reverse polish form.
  */

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
   public static void main(String[] args) {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter an expression: ");
      String expression = in.nextLine().replace(" ", "");
      
      // The stack<string> will slowly build the whole output.
      Stack<String> strstack = new Stack<String>();
      Stack<Character> opstack = new Stack<Character>();
      
      int pos = 0;
      while (pos < expression.length()) {  
        // Reads through the function while it still has characters
         char ch = expression.charAt(pos);
         pos++;
         if (isOperator(ch))
         {  
            if (opstack.size() == 0) { opstack.push(ch); }
            else
            {  
               char oldOp = opstack.pop();
               //ensures the correct order of operations
               if (precedence(ch) > precedence(oldOp)) { opstack.push(oldOp); }
               else { evaluateTop(strstack, oldOp); }
               opstack.push(ch);
            }
         }
         else if (ch == '(') { opstack.push(ch); }
         else if (ch == ')')
         {  
            boolean done = false;
            while (!done)
            {  
               if (opstack.size() == 0) { error("No matching ("); }
               char oldOp = opstack.pop();
               if (oldOp == '(') { done = true; }
               else { evaluateTop(strstack, oldOp); }
            }
         }
         else if (Character.isDigit(ch))
         {
            int start = pos - 1;
            while (pos < expression.length() 
               && Character.isDigit(expression.charAt(pos))) { pos++; }
            String num = expression.substring(start, pos);
            strstack.push(num);
         }
         else { error ("Number, operator, or parenthesis expected."); }
      }
      while (opstack.size() > 0)
      {  //Ensures correct input from the user
         char oldOp = opstack.pop();
         if (oldOp == '(') { error("No matching )"); }
         else { evaluateTop(strstack, oldOp); }
      }
      if (strstack.size() == 0) { error("Syntax error"); }
      System.out.println(strstack.pop());
      if (strstack.size() > 0) { error("Syntax error"); }
   }

   /**
      Tests if a token is an operator.
      @param s the token
      @return true if s is one of: + - * / ^
   */
   public static boolean isOperator(char ch) {  
      return ch == '+' || ch == '-' || ch == '*' || ch == '/';
   }

   /**
      Prints an error message and exits.
      @param message information about the error
   */
   public static void error(String message) {  
      System.out.println("ERROR: " + message + ".");
      System.exit(1);
   }

   /**
      Computes the precedence level of an operator.
      @param s the operator
      @return the precedence level (1 = lowest, 3 = highest)
   */
   public static int precedence(char ch) {  
      if (ch == '+' || ch == '-') { return 1; }
      else if (ch == '*' || ch == '/') { return 2; }
      else { return 0; }
   }

   /** 
      Computes a new value and pushes it on the stack.
      @param str the stack for the operands and result
      @param op the operation to use
   */
   public static void evaluateTop(Stack<String> str, char op) {  
      if (str.size() == 0) { error("Syntax error"); }
      String y = str.pop();
      if (str.size() == 0) { error("Syntax error"); }
      String x = str.pop();
      String z = "";
      if (op == '*') { z = x + " " + y + " " + "*"; }
      else if (op == '/')
      {  
         if (y == "0") { error("Divide by 0"); }
         else { z = x + " " + y + " " + "/";}
      }
      else if (op == '+') { z = x + " " + y + " " + "+"; }
      else if (op == '-') { z = x + " " + y + " " + "-"; }
      else { error("Syntax error"); }
      str.push(z);
   }
}