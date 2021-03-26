package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Objects.Enemy;
import game.Objects.Ground;
import game.general.GameLevel;
import org.jbox2d.common.Vec2;

//this class is created to make enemy object jump whenever it touches the ground
public class Enemy_To_Ground implements CollisionListener {

    private GameLevel level;
    private Ground ground;

    public Enemy_To_Ground(Ground g, GameLevel l){
        this.ground = g;
        this.level=l;
    }

    //collision between ground and enemy body and making body jump
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy){
            ((Enemy) e.getOtherBody()).setLinearVelocity(new Vec2(0,20));
        }
    }
}
