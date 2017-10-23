/** This program creates the instance of the olympic rings with the given location
  * and width
  * 
  * Author: Calvin Isch
  * Date: 09/10/2017 @4:30pm
  */

// necessary imports
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class OlympicRingComponent extends JComponent{
  
  // the method to draw all of the rings
  public void paintComponent(Graphics g){

    Graphics2D g2 = (Graphics2D) g;
    OlympicRing rings = new OlympicRing(30, 30, 90);
    
    // This draws the olympic rings
    rings.draw(g2);
  }
}