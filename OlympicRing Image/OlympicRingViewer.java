/** This program creates the viewer of the Olympic Rings including a JFrame
  * 
  * Author: Calvin Isch
  * Date: 09/10/2017 @4:40pm
  * 
  */

// Necessary imports
import javax.swing.JFrame;

public class OlympicRingViewer {
  // The main method to create the JFrame
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    
    // Sets the size and title of the JFrame
    frame.setSize(500, 500);
    frame.setTitle("Olympic Rings");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Calls the other class to make the ring
    OlympicRingComponent component = new OlympicRingComponent();
    frame.add(component);
    
    // Sets the entire thing to visible
    frame.setVisible(true);
  }
}