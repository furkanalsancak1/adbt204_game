package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Objects.Ball;
import game.Objects.Enemy;
import game.general.Game;
import game.general.GameLevel;

//Whenever ball touches an enemy object, the ball disappears.
//this is created to make it look like enemy is blocking the basketball.
//and an audience sound will be played
public class Ball_To_Enemy implements CollisionListener {

    private GameLevel level;
    private Enemy enemy;
    private Game game;

    private static SoundClip blockSound;

    //added sound so whenever collision happens, audience will make noise
    static{
        try{
            blockSound = new SoundClip("data/blockSound.wav");
            System.out.println("Loading block sound");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Ball_To_Enemy(Enemy e, GameLevel l, Game g){
        level=l;
        enemy=e;
        game=g;
    }

    //collision that makes the ball disappear when touching enemy object
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ball) {
            e.getOtherBody().destroy();
            blockSound.play();
        }
    }

}
