import greenfoot.*;

/**
 * Write a description of class Icicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Icicle1 extends Icicles
{
    SimpleTimer timer = new SimpleTimer();
    /**
     * Act - do whatever the Icicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        animate();
    }    

    public void animate(){
        if(timer.millisElapsed() > 0)setImage("s_ice1.png");
        if(timer.millisElapsed() > 50)setImage("s_ice2.png");
        if(timer.millisElapsed() > 100)setImage("s_ice3.png");
        if(timer.millisElapsed() > 150)setImage("s_ice4.png");
        if(timer.millisElapsed() > 200)setImage("s_ice5.png");
        if(timer.millisElapsed() > 250)setImage("s_ice6.png");
    }  
}
