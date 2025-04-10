import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Character extends Actor
{
    protected int team;// team 1 or 2
    protected int pos; // which square on field
    
    protected int range;
    protected int damage;
    protected int hp;
    protected int speed;
    protected boolean inRange;
    protected boolean ranged;
    protected boolean canUpgrade;
    protected int price;
    public Character(int team, int pos){
        this.team = team;
        this.pos = pos;
        this.hp=hp;

        
        //setImage
    }
    ArrayList<Character> enemies;
    public void addedToWorld(){
        enemies = new ArrayList<Character>();
        for(Character c:getWorld().getObjects(Character.class)){
            if(c.getTeam()!=team){
                enemies.add(c);
            }
        }
    }
    public void act()
    {
        target();
        attack();
    }
    Character closest;
    private void target(){
        closest = null;
        int shortestDistance = Integer.MAX_VALUE;
        for(Character c:enemies){
            int dx = c.getX()-getX();
            int dy = c.getY()-getY();
            int distance = (int)Math.sqrt(dx*dx+dy*dy);
            if(distance<shortestDistance){
                shortestDistance=distance;
                closest=c;
            }
        }
        if(closest!=null&&shortestDistance>range){
            turnTowards(closest.getX(),closest.getY());
            move(1);
            inRange=false;
        }else if(closest!=null&&shortestDistance<=range){
            turnTowards(closest.getX(),closest.getY());
            inRange=true;
        }
    }
    protected abstract void attack();
    //seperate ranged and melee

    public abstract void upgrade();



    protected void dealDamage(int d){
        hp-=d;
        if(hp<=0) getWorld().removeObject(this);
    }
    public int getTeam(){
        return team;
    }

    public boolean isRanged()
    {
        return ranged;
    }
    public boolean canUpgrade()
    {
        return canUpgrade;
    }
}

