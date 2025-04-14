import greenfoot.*;
public class Ashe extends Ranged 
{
    private GreenfootImage characterImage = new GreenfootImage("Ashe.png");
    public Ashe(int team, int pos)
    {
        super(team, pos);
        characterImage.scale(80,80);
        setImage(characterImage);
    }
    public void act(){
        super.act();
    }
    private int range = 100;
    private int damage = 50;
    private int hp = 500;
    private int speed = 5;
    private int price = 10;
    private int timesattacked = 0;
    public void upgrade(){
        
    }
    protected void attack(){
        if(!inRange) return;
        if(atk==0){
            shootProjectile();
            timesattacked++;
        }
    }
    public void ability(){//increasing attack speed
        atkspeed = 90-timesattacked;
    }
}
