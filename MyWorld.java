import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    private TextBar t1 = new TextBar("0", 200, Color.BLUE, Color.YELLOW);
    private TextBar t2 = new TextBar("0", 200, Color.BLUE, Color.YELLOW);
    private int random = Greenfoot.getRandomNumber(1);
    private Player1 p1;
    private Player1 p2;
    public static boolean start;
    
    private static ArrayList<Integer> reserved = new ArrayList<Integer>();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        drawChessBoard();
        start = false;
    }

    public void act()
    {
        reserved.clear();
        if (random == 0 && p1 == null) 
        {
            p1 = new Player1(500, 1, 1);
            addObject(p1, -100, -100);
            
            p2 = new Player1(500, 2, 2);
            addObject(p2, -100, -100);
        }

        if (p1 != null && p2 != null) 
        {
            t1.setText(String.valueOf(p1.getGold()));
            t2.setText(String.valueOf(p2.getGold()));
        }
        
        if (!p1.getSpawning() && !p2.getSpawning() && !start)
        {
            start = true;
        }
    }
    
    public static boolean assign(int position)
    {
        if (reserved.contains(position))
        {
            return true;
        }
        reserved.add(position);
        return false;
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
