import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vayne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vayne extends Ranged
{
    public Vayne(int team, int pos)
    {
        super(team, pos);
        //setImage(new GreenfootImage(""));
    }
    public void act(){
        super.act();
    }
    private int range = 90;
    private int damage = 50;
    private int hp = 500;
    private int speed = 10;
    private int price = 10;
    private int timesattacked = 0;
    public void upgrade(){
        
    }
    protected void attack(){
        if(!inRange) return;
        if(atk==0){
            shootProjectile();
            timesattacked++;
        }
    }
    public void ability(){//every 3rd attack deals double damage
        if((timesattacked+1)%3==0){
            damage=100;
        }else{
            damage=50;
        }
    }
}
