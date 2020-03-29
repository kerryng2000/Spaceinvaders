import processing.core.PApplet;
public class Invader extends Floater
{
    private int RotationSpeed;
    protected int x,y;
    protected int num;
    //protected PApplet applet;
    public Invader(PApplet applet_)
    {

        super(applet_);
        num = 2;
        applet = applet_;

    }

    public void setX(int x)
    {
        super.myCenterX = x;   
        this.x = x;
    }

    public int getX()
    {
        return (int)super.myCenterX;
    }

    public void setY(int y)
    {
        super.myCenterY = y;
        this.y = y;
    }

    public int getY()
    {
        return (int)super.myCenterY;
    }

   
    public void move1()
    {
        this.num = num;
        myCenterX += num;
    }

    public void stop()
    {
        this.num = 0;
    }

    public void move2()
    {
        myCenterX-=num;

    }

    public void move3()
    {
        this.num = num;
        myCenterY += this.num;
    }

}
