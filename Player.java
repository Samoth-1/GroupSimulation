import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This is the player class. It is the underlying logic that spawn characters in specific formation, using gold
 * to purchase characters, and based on the type of players, all of these could be different
 * For every type of formation, melees will always spawned in front of range characters, and the ratio between melees
 * and range characters may vary based on the type of character
 * 
 * By Thomas Wu
 */
public abstract class Player extends Actor
{
    protected int gold;
    protected ArrayList <Chara> myCharacters = new ArrayList <Chara>();
    protected ArrayList <Integer> positions = new ArrayList <Integer>();
    protected ArrayList <Chara> meleeWishList = new ArrayList <Chara>();
    protected ArrayList <Chara> rangedWishList = new ArrayList <Chara>();
    protected int actCount;
    protected int type;
    protected int side;
    protected boolean prepare = true;
    protected int X1 = 974;
    protected int X2 = 50;
    protected int Y = 130;
    protected int i = 0;

    //Constructor for Player
    public Player(int gold, int type, int side)
    {
        this.gold = gold;
        this.type = type;
        this.side = side;
    }

    public void act()
    {
        preparing();
        if (!prepare)
        {
            spawn();
        }
    }

    public abstract void formation();

    //This method will spawn all characters in the left/right of the world in prepare zone 
    public void preparing()
    {
        if (i >= myCharacters.size())
        {
            prepare = false;
            i = 0;
        }
        if (prepare)
        {
            actCount ++;
            if (actCount%60 == 0 && i < myCharacters.size() && side == 2)
            {
                getWorld().addObject(myCharacters.get(i), X1, Y);
                myCharacters.get(i).getImage().mirrorHorizontally();
                i += 1;
                Y += 50;
                actCount = 0;
            }
            if (actCount%60 == 0 && i < myCharacters.size() && side == 1)
            {
                getWorld().addObject(myCharacters.get(i), X2, Y);

                i += 1;
                Y += 50;
                actCount = 0;
            }
        }

    }

    //method to check if any character that is in my team die
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

    public String getGold()
    {
        return String.valueOf(gold);
    }

    //Two method to convert coordinate to position number. Positions are labelled from left to right, and after a rwo is fully labbelled
    //goes to the next row
    public int convertX(int position) {
        int col = position % 8;
        return 128 + col * 96 + 48;  
    }

    public int convertY(int position) {
        int row = position / 8;
        return 16 + row * 96 + 48;
    }

    protected int index = 0;
    protected boolean spawning = true;
    //This method will put characters in the desired formation
    public void spawn()
    {
        if (index >= myCharacters.size())
        {
            spawning = false;
        }
        if (spawning)
        {
            actCount ++;
            if (index < myCharacters.size() && actCount % 30 == 0)
            {
                myCharacters.get(index).setLocation(convertX(positions.get(index)), convertY(positions.get(index)));
                index += 1;
            }
        }
    }

    //The player will purchase characters using gold
    public void shopping(int chance)
    {
        int count = 0;
        int size = 0;
        int r;

        while (gold >= 10 && size < 10)
        {
            //chance determine the ratio between melee and ranged
            if (Greenfoot.getRandomNumber(chance) == 0)
            {
                r = Greenfoot.getRandomNumber(5);
                if (r == 0)
                {
                    Darius m = new Darius (side, 1);
                    meleeWishList.add(m);
                    gold = gold - 10;
                }
                else if (r == 1)
                {
                    Gwen m = new Gwen (side, 1);
                    meleeWishList.add(m);
                    gold = gold - 10;
                }
                else if (r == 2)
                {
                    Jax m = new Jax (side, 1);
                    meleeWishList.add(m);
                    gold = gold - 10;
                }
                else if (r == 3)
                {
                    Yasuo m = new Yasuo (side, 1);
                    meleeWishList.add(m);
                    gold = gold - 10;
                }
                else
                {
                    Yone m = new Yone (side, 1);
                    meleeWishList.add(m);
                    gold = gold - 10;
                }
            }

            else
            {
                r = Greenfoot.getRandomNumber(5);
                if (r == 0)
                {
                    Ashe m = new Ashe (side, 1);
                    rangedWishList.add(m);
                    gold = gold - 10;
                }
                else if (r == 1)
                {
                    Caitlyn m = new Caitlyn (side, 1);
                    rangedWishList.add(m);
                    gold = gold - 10;
                }
                else if (r == 2)
                {
                    Draven m = new Draven (side, 1);
                    rangedWishList.add(m);
                    gold = gold - 10;
                }
                else if (r == 3)
                {
                    Kaisa m = new Kaisa (side, 1);
                    rangedWishList.add(m);
                    gold = gold - 10;
                }
                else
                {
                    Vayne m = new Vayne (side, 1);
                    rangedWishList.add(m);
                    gold = gold - 10;
                }
            }
            size = meleeWishList.size() + rangedWishList.size();
        }
        //seperate melee and ranged for easier management
        for (Chara m : meleeWishList)
        {
            myCharacters.add(m);
        }  
        for (Chara m : rangedWishList)
        {
            myCharacters.add(m);
        }

    } 

    //if finish spawning, let the world begin the fight
    public boolean getSpawning()
    {
        return spawning;
    }
    public boolean hasAliveCharacters() {
        for (Chara c : myCharacters) {
            if (c.getWorld() != null) {
                return true;
            }
        }
        return false;
    }

}

