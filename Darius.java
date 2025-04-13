import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Darius here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Darius extends Melee
{
    public Darius(int team, int pos)
    {
        super(team, pos);
        //setImage(new GreenfootImage(""));
    }
    public void act(){
        super.act();
        timer++;
    }
    private int range = 20;
    private int damage = 80;
    private int hp = 1000;
    private int speed = 5;
    private int price = 10;
    private int timer = 0;
    public void upgrade(){
        
    }
    public void ability(){// after 5 seconds, gain movement speed and damage
        if(timer>=300){
            speed=10;
            damage=100;
        }
    }
}
