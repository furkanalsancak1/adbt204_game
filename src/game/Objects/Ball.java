package game.Objects;

import city.cs.engine.*;

//creating a Ball Object by giving it a class to make the project more dynamic
public class Ball extends DynamicBody {

    private static final float RADIUS = 1f;

    private static final Shape ballShape = new CircleShape(RADIUS);

    private static final BodyImage ballImage
            = new BodyImage("data/basketball.png", 2*RADIUS);



    public Ball(World world){
        super(world, ballShape);
        addImage(ballImage);
    }

}
