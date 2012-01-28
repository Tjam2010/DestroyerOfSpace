package destroyerofspace;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Ship
{
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int[] shipxPoints =
    {
        0, 1, 1, 3, 1, 1, 3, 3, 2, 2, 1, 1, -1, -1, -2, -2, -3, -3, -1, -1, -3, -1, -1
    };
    private int[] shipyPoints =
    {
        -6, -4, -2, 0, 0, 1, 3, 5, 5, 4, 4, 5, 5, 4, 4, 5, 5, 3, 1, 0, 0, -2, -4
    };
    private int shipNumberOfPoints = shipxPoints.length;
    private Polygon shipPolygon = new Polygon(shipxPoints, shipyPoints, shipNumberOfPoints);
    private Area shipShape = new Area(shipPolygon);
    //private int[] exhaustxPoints = {-3, -2, -1, };
    //private int[] exhaustyPoints = {-6, -4, -2, 0, 0, 1, 3, 5, 5, 4, 4, 5, 5, 4, 4, 5, 5, 3, 1, 0, 0, -2, -4};
    //private int exhaustnumberOfPoints = exhaustxPoints.length;
    //private Polygon exhaustShape = new Polygon(exhaustxPoints, exhaustyPoints, exhaustnumberOfPoints);
    private AffineTransform atShip = new AffineTransform();
    private int shipx = 500;
    private int shipy = 500;
    private int shipDirection = 0;
    private int shipSpeed = 5;
    private int shipDeltaX;
    private int shipDeltaY;

    public void paintSelf(Graphics2D g2)
    {
        g2.translate(getShipx(), getShipy());
        g2.scale(20, 20);
        g2.rotate(Math.toRadians(getShipDirection()));
        atShip = g2.getTransform();
        shipShape.createTransformedArea(getAtShip());
        g2.setColor(Color.lightGray);
        g2.fill(shipShape);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(.2f));
        g2.draw(shipShape);
        //g2.draw(exhaustShape);
        g2.setTransform(getAtShip());
    }

    public void move()
    {
        shipDeltaX = (int) (shipSpeed * Math.sin(Math.toRadians(shipDirection)));
        shipDeltaY = (int) (-shipSpeed * Math.cos(Math.toRadians(shipDirection)));
        shipx = shipx + shipDeltaX;
        shipy = shipy + shipDeltaY;
        if (shipx > width)
        {
            shipx = 0;
        }
        if (shipy > height)
        {
            shipy = 0;
        }
        if (shipy < 0)
        {
            shipy = height;
        }
        if (shipx < 0)
        {
            shipx = width;
        }
    }

    public void setShipDirection(int shipDirection)
    {
        this.shipDirection = shipDirection;
    }

    public int getShipDirection()
    {
        return shipDirection;
    }

    public void setShipy(int shipy)
    {
        this.shipy = shipy;
    }

    public int getShipy()
    {
        return shipy;
    }

    public int getShipx()
    {
        return shipx;
    }

    public void setShipx(int shipx)
    {
        this.shipx = shipx;
    }

    public int getShipSpeed()
    {
        return shipSpeed;
    }

    public void setShipSpeed(int shipSpeed)
    {
        this.shipSpeed = shipSpeed;
    }

    public AffineTransform getAtShip()
    {
        return atShip;
    }
}
