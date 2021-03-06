import greenfoot.*;
import java.util.*;
/**
 * Write a description of class dennis_ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dennis_ball extends Projectiles
{
    SimpleTimer timer = new SimpleTimer();
    /**
     * Act - do whatever the dennis_ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(isTouching(Freeze.class) && !Freeze.grace){
            getWorld().addObject(new dennis_ball_explode(), getX(), getY());
            if(!Freeze.defence)Freeze.isHit = true;
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Bat.class) && !Bat.grace){
            getWorld().addObject(new dennis_ball_explode(), getX(), getY());
            if(!Bat.isDefencing)Bat.isHited = true;
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Louis.class) && !Louis.grace){
            getWorld().addObject(new dennis_ball_explode(), getX(), getY());
            if(!Louis.defence)Louis.isHit = true;
            getWorld().removeObject(this);
            return;
        }
        super.act();
        animate();
        move(6);
    }    

    public void animate(){
        if(timer.millisElapsed() > 0){
            setImage("ball1.png");
        }
        if(timer.millisElapsed() > 25){
            setImage("ball2.png");
        }
        if(timer.millisElapsed() > 50){
            setImage("ball3.png");
        }
        if(timer.millisElapsed() > 75){
            setImage("ball4.png");
        }
        if(timer.millisElapsed() > 100){
            setImage("ball3.png");
        }
        if(timer.millisElapsed() > 125){
            setImage("ball2.png");
        }
        if(timer.millisElapsed() > 150){
            setImage("ball1.png");
        }
        if(timer.millisElapsed() > 175){
            timer.mark();
        }
    }
}
