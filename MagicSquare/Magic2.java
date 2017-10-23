/** This program creates and tests a class called Magic2.
  * It creates a magic square utilizing ArrayLists
  * 
  * Author: Calvin Isch
  * Date: 09/30/2017 @10:01pm
  * 
  * simply run the program and input a number to look at 
  * the beautiful square. Only odd numbers will do.
  */

import java.util.*; 
import java.math.*;

public class Magic2 {
  
  public static void main(String[] args) {
    // This section simply gets user input to see how large of a
    // square to make.
    Scanner in;
    in = new Scanner(System.in);
    System.out.print("Size: "); 
    String t1 = in.next();
    Integer size = Integer.parseInt(t1);
    
    // an error if the user put an even number
    if ((size % 2) == 0) {
      System.out.println("Please enter an odd number");
    }
    
    ArrayList<ArrayList<Integer>> magic = new ArrayList<ArrayList<Integer>>(); 
    //this creates an ArrayList of the size that we need
    for (int i = 0; i < size; i++) {
      ArrayList<Integer> x = new ArrayList<Integer>();
      for (int j = 0; j < size; j++) {
        x.add(0);
      }
      magic.add(x);
    }
    
    //sets all the basics as defined in the problem
    int row = size-1;
    int col = size/2;
    magic.get(row).set(col, 1);
    
    // This creates the square. It follows the set of rules given
    // in the instructions. Note that we start with k = 2 because 
    // 1 is already correctly placed in the square.
    for (int k = 2; k <= size*size; k++) {
      if (row + 1 < size && col + 1 < size) {
        if (magic.get(row + 1).get(col + 1)  == 0) {
          row = (row + 1) % size;
          col = (col + 1) % size;
        } else {
          row = (row - 1 + size) % size; 
        }
      } else if (row + 1 >= size && col + 1 >= size) {
          row = 1;
          col = 2;
      } else if (row + 1 >= size) {
        row = 0; 
        col = col + 1;
      } else {
        row = row + 1;
        col = 0;
      }
      magic.get(row).set(col, k);
    }
    
    // This is where we print our square. I added some spacing and
    // brackets to make it look pretty.
    for (int i = 0; i < size; i++) {
      System.out.print("["); 
      for (int j = 0; j < size; j++) {
        if(magic.get(i).get(j) < 10) System.out.print(" ");
        if(magic.get(i).get(j) < 100) System.out.print(" ");
        System.out.print(magic.get(i).get(j) + " ");
      }
      System.out.print("]"); 
      System.out.println();
    }
    
  }
  }
