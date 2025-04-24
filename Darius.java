import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Actual character
 * 
 * By Ricky Z
 * Since the author and the content is all same for all actual characters, I will not repeat the comment above again
 */
public class Darius extends Melee
{
    private GreenfootImage characterImage = new GreenfootImage("Darius.png");
    public Darius(int team, int pos)
    {
        super(team, pos);
        characterImage.scale(80,80);
        setImage(characterImage);
    }
    public void act(){
        super.act();
        timer++;
    }
    
    private int damage = 80;
    private int hp = 1000;
    private int speed = 5;
    private int price = 10;
    private int timer = 0;
    public void upgrade(){
        
    }
    public void ability(){// after 5 seconds, gain movement speed and damage
        if(timer>=300){
            speed=10;
            damage=100;
        }
    }
}
