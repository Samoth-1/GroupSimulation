import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int gold;
    protected ArrayList <Character> myCharacters;
    protected int actCount;
    protected int type;
    protected int side;
    public Player(int gold, int type, int side)
    {
        this.gold = gold;
        this.type = type;
        
    }
    
    public abstract void formation();
    
    public void act()
    {
        if (actCount % 120 == 0)
        {
            gold += 50;
        }
        
    }
    
    public abstract void evolve();
    
    public void findMyTeam()
    {
        for (Character c : getWorld().getObjects(Character.class))
        {
            if (c.getTeam() == type)
            {
                myCharacters.add(c);
            }
            if (c == null)
            {
                myCharacters.remove(c);
            }
        }
    }
    
    public abstract Character buyCharacter();

    public int getGold()
    {
        return gold;
    }
    
    //convert position number to actual coordinate
    public int convertX(int position)
    {
  
        int X = 128 + (position % 8) * 96 - 48;
        
        return X;
    }
    
    public int convertY(int position)
    {
        int Y;
        if ((double)position / 8 == position / 8)
        {
            Y = 16 + position / 8 * 96 + 48;
        }
        else
        {
            Y = 16 + (position / 8 + 1) + 48;
        }
        return Y;
    }
}
