import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jax extends Melee
{
    public Jax(int team, int pos)
    {
        super(team, pos);
        //setImage(new GreenfootImage(""));
    }
    public void act(){
        super.act();
    }
    private int range = 25;
    private int damage = 90;
    private int hp = 950;
    private int speed = 7;
    private int price = 10;
    private boolean activated = false;
    public void upgrade(){
        
    }
    public void ability(){//at 40% hp, gain shield
        if(activated) return;
        if(hp==400){
            hp=700;
            activated=true;
        }
    }
}
