package game.Objects;

import city.cs.engine.*;

public class Player extends Walker {

    private static final Shape playerShape = new PolygonShape(-1.84f,2.4f, -1.89f,0.75f, -1.64f,-6.85f, -1.54f,-9.8f, 2.26f,-9.8f, 2.31f,1.75f, 1.31f,4.1f, -1.79f,2.9f
    );

    private static final BodyImage image= new BodyImage("data/basketballer.png", 25f);




    public Player(World world){
        super(world, playerShape);
        addImage(image);
    }


}
