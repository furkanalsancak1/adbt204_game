package game.Levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Objects.Enemy;
import game.collisions.Ball_To_Enemy;
import game.general.Game;
import game.general.GameLevel;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level3 extends GameLevel {

    public Level3(Game game){

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
        basket.setPosition(new Vec2(-10, 3f));


//        //enemy
//        Enemy enemy = new Enemy(this);
//        Ball_To_Enemy block = new Ball_To_Enemy(enemy, this, game);
//
//        enemy.addCollisionListener(block);
//        enemy.setPosition(new Vec2(10,-18));
//        enemy.setGravityScale(1);
//
//        //enemy
//        Enemy enemy2 = new Enemy(this);
//        enemy2.addCollisionListener(block);
//        enemy2.setPosition(new Vec2(3,-18));
//        enemy2.setGravityScale(1.5f);
//
//
//        getPlayer().setPosition(new Vec2(20,-18));
//
//
//
//        getBasket().setPosition(new Vec2(-15, -5f));


    }

    @Override
    public void populate(Game game){

        super.populate(game);

        getGround().setPosition(new Vec2(0, -24f));

        //enemy
        Enemy enemy = new Enemy(this);
        Ball_To_Enemy block = new Ball_To_Enemy(enemy, this, game);

        enemy.addCollisionListener(block);
        enemy.setPosition(new Vec2(10,-18));
        enemy.setGravityScale(1);

        //enemy
        Enemy enemy2 = new Enemy(this);
        enemy2.addCollisionListener(block);
        enemy2.setPosition(new Vec2(3,-18));
        enemy2.setGravityScale(1.5f);


        getPlayer().setPosition(new Vec2(20,-18));



        getBasket().setPosition(new Vec2(-15, -5f));

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
        Image background = new ImageIcon("data/level3background.jpg").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }

}
