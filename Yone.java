import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yone extends Melee
{
    private GreenfootImage characterImage = new GreenfootImage("Yone.png");
    public Yone(int team, int pos)
    {
        super(team, pos);
        characterImage.scale(80,80);
        setImage(characterImage);
    }
    public void act(){
        super.act();
    }
    private int range = 25;
    private int damage = 100;
    private int hp = 900;
    private int speed = 7;
    private int price = 10;
    public void upgrade(){
        
    }
    public void ability(){// passive ability, lifesteal
        
    }
    public void attack(){
        if(!inRange) return;
        if(atk==0){
            closest.dealDamage(damage);
            hp+=25;
            if(hp>900)hp=900;
        }
    }
}
