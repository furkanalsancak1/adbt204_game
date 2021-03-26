package game.general;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.GUI.ControlPanel;
import game.Levels.*;
import game.Objects.Basket;
import game.controls.GiveFocus;
import game.controls.PlayerController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {

    public GameLevel level;

    private MyView view;

    private PlayerController controller;


    private World world;

    private int ballCount;



    public Game(){

        world = new World();

        level = new Level1(this);
        level.populate(this);

        view = new MyView(level,  800,488, this);
        view.setZoom(10);
        //added this line to update background in each level
        view.setBack(level.paintBackground());


        //to control the player and access PlayerController class
        controller = new PlayerController(level.getPlayer(), level, this);
        view.addKeyListener(controller);

        //mouseListener for GiveFocus class to be able to perform cursor being in the view
        //so that movements can be made
        view.addMouseListener(new GiveFocus(view));

        final JFrame frame = new JFrame("Basic world");
        frame.add(view);

        //added GUI on right side of game view
        //and added it to the frame
        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.EAST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

       //JFrame debugView = new DebugViewer(world, 800, 488);

        level.start();

    }

    public void setLevel(GameLevel level){
        this.level.stop();
        this.level= level;
        view.setWorld(this.level);
        view.setZoom(10);
        //added this line to update background in each level
        view.setBack(this.level.paintBackground());
        controller.updatePlayer(this.level.getPlayer(), this.level);
        this.level.start();
    }

    public void goToNextLevel(){

        //to go to next level

        if (level instanceof Level1){
            level.stop();
            level= new Level2(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(10);
            //added this line to update background in each level
            view.setBack(level.paintBackground());
            controller.updatePlayer(level.getPlayer(), level);
            level.start();
        }else if(level instanceof Level2){
            level.stop();
            level= new Level3(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(10);
            //added this line to update background in each level
            view.setBack(level.paintBackground());
            controller.updatePlayer(level.getPlayer(), level);
            level.start();
        }else if (level instanceof Level3){
            level.stop();
            level= new Level4(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(10);
            //added this line to update background in each level
            view.setBack(level.paintBackground());
            controller.updatePlayer(level.getPlayer(), level);
            level.start();
        }else if (level instanceof Level4){
            System.out.println("Well done!! Game is complete!!");
            System.exit(0);
        }

    }

    //addBalls method will count how many times the ball touched the basket
    //and eventually will give the output on the console showing how many times player scored
    public void addBalls(){
        ballCount++;
//        System.out.println("Score: " + ballCount);
    }

    public int getBallCount(){
        return ballCount;
    }

    //function of pause button in GUI
    public void pause(){
        level.stop();
    }

    //function of restart button in GUI
    public void restart(){
        level.stop();
        level= new Level1(this);
        level.populate(this);
        view.setWorld(level);
        view.setZoom(10);
        view.setBack(level.paintBackground());
        controller.updatePlayer(level.getPlayer(), level);
        level.start();
    }

    public void save(){
        try {
            GameSaverLoader.save(level, "data/save.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void load(){
        try {
            GameLevel level = GameSaverLoader.load(this, "data/save.txt");
            this.setLevel(level);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

//    function of resume button in GUI
    public void resume(){
        level.start();
        ballCount=0;
    }





    public static void main(String[] args) {
        new Game();
    }

}
