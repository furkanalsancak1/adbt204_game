package game.general;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import game.Levels.Level1;
import game.Levels.Level2;
import game.Levels.Level3;
import game.Levels.Level4;
import game.Objects.*;
import game.collisions.Ball_In_Basket;
import game.collisions.Ball_to_ground;
import game.collisions.Enemy_To_Ground;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    public static void save(GameLevel level, String fileName) throws IOException {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            //writer.write(level.getLevelName() + "," + level.getBasket().getBallCount() + "\n");
            writer.write(level.getLevelName() + "\n");

            for (StaticBody body : level.getStaticBodies()){
                if (body instanceof Basket){
                    writer.write("Basket," + body.getPosition().x + "," +
                            body.getPosition().y + "," +
                            ((Basket) body).getBallCount() + "\n");
                }
                if (body instanceof Ground){
                    writer.write("Ground," + body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }
            }
            for (DynamicBody body : level.getDynamicBodies()){
                if (body instanceof Player){
                    writer.write("Player," +body.getPosition().x + "," +
                                    body.getPosition().y + "\n");
                }
                else if (body instanceof Ball){
                    writer.write("Ball," +body.getPosition().x + "," +
                                    body.getPosition().y + "\n");
                }
                else if (body instanceof Enemy){
                    writer.write("Enemy," +body.getPosition().x + "," +
                                    body.getPosition().y + "\n");
                }
            }



        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static GameLevel load(Game game, String fileName) throws IOException{
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            GameLevel level = null;
            if (line.equals("Level1")){
                level = new Level1(game);
            }
            else if (line.equals("Level2")){
                level = new Level2(game);
            }
            else if (line.equals("Level3")){
                level = new Level3(game);
            }
            else if (line.equals("Level4")){
                level = new Level4(game);
            }

            line = reader.readLine();
            while (line != null){

                String[] tokens = line.split(",");


                if (tokens[0].equals("Basket")){
                    Basket b = new Basket(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x, y));
                    int bc = Integer.parseInt(tokens[3]);
                    b.setBallCount(bc);

                    level.setBasket(b);
                    Ball_In_Basket score = new Ball_In_Basket(b, level, game);
                    b.addCollisionListener(score);
                }
                else if (tokens[0].equals("Player")){
                    Player p = new Player(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    p.setPosition(new Vec2(x, y));

                    level.setPlayer(p);
                }
                else if (tokens[0].equals("Ball")){
                    Ball ball = new Ball(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    ball.setPosition(new Vec2(x, y));

                }
                else if (tokens[0].equals("Enemy")){
                    Enemy e = new Enemy(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    e.setPosition(new Vec2(x, y));


                }
                else if (tokens[0].equals("Ground")){
                    Ground g = new Ground(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    g.setPosition(new Vec2(x, y));

                    level.setGround(g);
                    Ball_to_ground ballGone = new Ball_to_ground(g, level);
                    g.addCollisionListener(ballGone);
                    Enemy_To_Ground jump = new Enemy_To_Ground(g, level);
                    g.addCollisionListener(jump);
                }

                line = reader.readLine();
            }


            return level;


        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

}
