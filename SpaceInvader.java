import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class SpaceInvader extends PApplet
{
    protected PApplet applet;
    protected PImage img;
    protected PImage img0;
    protected PImage img2;
    protected PImage img3;
    protected PImage img4;
    protected PImage img5;
    protected PImage img6;
    protected boolean isLeft, isRight, fire, isLeft2, isRight2, fire2;
    protected SpaceShip h;
    protected int score;
    protected int lives = 3;
    protected int shoot = 0;
    protected ArrayList<Bullet> b = new ArrayList<>();
    protected ArrayList<Bullets> b2 = new ArrayList<>();
    protected ArrayList<Invader> Invader = new ArrayList<Invader>();

    public static void main(String[] args)
    {
        PApplet.main(new String[] {"SpaceInvader"});
    }

    public void settings()
    {
        size(1920 , 1200);
    } 

    public void setup() 
    {
        h = new SpaceShip(this);
        img = loadImage("laser.png");
        //img0 = loadImage("C.png");
        img2 = loadImage("hii.jpeg");
        img3 = loadImage("gameover.png");
        img4 = loadImage("Alien.png");
        img5 = loadImage("spaceship.gif");
        img6 = loadImage("SKT.jpg"); 
        img.resize(10,10);
        textSize(72);
        // text(score, 100,100); 
        fill(256, 256, 0);
        //img0.resize(10,10);
        for (int i = 0; i < 25; i++)
        {
            Invader.add(new Invader(this)); 
        }

        for(int row = 1, o = 0; row <= 5; row++)
        {
            for(int col = 1; col <= 5; col++)
            {
                Invader.get(o).setY(75*row);
                Invader.get(o).setX(200 * col);
                o++;
            }
        }
    }

    public void draw() 
    {
        background(img2);   
        frameRate(60);
        //h.show();
        image(img5, h.getX() - 50,h.getY() - 40);
        textSize(72);
        fill(256, 256, 0);
        text(score, 100,100); 

        for(int o = 0; o < Invader.size(); o++)
        {

            //Invader.get(o).show();
            img4.resize(150,150);
            image(img4 , Invader.get(o).getX()- 70 , Invader.get(o).getY()-65); 
            if(isRight2)
            {
                Invader.get(o).move1();
            }
            if(isLeft2)
            {
                Invader.get(o).move2();
            }
            if(fire2)
            {
                invade();
            }
        }
        // shoot++;
        // System.out.println(shoot);
        // if(shoot == 180)
        // {
        // shoot = 0;
        // invade();
        // }

        if(isLeft)
        { 
            h.move(-10);
        }
        if(isRight)
        {
            h.move(10);
        }
        if(fire)
        {
            if(b.size() > 1)
            {
                fire = false;
            }
            fire();
        }

        for(int i = 0; i < b.size(); i++)
        {
            b.get(i).show();
            image(img , b.get(i).getX() -10, b.get(i).getY()); 
            b.get(i).move2();
            if(b.get(i).getY() < 0)
            {
                b.remove(i);
            }
            check();
        } 
        for(int i = 0; i < b2.size(); i++)
        {
            b2.get(i).show();
            image(img , b2.get(i).getX() -10, b2.get(i).getY()); 
            b2.get(i).move2();
            check1();
        } 
        for(int j = 0; j < Invader.size(); j++) //Collsions between SpaceShip and Invaders
        {
            float dist2 = dist(h.getX(),h.getY(),Invader.get(j).getX(), Invader.get(j).getY()); 
            if(dist2 < 100)
            {
                img3.resize(1920, 1200);
                background(img3);
                h = new SpaceShip(null);           
                break;
            }
        }
        if(Invader.size() == 0) //Winning Screen
        {
            img6.resize(1920, 1200);
            background(img6);
            textSize(72);
            fill(256, 256, 0);
            text("Your Final Score: " + score, 100,100); 
        }

    }

    public void fire() //SpaceShip Bullets
    {
        b.add(new Bullet(this,h));
        for(int i = 0; i < b.size(); i++)
        {
            b.get(i).show();
            b.get(i).move2();
        }
    }

    public void invade() //Invader Bullets
    {
        b2.add(new Bullets(this, Invader.get((int)(Math.random()*Invader.size())))); 
        if(b2.size() > 34)
        {
            b2.remove(0);
            
        }
        // for(int i = 0; i < 5; i++)
        // {
        // b2.add(new Bullets(this, Invader.get((int)(Math.random()*Invader.size()))));                    
        // }
//         for(int i = 0; i < 5; i++)
//         {
//             b2.get(i).show();
//             // if (b2.size() >= 10)
//             // {
//             // break;
//             // }
//             if(b2.get(i).getY() > applet.height)
//             {
//                 b2.remove(i);
//             }
//         }
    }

    public void check1() //SpaceShip and Invader's Bullets Collsions
    {
        for(int j = 0; j < b2.size() ; j++)
        {
            float dist = dist(b2.get(j).getX(),b2.get(j).getY(),h.getX(),h.getY());
            if(dist < 45) 
            {
                img3.resize(1920, 1200);
                background(img3);
                textSize(72);
                fill(256, 256, 0);
                text("Your Final Score: " + score, 100,100); 
                noLoop();
            }

        }
    }

    public void check() //SpaceShip's Bullets and Invader Collsions
    {

        for(int i = Invader.size() - 1; i >= 0; i--)
        {
            for(int j = b.size()-1; j >= 0; j--)
            {
                float dist = dist(b.get(j).getX(),b.get(j).getY(),Invader.get(i).getX(), Invader.get(i).getY());
                if(dist < 50)
                {
                    b.remove(j);
                    Invader.remove(i);
                    score += 10;
                    break;
                }
            }
        }
    }

    public void keyPressed() 
    {
        setMove(keyCode, true);
    }

    public void keyReleased()
    {
        setMove(keyCode, false);
    }

    public boolean setMove(int k, boolean b)
    {
        switch (k) {

            case LEFT:
            return isLeft = b;

            case RIGHT:
            return isRight = b;

            case UP:
            return fire = b;

            case 'A':
            return isLeft2 = b;

            case 'D':
            return isRight2 = b;

            case 'S':
            return fire2 = b;

            default:
            return b;
        }
    }  
}
