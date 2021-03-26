package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.World;
import game.Objects.Ball;
import game.Objects.Ground;
import game.general.GameLevel;

/*
This class makes the ball disappear after touching the ground, to clear the area from having multiple balls
 */
public class Ball_to_ground implements CollisionListener {

    private GameLevel level;
    private Ground ground;

    public Ball_to_ground(Ground g, GameLevel l){
        this.ground=g;
        this.level = l;
    }

    //collision class to destroy ball whenever ball touches ground
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ball){
            e.getOtherBody().destroy();
        }
    }


}
