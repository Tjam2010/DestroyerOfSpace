package destroyerofspace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Controller extends JComponent implements ActionListener, KeyListener
{
    private JFrame space;
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public Ship rocket;
    public Bullet ammo;
    private Timer paintTimer;
    private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    private boolean keyLeftPushed = false;
    private boolean keyRightPushed = false;
    private boolean keyUpPushed = false;
    private boolean keyDownPushed = false;
    private boolean keySpacePushed = false;

    public static void main(String[] args)
    {
        new Controller().getGoing();
    }

    private void getGoing()
    {
        space = new JFrame("Air-Force");
        space.setVisible(true);
        space.setSize(width, height);
        space.setBackground(new Color(0xAE, 0xEB, 0xEC));
        space.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        space.add(this);
        space.addKeyListener(this);
        paintTimer = new Timer(20, this);
        paintTimer.start();
        rocket = new Ship();
        ammo = new Bullet(new AffineTransform());
        ammo.setBulletList(bulletList);
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        rocket.paintSelf(g2);
        rocket.move();
        ammo.move();
        ammo.paintSelf(g2);
        keysMove(); 
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke)
    {
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keyLeftPushed = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keyRightPushed = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP)
        {
            keyUpPushed = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
                keyDownPushed = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keySpacePushed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keyLeftPushed = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keyRightPushed = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP)
        {
            keyUpPushed = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keyDownPushed = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keySpacePushed = false;
        }
    }

    public void keysMove()
    {
        if (keyLeftPushed)
        {
            rocket.setShipDirection(rocket.getShipDirection() - 5);
        }
        if (keyRightPushed)
        {
            rocket.setShipDirection(rocket.getShipDirection() + 5);
        }
        if (keyUpPushed)
        {
            if (rocket.getShipSpeed() < 10)
            {
                rocket.setShipSpeed(rocket.getShipSpeed() + 1);
            }
        }
        if (keyDownPushed)
        {
            if (rocket.getShipSpeed() > 0)
            {
                rocket.setShipSpeed(rocket.getShipSpeed() - 1);
            }
        }
        if (keySpacePushed)
        {
            bulletList.add(new Bullet(rocket.getAtShip()));
        }
    }
}
