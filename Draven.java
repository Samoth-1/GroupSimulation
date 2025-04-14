import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Draven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Draven extends Ranged
{
    private GreenfootImage characterImage = new GreenfootImage("Draven.png");
    public Draven(int team, int pos)
    {
        super(team, pos);
        characterImage.scale(80,80);
        setImage(characterImage);
    }
    public void act(){
        super.act();
    }
    private int range = 90;
    private int damage = 75;
    private int hp = 300;
    private int speed = 5;
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
    public void ability(){//increasing damage
        damage = 75+timesattacked;
    }
}
