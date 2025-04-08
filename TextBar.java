import greenfoot.*;  
/**
 * A class to create a simple textbar
 * Author: Thomas Wu
 */
public class TextBar extends Actor
{
    private boolean change = true;
    private String text;
    private Color foregroundColor;
    private Color backgroundColor;
    private int size;
    public TextBar(String text, int size, Color foregroundColor, Color backgroundColor)
    {
        this.text = text;
        this.foregroundColor= foregroundColor;
        this.backgroundColor = backgroundColor;
        this.size = size;
    }
    public void act()
    {
        if (change)
        {
            GreenfootImage image = new GreenfootImage(text, size, foregroundColor,backgroundColor);
            setImage(image);
            change = false;
        }
    }
    public void setText(String changedText)
    {
        text = changedText;
        change = true;
    }
    public void setForegoundColor (Color changedColor)
    {
        foregroundColor = changedColor;
        change= true;
    }
    public void setBackgroundColor (Color changedColor)
    {
        backgroundColor = changedColor;
        change = true;
    }
}
