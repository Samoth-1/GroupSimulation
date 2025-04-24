import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super class for melees
 * 
 * By Ricky Z
 */

public abstract class Melee extends Chara
{
    protected GreenfootImage characterImage;
    private GreenfootImage originalImage;
    private boolean isSpinning = false;
    protected int atk = 90;
    protected int range = 97;
    public Melee(int team, int pos){
        super(team,pos);
        originalImage = getImage();
    }
    public void act()
    {
        super.act();
        if(isSpinning){
            spinAnimation();
        }else{
            attackspeed();
        }
    }
    protected void attack(){
        if(!inRange) return;
        if(atk==0 && !isSpinning){
            closest.dealDamage(damage);
            isSpinning = true;
            spinFrames = 0;
        }
    }
    private void spinAnimation() {
        spinFrames++;
        setRotation(getRotation() + 12);
        if(spinFrames >= 30){
            isSpinning = false;
            setRotation(0);
            atk = atkspeed;
            setImage(originalImage);
        }
    }
    private void attackspeed(){
        if(atk>0)atk--;
        else atk=atkspeed;
    }
}
