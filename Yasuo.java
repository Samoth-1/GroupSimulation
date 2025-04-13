import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yasuo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yasuo extends Melee
{
    public Yasuo(int team, int pos)
    {
        super(team, pos);
        //setImage(new GreenfootImage(""));
    }
    public void act(){
        super.act();
    }
    private int range = 25;
    private int damage = 75;
    private int hp = 800;
    private int speed = 7;
    private int price = 10;
    public void upgrade(){
        
    }
    public void ability(){// can crit at random times
        int a = Greenfoot.getRandomNumber(2);
        if(a==2){
            damage=150;
        }else{
            damage=75;
        }
    }
}
