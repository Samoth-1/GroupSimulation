import greenfoot.*;

public class EndWorld extends World
{
    public EndWorld(int winner)
    {    
        super(1024, 800, 1); 
        showEndScreen(winner);
    }

    private void showEndScreen(int winner){
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();
        String message = (winner == 1) ? "Player 1 Wins!" : "Player 2 Wins!";
        Color textColor = (winner == 1) ? Color.RED : Color.BLUE;
        GreenfootImage result = new GreenfootImage(message, 60, textColor, Color.BLACK);
        bg.drawImage(result, getWidth()/2 - result.getWidth()/2, 300);
    }
}
