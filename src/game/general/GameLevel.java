package game.general;

import city.cs.engine.World;
import game.Objects.*;
import game.collisions.Ball_In_Basket;
import game.collisions.Ball_To_Enemy;
import game.collisions.Ball_to_ground;
import game.collisions.Enemy_To_Ground;

import java.awt.*;

public abstract class GameLevel extends World {

    private Player player;
    private Ground ground;
    private Basket basket;

    public GameLevel(Game game){

//        player = new Player(this);
//        basket = new Basket(this);
//        ground = new Ground(this);
//
//
//        //created collision class objects in game level
//        //so every level can use it without having to create collision class objects over and over again
//
//        Ball_to_ground ballGone = new Ball_to_ground(getGround(), this);
//        getGround().addCollisionListener(ballGone);
//
//        Ball_In_Basket score = new Ball_In_Basket(getBasket(), this, game);
//        getBasket().addCollisionListener(score);
//
//        Enemy_To_Ground jump = new Enemy_To_Ground(getGround(), this);
//        getGround().addCollisionListener(jump);


    }

    public void populate(Game game){
        player = new Player(this);
        basket = new Basket(this);
        ground = new Ground(this);


        //created collision class objects in game level
        //so every level can use it without having to create collision class objects over and over again

        Ball_to_ground ballGone = new Ball_to_ground(getGround(), this);
        getGround().addCollisionListener(ballGone);

        Ball_In_Basket score = new Ball_In_Basket(getBasket(), this, game);
        getBasket().addCollisionListener(score);

        Enemy_To_Ground jump = new Enemy_To_Ground(getGround(), this);
        getGround().addCollisionListener(jump);
    }

    public Player getPlayer(){return player;}
    public Basket getBasket(){return basket;}
    public Ground getGround(){return ground;}

    public void setPlayer(Player p){
        player = p;
    }
    public void setBasket(Basket b){
        basket = b;
    }
    public void setGround(Ground g){
        ground = g;
    }


    public abstract boolean isComplete();
    public abstract Image paintBackground();
    public abstract String getLevelName();

}
