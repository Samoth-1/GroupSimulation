import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kaisa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kaisa extends Ranged
{
    private GreenfootImage characterImage = new GreenfootImage("Kaisa.png");
    public Kaisa(int team, int pos)
    {
        super(team, pos);
        characterImage.scale(80,80);
        setImage(characterImage);
    }
    public void act(){
        super.act();
    }
    private int range = 1100;
    private int damage = 40;
    private int hp = 500;
    private int speed = 5;
    private int price = 10;
    public void upgrade(){
        
    }
    public void ability(){//passive ability, attacks furthest enemy instead
        
    }
    public void returnAttackSpeed(){
        atkspeed = 90;
    }
    public void returnSpeed(){
        speed = 5;
    }
    private void target(){
        closest = null;
        int shortestDistance = Integer.MIN_VALUE;
        for(Chara c:enemies){
            int dx = c.getX()-getX();
            int dy = c.getY()-getY();
            int distance = (int)Math.sqrt(dx*dx+dy*dy);
            if(distance>shortestDistance){
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
}
