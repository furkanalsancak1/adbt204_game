package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.Levels.Level4;
import game.Objects.Ball;
import game.Objects.Basket;
import game.general.Game;
import game.general.GameLevel;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;

import java.util.logging.Level;


/*
This class makes the ball disappear after touching the basket, which counts each collision as score
Run Game class, click key F, the ball will be thrown, and you can see
the ball will disappear after touching basket
 */
public class Ball_In_Basket implements CollisionListener {

    private GameLevel level;
    private Basket basket;
    private Game game;

    private static SoundClip cheerSound;

    static{
        try{
            //the crowd will cheer when scored
            cheerSound = new SoundClip("data/cheer.wav");
            System.out.println("Loading cheer sound");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Ball_In_Basket(Basket b, GameLevel l, Game g){
        this.level = l;
        this.basket = b;
        this.game=g;
    }

    //collision class to destroy ball whenever ball touches basket
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ball){
            //adding balls to score counter
            game.addBalls();
            basket.addBalls();
            //destroying ball
            e.getOtherBody().destroy();
            //playing sound
            cheerSound.play();
        }

        //Creating a ball object setting it at a position under basket to
        //make it look like the ball is going through the basket
        Ball ball = new Ball(level);
        ball.setPosition(new Vec2(-7.6f, -3f));
        ball.setAngularVelocity(5);

        //code that enables to go next level.
        //Going next level depends on the score you have.
        if (e.getOtherBody() instanceof Ball && level.isComplete()){
            game.goToNextLevel();
        }

    }


}

