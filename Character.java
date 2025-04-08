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
    int team;// team 1 or 2
    int pos; // which square on field
    
    int range;
    int damage;
    int hp;
    int speed;
    boolean inRange;
    
    public Character(int team, int pos, int range, int hp, int damage, int speed){
        this.team = team;
        this.pos = pos;
        this.hp=hp;
        this.damage=damage;
        this.speed=speed;
        
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

    protected void dealDamage(int d){
        hp-=d;
        if(hp<=0) getWorld().removeObject(this);
    }
    public int getTeam(){
        return team;
    }
}
