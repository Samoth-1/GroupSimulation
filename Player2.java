import greenfoot.*; 

/**
 * Player subclass with line formation
 * By Thomas W
 */
public class Player2 extends Player
{
    public Player2(int gold, int type, int side)
    {
        super(gold, type, side);
        shopping(3);
        formation();
    }
    public void act()
    {
        super.act();
    }
    //line formation
    public void formation()
    {
        if (side == 1)
        {
            for (int i = 0; i < 8; i++)
            {
                positions.add(8 * i);
            }
            positions.add(25);
            positions.add(33);
        }
        else
        {
            for (int i = 1; i < 9; i++)
            {
                positions.add(8*i - 1);
            }
            positions.add(30);
            positions.add(38);
        }
    }
}
