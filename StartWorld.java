import greenfoot.*; 

public class StartWorld extends World
{
    public StartWorld()
    {    
        super(1024, 800, 1); 
        showStartScreen();
    }

    private void showStartScreen(){
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();
        GreenfootImage title = new GreenfootImage("Auto battler", 60, Color.WHITE, Color.BLACK);
        bg.drawImage(title, getWidth()/2 - title.getWidth()/2, 200);
        GreenfootImage instructions = new GreenfootImage("Press space to start", 36, Color.YELLOW, Color.BLACK);
        bg.drawImage(instructions, getWidth()/2 - instructions.getWidth()/2, 400);
    }
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
