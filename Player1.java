import greenfoot.*;  

/**
 * A specific player that want a triangle formation
 * 
 * By Thomas Wu
 */
public class Player1 extends Player
{
    
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

    
}
