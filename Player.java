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
    protected ArrayList <Champion> myCharacters = new ArrayList <Champion>();
    protected ArrayList <Integer> positions = new ArrayList <Integer>();
    protected ArrayList <Champion> meleeWishList = new ArrayList <Champion>();
    protected ArrayList <Champion> rangedWishList = new ArrayList <Champion>();
    protected int actCount;
    protected int type;
    protected int side;
    public Player(int gold, int type, int side)
    {
        this.gold = gold;
        this.type = type;
        this.side = side;
    }

    public abstract void formation();

    public void findMyTeam()
    {
        for (Champion c : myCharacters)
        {
            if (c == null)
            {
                myCharacters.remove(c);
            }
        }
    }

    public int getGold()
    {
        return gold;
    }

    public int convertX(int position) {
        int col = position % 8;
        return 128 + col * 96 + 48;  
    }

    public int convertY(int position) {
        int row = position / 8;
        return 16 + row * 96 + 48;
    }

    protected int index = 0;
    public void spawn()
    {

        
        if (index < myCharacters.size() && actCount % 30 == 0)
        {
            getWorld().addObject(myCharacters.get(index), convertX(positions.get(index)), convertY(positions.get(index)));
            index += 1;
        }
        actCount ++;
    }

}
