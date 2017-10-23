/** This program creates and tests a class called Magic.
  * It creates a magic square utilizing arrays
  * 
  * Author: Calvin Isch
  * Date: 09/30/2017 @10:01pm
  * 
  * simply run the program, and input a number to look at 
  * a beautiful square. Only odd numbers will do.
  */

import java.util.*; 
import java.math.*;

public class Magic {
  
  public static void main(String[] args) {
    // This section gets user input to see how large of a
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
    
    //this creates an array of the size that we need
    int[][] magic = new int[size][size];
    
    //sets all the basics as defined in the problem
    int row = size-1;
    int col = size/2;
    magic[row][col] = 1;
    
    // This creates the square. It follows the set of rules given
    // in the instructions. Note that we start with k = 2 because 
    // 1 is already correctly placed in the square.
    for (int k = 2; k <= size*size; k++) {
      if (magic [(row + 1) % size][(col + 1) % size] == 0) {
        row = (row + 1) % size;
        col = (col + 1) % size;
      } else {
        row = (row - 1 + size) % size; 
      } magic[row][col] = k;
    }
    
    // This is where we print our square. I added some spacing and
    // brackets to make it look pretty.
    for (int i = 0; i < size; i++) {
      System.out.print("["); 
      for (int j = 0; j < size; j++) {
        if(magic[i][j] < 10) System.out.print(" ");
        if(magic[i][j] < 100) System.out.print(" ");
        System.out.print(magic[i][j] + " ");
      }
      System.out.print("]"); 
      System.out.println();
    }
    
  }
}