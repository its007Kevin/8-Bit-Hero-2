import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * //added the reset method turn all the controls of the character back on;
 */
public class Back extends MenuElements
{
    private boolean mouseOver = true;
    GreenfootSound mouseOverSound = new GreenfootSound("nextSelection.wav");
    GreenfootSound select = new GreenfootSound("lockIn.wav");
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!mouseOver && Greenfoot.mouseMoved(this)){
            mouseOverSound.play();
            setImage("Back2.png");
            mouseOver = true;
        }
        if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this)){
            setImage("Back.png");
            mouseOver = false;
        }
        if(Greenfoot.mouseClicked(this)){
            select.play();
            Background.music.stop();
            CreditScreen.music.stop();
            Background.winnerMusic.stop();
            Background.winner1.stop();
            Background.winner2.stop();
            Greenfoot.setWorld(new Menu());
        }
    }         
}
