package game.general;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Objects.Basket;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

public class MyView extends UserView {

    private Image back;
    private Game game;

    public MyView(GameLevel l, int width, int height, Game g){
        super(l,width,height);
        game=g;
        //background = new ImageIcon("data/audience.jpg").getImage();
    }

    public void setBack(Image background){
        this.back= background;
    }

    //adding a background image
    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(back, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g){
        //shows the current date and time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //sets the color of text
        g.setColor(Color.RED);

        //shows the score
        g.drawString("Score : " +  game.getBallCount(),32,42);
        //shows the date and time
        g.drawString("Time: " + dtf.format(now), 32, 55);
    }


}


