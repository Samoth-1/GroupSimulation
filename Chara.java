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
    protected boolean onLeftEdge;
    protected boolean onRightEdge;
    protected boolean onTopEdge;
    protected boolean onBottomEdge;
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
                if (Greenfoot.getRandomNumber(2) == 0)
                {
                    moveX = false;
                    moveY = false;
                    if (closest.getX() < getX())
                    {
                        newX = getX() - 96;
                    }
                    else
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
                else
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
                inRange=false;
                if (!moveX && !moveY)
                {
                    assignedPosition = convertPosition(getX(), getY());
                    if (MyWorld.assign(assignedPosition))
                    {
                        assignedPosition += 1;
                        if (MyWorld.assign(assignedPosition))
                        {
                            assignedPosition -= 1;
                            if (MyWorld.assign(assignedPosition))
                            {
                                assignedPosition += 8;
                                if (MyWorld.assign(assignedPosition))
                                {
                                    assignedPosition -= 8;
                                    MyWorld.assign(assignedPosition);
                                }
                            }
                        }
                    }
                }
            }
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

