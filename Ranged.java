import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ranged here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    private int atk = 90;
public abstract class Ranged extends Character
{
    public Ranged(int team, int pos){
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
            shootProjectile();
        }
    }
    private void attackspeed(){
        if(atk>0)atk--;
        else atk=90;
    }
    private void shootProjectile(){
        double angle = Math.toDegrees(Math.atan2(closest.getY()-getY(), closest.getX()-getX()));
        Bullet a = new Bullet(team);
        int offsetX = (int)(25*Math.cos(Math.toRadians(angle)));
        int offsetY = (int)(25*Math.sin(Math.toRadians(angle)));
        getWorld().addObject(a,getX()+offsetX,getY()+offsetY);
        a.setRotation((int)angle);
        
    }
}
