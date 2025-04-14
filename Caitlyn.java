import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caitlyn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caitlyn extends Ranged
{
    private GreenfootImage characterImage = new GreenfootImage("Caitlyn.png");
    public Caitlyn(int team, int pos)
    {
        super(team, pos);
        characterImage.scale(80,80);
        setImage(characterImage);
    }
    public void act(){
        super.act();
    }
    private int range = 150;
    private int damage = 60;
    private int hp = 500;
    private int speed = 5;
    private int price = 10;
    private int timesattacked = 0;
    protected int atkspeed = 120;
    public void upgrade(){
        
    }
    protected void attack(){
        if(!inRange) return;
        if(atk==0){
            shootProjectile();
            timesattacked++;
        }
    }
    public void ability(){ // attack twice every 5 times
        if(timesattacked%5==0)shootProjectile();
    }
}
