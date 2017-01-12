import greenfoot.*;
import java.util.*;
/**
 * Write a description of class S1BG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{    
    SimpleTimer timer = new SimpleTimer();

    //Spawn
    public static int spawnID1 = 0;
    public static int spawnID2 = 0;

    //Resources
    p1HealthBar p1HealthBar = new p1HealthBar();
    p2HealthBar p2HealthBar = new p2HealthBar();
    p1ManaBar p1ManaBar = new p1ManaBar();
    p2ManaBar p2ManaBar = new p2ManaBar();

    //Characters
    Dennis dennis = new Dennis();
    Freeze freeze = new Freeze();
    Bat bat = new Bat();
    Deep deep = new Deep();
    Firen firen = new Firen();
    Louis louis = new Louis();

    //Summons
    DennisSummon dennisSummon = new DennisSummon();   
    FreezeSummon freezeSummon = new FreezeSummon();
    Whirlwind_m whirlwind = new Whirlwind_m();
    BatSummon batSummon = new BatSummon();
    LouisSummon louisSummon = new LouisSummon();
    DeepSummon deepSummon = new DeepSummon();
    FirenSummon firenSummon = new FirenSummon();

    //Winner Message
    Player1 player1 = new Player1();
    Player2 player2 = new Player2();
    Back back = new Back();
    Rematch rematch = new Rematch();

    public static GreenfootSound music = new GreenfootSound("FinalDestination.mp3");
    public static GreenfootSound winnerMusic = new GreenfootSound("Congratulations.mp3");
    public static GreenfootSound winner1 = new GreenfootSound("winner1.wav");   
    public static GreenfootSound winner2 = new GreenfootSound("winner2.wav");  
    boolean playOnce = true;

    public Background()
    {    
        super(800, 400, 1);
        addObject(new Volcano(), 250, 20);
        addObject(new Fire(), 570, 62);
        addObject(new LavaLake(), 365, 30);
        addObject(new LeftSteam(), 90, 28);
        addObject(new RightSteam(), 640, 55);
        addObject(p1HealthBar, 160, 15);
        addObject(p2HealthBar, 640, 15);
        addObject(p1ManaBar, 135, 26);
        addObject(p2ManaBar, 665, 26);
        addObject(new CountDown(), 400, 150);
        music.playLoop();
    }

    public void act(){
        displayWinner();
        summons();
    }

    public void summons(){
        if(timer.millisElapsed() > 500){
            summonP2();
        }
        if(timer.millisElapsed() > 1000){
            summonP1();
        }
        if(timer.millisElapsed() > 3000){
            removeSummonP1();
            removeSummonP2();
            spawn();
        }
    }

    public void spawn() {
        if (spawnID1 == 1) {
            addObject (dennis, 220, 250);
        }
        if (spawnID1 == 2) {
            addObject (firen, 220, 250);
        }
        if (spawnID1 == 3) {
            addObject (deep, 220, 250);
        }
        if (spawnID2 == 1) {
            addObject (bat, 605, 250);
        }
        if (spawnID2 == 2) {
            addObject (freeze, 605, 250);
        }
        if (spawnID2 == 3){
            addObject (louis, 605, 250);
        }
    }

    public void summonP1(){
        if(spawnID1 == 1){
            addObject(dennisSummon, 0, 250);
        }
        if(spawnID1 == 2){
            addObject(firenSummon, 220, 230);
        }
        if(spawnID1 == 3){
            addObject(deepSummon , 0, 250);
        }
    }

    public void summonP2(){
        if(spawnID2 == 1){
            addObject(batSummon, 605, 250);
        }
        if(spawnID2 == 2){
            addObject(whirlwind, 800, 250);
            addObject(freezeSummon, 800, 250);
        }
        if(spawnID2 == 3){
            addObject(louisSummon, 605, 250);
        }
    }

    public void removeSummonP1(){
        if(spawnID1 == 1){
            removeObject(dennisSummon);
        }
        if(spawnID1 == 2){
            removeObject(firenSummon);
        }
        if(spawnID1 == 3){
            removeObject(deepSummon);
        }
    }

    public void removeSummonP2(){
        if(spawnID2 == 1){
            removeObject(batSummon);
        }
        if(spawnID2 == 2){
            removeObject(whirlwind);
            removeObject(freezeSummon);
        }
        if(spawnID2 == 3){
            removeObject(louisSummon);
        }
    }

    public void displayWinner(){
        if(Bat.isDead || Freeze.isDead || Louis.isDead){
            music.stop();
            if(playOnce){
                winnerMusic.play();
                winner1.play();
                playOnce = false;
            }
            addObject(player1, getWidth()/2, 160);
            addObject(rematch, getWidth()/2, 250);
            addObject(back, getWidth()/2, 300);
        }
        if(Dennis.isDead || Firen.isDead || Deep.isDead){
            music.stop();
            if(playOnce){
                winnerMusic.play();
                winner2.play();
                playOnce = false;
            }
            addObject(player2, getWidth()/2, 160);
            addObject(rematch, getWidth()/2, 250);
            addObject(back, getWidth()/2, 300);
        }
    }

    public p1HealthBar getHealthBar1(){
        return p1HealthBar;
    }

    public p2HealthBar getHealthBar2(){
        return p2HealthBar;
    }

    public p1ManaBar getManaBar1(){
        return p1ManaBar;
    }

    public p2ManaBar getManaBar2(){
        return p2ManaBar;
    }
}
