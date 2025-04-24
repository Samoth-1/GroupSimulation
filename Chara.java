import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The super class for actual characters
 * 
 * Oringinal version be Ricky Z
 * Moving algorithm and bug fix by Thomas W
 */
public abstract class Chara extends SuperSmoothMover
{
    protected int team;// team 1 or 2
    protected int pos; // which square on field

    protected int atkspeed = 90;
    protected int atk = 90;
    protected int range;
    protected int damage;
    protected int hp = 100;
    protected int speed;
    protected boolean inRange;
    protected boolean ranged;
    protected boolean canUpgrade;
    protected int price;
    protected int moveCount;
    public Chara(int team, int pos){
        this.team = team;
        this.pos = pos;
    }
    protected ArrayList<Chara> enemies = new ArrayList<Chara>();
    public void addedToWorld(){
        enemies = new ArrayList<Chara>();

    }

    public void act() {
        if (getWorld() == null) return;

        if (hp <= 0) {
            getWorld().removeObject(this);
            return;
        }
        
        //The characters start to detect enemy when the world calls start
        if (MyWorld.start) {
            //ArrayList to find all enemies
            enemies.clear();
            for (Chara c : getWorld().getObjects(Chara.class)) {
                if (c.getTeam() != team) {
                    enemies.add(c);
                }
            }
            if (!enemies.isEmpty()) {
                target();
                moving();
                if (inRange)
                {
                    attack();
                    ability();
                }
            }
        }
    }
    Chara closest;
    protected int dx;
    protected int dy;
    protected double coordinateDistance;
    protected int newX;
    protected int newY;
    protected boolean moveX;
    protected boolean moveY;
    protected int assignedPosition;
    protected int random;
 
    //A target class to find closest enemy and assign the destination spot.
    //There are still overlapping exist, but it will get way too complicated if want to completely avoid overlapping
    //if a character want to move, it first need to assign its destination spot into an arrayList in World
    //if that spot already exist, the character will not move
    public void target(){
        moveCount++;
        closest = null;
        int shortestDistance = Integer.MAX_VALUE;
        //find closest enemy
        for(Chara c:enemies){
            dx = (Math.abs(c.getX()-getX()))/96;
            dy = (Math.abs(c.getY()-getY()))/96;
            int distance = dx + dy;
            if(distance<shortestDistance){
                shortestDistance=distance;
                coordinateDistance = Math.sqrt(Math.pow((dx * 96), 2) + Math.pow((dy * 96), 2));
                closest=c;
            }
        }
        if (moveCount >= 300)
        {
            if(closest!=null&&coordinateDistance>range)
            {
                random = Greenfoot.getRandomNumber(2);
                // if the enemy is on the same row, move horizontally
                // if on the same column, move vertically
                // if neither, roll the dice
                if (closest.getY() == getY())
                {
                    changeX();
                }
                else if (closest.getX() == getX())
                {
                    changeY();
                }
                else 
                {
                    if (random == 0)
                    {
                        changeX();
                    }
                    else
                    {
                        changeY();
                    }
                }                
                // if not moving, assign the current location.
                if (!moveX && !moveY)
                {
                    assignedPosition = convertPosition(getX(), getY());
                    MyWorld.assign(assignedPosition);
                   
                }
            }
            inRange=false;
            moveCount = 0;
        }
        if(closest!=null&&coordinateDistance<=range)
        {
            inRange=true;
        }
    }

    //convert coordinate to position number
    public int convertPosition (int x, int y)
    {
        return (x - 128) / 96 + (y - 16) / 96 * 8;
    }

    //if the character is moving horizontally
    public void changeX()
    {
        if (closest.getY() == getY())
        {
            moveX = false;
            moveY = false;
            //if the enemy is on the left, move to the left, vice versa
            if (closest.getX() < getX())
            {
                newX = getX() - 96;
            }
            if (closest.getX() > getX())
            {
                newX = getX() + 96;
            }
            //assign destination
            assignedPosition = convertPosition(newX, getY());
            if (!MyWorld.assign(assignedPosition))
            {
                moveX = true;
                moveY = false;
            }
        }
    }
    
    //exactly same logic as changeX, but move vertically
    public void changeY()
    {
        moveX = false;
        moveY = false;
        if (closest.getY() < getY())
        {
            newY = getY() - 96;
        }
        else
        {
            newY = getY() + 96;
        }
        assignedPosition = convertPosition(getX(), newY);
        if (!MyWorld.assign(assignedPosition))
        {
            moveX = false;
            moveY = true;
        }
    }

    //The actual moving method.
    public void moving()
    {
        //move 2 cells per act horizontally
        if (moveX)
        {
            if (newX < getX())
            {
                setLocation(getX() - 2, getY());
            }
            else
            {
                setLocation(getX() + 2, getY());
            }
            if (newX == getX())
            {
                moveX = false;
            }
        }
        //move 2 cells per act vertically
        if (moveY)
        {
            if (newY < getY())
            {
                setLocation(getX(), getY() - 2);
            }
            else
            {
                setLocation(getX(), getY() + 2);
            }
            if (newY == getY())
            {
                moveY = false;
            }
        }
    }
    
    
    public int convertX(int position) {
        int col = position % 8;
        return 128 + col * 96 + 48;  
    }

    public int convertY(int position) {
        int row = position / 8;
        return 16 + row * 96 + 48;
    }

    protected abstract void attack();

    protected abstract void ability();

    public abstract void upgrade();

    protected void dealDamage(int d){
        hp-=d;
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

    public int getHp(){
        return hp;
    }

    public int getPrice()
    {
        return price;
    }

    public void setSpeed(int t){
        speed=t;
    }

    public void setAttackSpeed(int t){
        atkspeed=t;
    }

}

