package game.Objects;

import city.cs.engine.*;

public class Enemy extends DynamicBody {

    private static final Shape enemyShape = new PolygonShape(-3.4f,-6.76f, 1.36f,-6.76f, 1.16f,4.68f, -1.72f,9.16f, -2.36f,9.16f, -3.16f,6.24f, -3.4f,-6.28f
    );

    private static final BodyImage image= new BodyImage("data/enemy.png", 20f);



    public Enemy(World world){
        super(world, enemyShape);
        addImage(image);
    }

}
