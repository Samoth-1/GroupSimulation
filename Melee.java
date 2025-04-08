import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class m here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Melee extends Character
{
    public Melee(int team, int pos, int range, int hp, int damage, int speed){
        super(team,pos,range,hp,damage,speed);
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
    int atk = 90;
    private void attackspeed(){
        if(atk>0)atk--;
        else atk=90;
    }
}
