package destroyerofspace;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Asteroid
{
    private int[] xPoints = {0, 1, 1, 3, 1, 1, 3, 3, 2, 2, 1, 1, -1, -1, -2, -2, -3, -3, -1, -1, -3, -1, -1};
    private int[] yPoints = {-6, -4, -2, 0, 0, 1, 3, 5, 5, 4, 4, 5, 5, 4, 4, 5, 5, 3, 1, 0, 0, -2, -4};
    private int numberOfPoints = xPoints.length;
    private Polygon asteroidShape = new Polygon(xPoints, yPoints, numberOfPoints);
    public void paintSelf(Graphics2D g2)
    {
        g2.translate(500, 500);
        g2.setColor(Color.yellow);
        g2.scale(20, 20);
        g2.rotate(Math.toRadians(0));
        g2.fill(asteroidShape);     
    }
}
