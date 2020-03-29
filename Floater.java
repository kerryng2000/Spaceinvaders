import processing.core.PApplet;
public abstract class Floater //Do NOT modify the Floater class! Make changes in the SpaceShip class 
{   
    protected PApplet applet;
    protected int corners;  //the number of corners, a triangular floater has 3   
    protected int[] xCorners;   
    protected int[] yCorners;   
    protected int myColor;   
    protected double myCenterX, myCenterY; //holds center coordinates   
    protected double myDirectionX, myDirectionY; //holds x and y coordinates of the vector for direction of travel   
    protected double myPointDirection; //holds current direction the ship is pointing in degrees   

    public Floater(PApplet applet_)
    {
        applet = applet_;
    }

    abstract public void setX(int x);  

    abstract public int getX();   

    abstract public void setY(int y);   


    public void move (int num)   //move the floater in the current direction of travel
    {      
        //change the x and y coordinates by myDirectionX and myDirectionY         
        myCenterX += num;     //myCenterY += myDirectionY;    

        //wrap around screen    
        if(myCenterX > applet.width)
        {     
            myCenterX = 0;    
        }    
        else if (myCenterX < 0)
        {     
            myCenterX = applet.width;    
        }    
   
    }   
 
} 
