import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Chara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

        if (MyWorld.start) {

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
 
    public void target(){
        moveCount++;
        closest = null;
        int shortestDistance = Integer.MAX_VALUE;
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

    public int convertPosition (int x, int y)
    {
        return (x - 128) / 96 + (y - 16) / 96 * 8;
    }

    public void changeX()
    {
        if (closest.getY() == getY())
        {
            moveX = false;
            moveY = false;
            if (closest.getX() < getX())
            {
                newX = getX() - 96;
            }
            if (closest.getX() > getX())
            {
                newX = getX() + 96;
            }
            assignedPosition = convertPosition(newX, getY());
            if (!MyWorld.assign(assignedPosition))
            {
                moveX = true;
                moveY = false;
            }
        }
    }

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

    public void moving()
    {
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

