package game.Levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.general.Game;
import game.general.GameLevel;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level4 extends GameLevel {

    public Level4(Game game){

        super(game);

//        getGround().setPosition(new Vec2(0, -24f));


        //left wall
        Shape wall1Shape = new BoxShape(0.1f,30f);
        StaticBody wall1 = new StaticBody(this, wall1Shape);
        wall1.setPosition(new Vec2(-39.5f,0f));

        //right wall
        Shape wall2Shape = new BoxShape(0.1f,30f);
        StaticBody wall2 = new StaticBody(this, wall2Shape);
        wall2.setPosition(new Vec2(39.5f,0f));

        //platform for basket
        Shape basketShape = new BoxShape(0.1f, 4f);
        StaticBody basket = new StaticBody(this, basketShape);
        basket.setPosition(new Vec2(-20, 13f));

        Shape platform1Shape = new BoxShape(5, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(25,-20));

        Shape platform2Shape = new BoxShape(5, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(10,-15));

        Shape platform3Shape = new BoxShape(5, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(5,-8));


//        getPlayer().setPosition(new Vec2(35,-18));
//
//
//
//        getBasket().setPosition(new Vec2(-25, 5f));


    }

    @Override
    public void populate(Game game){
        super.populate(game);

        getGround().setPosition(new Vec2(0, -24f));
        getPlayer().setPosition(new Vec2(35,-18));



        getBasket().setPosition(new Vec2(-25, 5f));
    }

    //added this so the player has to score 5 times to move on to the next level
    @Override
    public boolean isComplete(){
        if (getBasket().getBallCount() == 5){
            return true;
        }else {
            return false;
        }
    }

    //method to update background
    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/level4background.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level4";
    }

}
