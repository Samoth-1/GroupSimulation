import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player1(int gold, int type, int side)
    {
        super(gold, type, side);
        shopping(2);
        formation();
        

    }
    
    public void act()
    {
        super.act();
    }
    
    //triangle formation
    public void formation()
    {
        int size = myCharacters.size();
        //count row of triangle
        int count = 0;
        int total = 0;
        while (total < size)
        {
            count += 1;
            total += count;
        }
        
        //calculate position from right to left
        //n row of triangle contain n objects
        //using coordnate (x, y) to solve the conversion
        int Y;
        int rowCount = 0;
        int pos;
        int X;
        if (Greenfoot.getRandomNumber(1) == 0)
        {
            X = 4;
        }
        else
        {
            X = 5;
        }
        if (side == 1)
        {

            Y = count - 1;
            int XCopy = X;
            //Calculate position number for triangle
            while(positions.size() < size)
            {

                rowCount += 1;
                for (int i = 0; i < rowCount; i++)
                {
                    pos = X * 8 + Y;
                    positions.add(pos);
                    X += 2;
                }
                Y -= 1;
                XCopy -= 1;
                X = XCopy;

            }
        }
        else
        {

            Y = 8 - (count);
            int XCopy = X;
            while(positions.size() < size)
            {
                rowCount += 1;
                for (int i = 0; i < rowCount && positions.size() < size; i++)
                {
                    pos = X * 8 + Y;
                    positions.add(pos);
                    X += 2;
                }
                Y += 1;       
                XCopy -= 1;  
                X = XCopy;
            }
        }
    }

    //melee : ranged = 1:3. Minimun price of melee and ranged is 50
    
}
