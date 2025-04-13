import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gwen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gwen extends Melee
{
    public Gwen(int team, int pos)
    {
        super(team, pos);
        //setImage(new GreenfootImage(""));
    }
    public void act(){
        super.act();
    }
    private int range = 20;
    private int damage = 0;
    private int hp = 800;
    private int speed = 6;
    private int price = 10;
    public void upgrade(){
        
    }
    public void ability(){// passive ability deals 20% max hp damage
        damage=closest.getHp()/5;
    }
}
