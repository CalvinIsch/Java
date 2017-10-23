/** This program creates a drawing of the olympic rings
  * Author: Calvin Isch
  * Date: 09/11/2017 @5:42pm
  */

// Necessary imports
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;

public class OlympicRing {
  // These are variables over and over in the creation.
  private int xLeft, yTop, radius;
  
  // This sets the variables at whatever is called (i.e. it's the constructor.)
  public OlympicRing(int x, int y, int r) {
    xLeft = x;
    yTop = y;
    radius = r;
  }
  
  // This draws the circle on the plane.
  public void draw(Graphics2D g2) { 
    // Sets the size of the ring.
    float thickness = 12;
    Stroke oldStroke = g2.getStroke();
    g2.setStroke(new BasicStroke(thickness));
      
    // A nice white background color.
    g2.setColor(Color.WHITE);
    g2.fillRect(0, 0, 500, 500);
    // First draw the blue circle, at specified location
    g2.setColor(Color.BLUE);
    Ellipse2D.Double circleBlue 
      = new Ellipse2D.Double(xLeft + radius, yTop + radius, radius, radius);
    g2.draw(circleBlue);
    // Draw the yellow circle at the shifted location
    g2.setColor(Color.YELLOW);
    Ellipse2D.Double circleYellow 
      = new Ellipse2D.Double(xLeft + (1.5 * radius), yTop + (1.5 * radius), radius, radius);
    g2.draw(circleYellow);
    // Draw the Black circle at the shifted location
    g2.setColor(Color.BLACK);
    Ellipse2D.Double circleBlack
      = new Ellipse2D.Double(xLeft + (2 * radius), yTop + radius, radius, radius);
    g2.draw(circleBlack);
    // Draw the green circle at the shifted location
    g2.setColor(Color.GREEN);
    Ellipse2D.Double circleGreen 
      = new Ellipse2D.Double(xLeft + (2.5 * radius), yTop + (1.5 * radius), radius, radius);
    g2.draw(circleGreen);
    // Draw the red circle at the shifted location
    g2.setColor(Color.RED);
    Ellipse2D.Double circleRed
      = new Ellipse2D.Double(xLeft + (3 * radius), yTop + radius, radius, radius);
    g2.draw(circleRed);
  }
    
}
