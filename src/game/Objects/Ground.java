package game.Objects;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

//created here Ground class to be able to add collision afterwards
//which is when the ball touches ground, ball will disappear
public class Ground extends StaticBody {

    private static final Shape shape = new BoxShape(50, 0.1f);

    public Ground(World world){
        super(world, shape);
    }
}
