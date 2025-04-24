import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for Ranged
 * 
 * By Ricky Z
 */

    
public abstract class Ranged extends Chara
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
    protected void attackspeed(){
        if(atk>0)atk--;
        else atk=atkspeed;
    }
    protected void shootProjectile(){
        double angle = Math.toDegrees(Math.atan2(closest.getY()-getY(), closest.getX()-getX()));
        Bullet a = new Bullet(team);
        int offsetX = (int)(25*Math.cos(Math.toRadians(angle)));
        int offsetY = (int)(25*Math.sin(Math.toRadians(angle)));
        getWorld().addObject(a,getX()+offsetX,getY()+offsetY);
        a.setRotation((int)angle);
        
    }
}
