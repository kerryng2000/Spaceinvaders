import processing.core.PApplet;
public class Bullet extends Floater
{
    protected PApplet applet_;
    protected SpaceShip Ship;
    public Bullet(PApplet applet, SpaceShip theShip)
    {
        super(applet);
        applet_ = applet;
        Ship = theShip;
        myCenterX = theShip.getX();
        myCenterY = theShip.getY();
        
    }

    public void setX(int x)
    {
        super.myCenterX = x;   
    }

    public int getX()
    {
        return (int)super.myCenterX;
    }

    public void setY(int y)
    {
        super.myCenterY = y;
    }

    public int getY()
    {
        return (int)super.myCenterY;
    }

    public void move2()   //move the floater in the current direction of travel
    {      
        //change the x and y coordinates by myDirectionX and myDirectionY         
        myCenterY -= 5;     //myCenterY += myDirectionY;    

    }   

    public void show()
    {
        applet_.fill(0);
        applet_.ellipse((float)super.myCenterX, (float)super.myCenterY - 5, 5, 5);
    }
}