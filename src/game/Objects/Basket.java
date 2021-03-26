package game.Objects;

import city.cs.engine.*;

public class Basket extends StaticBody {


    private static final Shape basketShape = new PolygonShape(
            5.46f,4.15f, 8.86f,4.15f, 8.86f,3.65f, 5.46f,3.7f
    );

    private static final BodyImage image= new BodyImage("data/basket.png", 25f);

    private int ballCount;




    public Basket(World world){
        super(world, basketShape);
        addImage(image);

    }

    //addBalls method will count how many times the ball touched the basket
    //and eventually will give the output on the console showing how many times player scored
    public void addBalls(){
        ballCount++;
        System.out.println("Score: " + ballCount);
    }

    public int getBallCount(){
        return ballCount;
    }

    public void setBallCount(int bc){
        ballCount = bc;
    }


}
