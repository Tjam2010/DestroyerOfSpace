package destroyerofspace;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Bullet
{
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private Ellipse2D.Double bulletShape = new Ellipse2D.Double(0, 0, 2, 2);
    private AffineTransform atBullet;
    private AffineTransform identity = new AffineTransform();
    private ArrayList<Bullet> bulletList;
    private int bulletx;
    private int bullety;

    Bullet(AffineTransform atShip)
    {
        atBullet = atShip;
    }

    public void paintSelf(Graphics2D g2)
    {
        g2.setTransform(identity);
        g2.setColor(Color.black);
        for (Bullet b : bulletList)
        {
            b.bullety -= 1;
            g2.setTransform(b.atBullet);
            b.bulletShape.x = b.bulletx - 1;
            b.bulletShape.y = b.bullety - 1;
            g2.fill(b.bulletShape);
        }
    }

    public void move()
    {
        for (Bullet b : bulletList)
        {
            
        }
    }

    public void setBulletList(ArrayList<Bullet> bulletList)
    {
        this.bulletList = bulletList;
    }
}
