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
    protected ArrayList <Chara> myCharacters = new ArrayList <Chara>();
    protected ArrayList <Integer> positions = new ArrayList <Integer>();
    protected ArrayList <Chara> meleeWishList = new ArrayList <Chara>();
    protected ArrayList <Chara> rangedWishList = new ArrayList <Chara>();
    protected int actCount;
    protected int type;
    protected int side;
    protected boolean prepare = true;
    public Player(int gold, int type, int side)
    {
        this.gold = gold;
        this.type = type;
        this.side = side;
    }
    
    public void act()
    {
    }
    
    public abstract void formation();
    
    public void prepare()
    {
        actCount ++;
    }
    public void findMyTeam()
    {
        for (Chara c : myCharacters)
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
    
    public void shopping(int chance)
    {
        int count = 0;
        int size = 0;
        int r;
        
        while (gold >= 10 && size <= 10)
        {
            if (count % chance == 0)
            {
                r = Greenfoot.getRandomNumber(5);
                if (r == 0)
                {
                    Darius m = new Darius (side, 1);
                    meleeWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else if (r == 1)
                {
                    Gwen m = new Gwen (side, 1);
                    meleeWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else if (r == 2)
                {
                    Jax m = new Jax (side, 1);
                    meleeWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else if (r == 3)
                {
                    Yasuo m = new Yasuo (side, 1);
                    meleeWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else
                {
                    Yone m = new Yone (side, 1);
                    meleeWishList.add(m);
                    gold = gold - m.getPrice();
                }
                }

            else
            {
                r = Greenfoot.getRandomNumber(5);
                if (r == 0)
                {
                    Ashe m = new Ashe (side, 1);
                    rangedWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else if (r == 1)
                {
                    Caitlyn m = new Caitlyn (side, 1);
                    rangedWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else if (r == 2)
                {
                    Draven m = new Draven (side, 1);
                    rangedWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else if (r == 3)
                {
                    Kaisa m = new Kaisa (side, 1);
                    rangedWishList.add(m);
                    gold = gold - m.getPrice();
                }
                else
                {
                    Vayne m = new Vayne (side, 1);
                    rangedWishList.add(m);
                    gold = gold - m.getPrice();
                }
            }
            size = meleeWishList.size() + rangedWishList.size();
        }
        for (Chara m : meleeWishList)
        {
            myCharacters.add(m);
        }  
        for (Chara m : rangedWishList)
        {
            myCharacters.add(m);
        }

        
        } 
    }

