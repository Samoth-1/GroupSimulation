import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int team;
    int beam;
    public Bullet(int team){
        this.team = team;
        if(team == 1) beam = 2;
        else beam = 1;
    }
    public void act()
    {
        move(5);
        Character a = (Character)getOneIntersectingObject(Character.class);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
        if(a != null && a.getTeam()==beam){
            getWorld().removeObject(a);
            getWorld().removeObject(this);
            return;
        }
    }
}
