/**  This program creates and tests a class called Profile which reads a text
  *  file and records the number of words sorted both by number of occurances
  *  and alphabetically. I used some of my homework 5 code to complete it
  * 
  *  Calvin Isch
  * 
  *  Date: 10/06/2017 @2:57pm
  * 
  *  To get the program to work, you need to pass in both the name of the file
  *  and (optionally) a number for the amount of results you wish to show.
  *      run Profile votes.txt 3
  */

// Necessary Imports
import java.util.*;
import java.io.File;
import java.util.Map.Entry;

public class Profile {
  
  // A method to add candidates (or words) to the HashMap
  public static void add(int num, String team) {
    Integer value = candidate.get(team);
    // Determines if the word is already in the set. If it isn't
    // creates a new value, and if not simply adds one to it.
    if (value == null)
      candidate.put(team, num);
    else
      candidate.put(team, value + num);
  }
  
  
  
  
  // This is a method to sort the hashmap by number of votes, and then alphabetically
  private static Map<String, Integer> sortThem(Map<String, Integer> unsorted){
    // A linked list that will store the sorted values
    List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsorted.entrySet());
    // Sorting the list based on values
    Collections.sort(list, new Comparator<Entry<String, Integer>>() {
      public int compare(Entry<String, Integer> o1,
                         Entry<String, Integer> o2) {
        // This part is necessary to ensure they're alphabetical
        if (o2.getValue() == o1.getValue()) {
          return o1.getKey().compareTo(o2.getKey());
        } else {
          return o2.getValue().compareTo(o1.getValue());
        }
      }
    });
    // Creates a new sorted hashmap
    Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
    for (Entry<String, Integer> entry : list){
      sorted.put(entry.getKey(), entry.getValue());
    } 
    // Returns our sorted map
    return sorted;
  }
  
  
  
  
  // This is our new HashMap called candidate (appropriately)
  public static Map<String, Integer> candidate;
  
  
  
  
  // This is a method used to print all the values in a hashmap
  public static void printAll(Map<String, Integer> map) {
    int n = 1;
    for (Entry<String, Integer> entry : map.entrySet()) {
      System.out.println(n + ". " + entry.getKey() + " = "+ entry.getValue());
      n++;
    }
  }
  // This is a method used to print a number of the values in a hashmap
  public static void printN(Map<String, Integer> map, String n) {
    int x = Integer.parseInt(n);
    int y = 1;
    for (Entry<String, Integer> entry : map.entrySet()) {
      // The if statement ensures the program doesn't break if the
      // user accidentally puts in a value that's too large
      if (y <= x) {
        System.out.println(y + ". " + entry.getKey() + " = "+ entry.getValue());
        y++;
      }
    }
  }
  
  
  
  
  // Our main method that runs the program
  public static void main(String[] args) throws Exception {
    String[] b = args;
    if (b.length == 0) {
      System.out.println("Please add a file and (optionally) a number, " +
                         "for instance: run Profile votes.txt 3");
    } else {
      String a = args[0];
      
      // Sets candidate = to a hashmap of String and Integers.
      Profile.candidate = new HashMap<String, Integer>();
      // Looks through the file and sends each individual word to our add helper
      Scanner speckles = new Scanner( new File( a ) );
      while (speckles.hasNext()) {
        String token = speckles.next();
        Profile.add(1, token);
      }
      
      // Creates sorted list of all of the votes candidates have received
      Map<String, Integer> sortedCandidates = sortThem(candidate);
      // This makes the number argument optional
      if (b.length > 1) {
        printN(sortedCandidates, b[1]);
      } else {
        printAll(sortedCandidates);
      }
    }
  }
}
