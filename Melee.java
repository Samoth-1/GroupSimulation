import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class m here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
    private int atk = 90;
public abstract class Melee extends Character
{
    public Melee(int team, int pos){
        super(team,pos);
    }
    public void act()
    {
        super.act();
        attackspeed();
    }
    protected void attack(){
        if(!inRange) return;
        if(atk==0){
            closest.dealDamage(damage);
        }
    }
    private void attackspeed(){
        if(atk>0)atk--;
        else atk=90;
    }
}
