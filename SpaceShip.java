import processing.core.PApplet;
public class SpaceShip extends Floater  
{   

    public SpaceShip(PApplet applet_)
    {
        super(applet_);
        applet = applet_;

        myCenterX = 500;
        myCenterY = 800;

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

}
