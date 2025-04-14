import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private boolean player = false;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        drawChessBoard();
        
    }
    
    public void act()
    {
        if (!player)
        {
            Player1 p = new Player1 (230, 1, 1);
            addObject(p, -100, -100);
           
            
            Player1 l = new Player1 (500, 1, 2);
            addObject(l, -100, -100);
            player = true;
        }
    }
    public void drawChessBoard()
    {
        //Draw square cells with side length of 96. The x value start from 128, end at 800.
        //The y value start at 16, and end at 688
        int count = 0;
        for(int Y = 16; Y <= 688; Y += 96)
        {
            for(int X = 128; X <= 800; X += 96)
            {
                if (count % 2 == 0)
                {
                    getBackground().setColor(Color.BLACK);
                }
                else
                {
                    getBackground().setColor(Color.WHITE);
                }
                getBackground().fillRect(X, Y, 96, 96);
                count ++;
            }
            count ++;
        }
        
        getBackground().setColor(Color.BLACK);
        for(int i = 128; i <= 896; i += 96)
        {
            getBackground().drawLine(i, 16, i, 784);
        }
        for(int i = 16; i <= 784; i += 96)
        {
            getBackground().drawLine(128, i, 896, i);
        }
    }
}
