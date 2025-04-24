import greenfoot.*; 

/**
 * A bullet class that create bullet for long range characters
 * 
 * By Ricky Z
 */
public class Bullet extends Actor
{
    private int team;
    private int beam;

    public Bullet(int team){
        GreenfootImage image = new GreenfootImage(32,32);
        image.setColor(Color.BLACK);
        image.fillOval(0, 0, 32, 32);
        setImage(image);
        this.team = team;
        if(team == 1) beam = 2;
        else beam = 1;
    }

    public void act() {
        if (getWorld() == null) return;

        move(5);

        // edge‐of‐screen cleanup
        if (isAtEdge()) {
            getWorld().removeObject(this);
            return;
        }

        // only interact with a live Chara
        Chara target = (Chara)getOneIntersectingObject(Chara.class);
        if (target != null && target.getWorld() != null && target.getTeam() == beam) {
            target.dealDamage(10);
            // now kill the bullet
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
}
