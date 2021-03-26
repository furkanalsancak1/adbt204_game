package game.controls;

import city.cs.engine.SoundClip;
import game.Objects.Ball;
import game.Objects.Player;
import game.general.Game;
import game.general.GameLevel;
import game.general.GameSaverLoader;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class PlayerController implements KeyListener {

    private static float WALKING_SPEED = 8;
    private static float JUMPING_SPEED = 20;
    private Player player;
    private Ball ball;
    private GameLevel level;
    private Game game;

    private static SoundClip sneakerSqueakingSound;

    //added sound so that player's sneakers make squeak noise
    static{
        try{
            sneakerSqueakingSound = new SoundClip("data/sneakerSqueaking.wav");
            System.out.println("Loading sneaker sound");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public PlayerController(Player p, GameLevel l, Game g){
        player=p;
        level = l;
        game = g;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //walk the player left or right
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            player.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            player.startWalking(WALKING_SPEED);
        }else if (code == KeyEvent.VK_F){
            ball = new Ball(level);
            //setting position of the ball to player's position
            ball.setPosition(level.getPlayer().getPosition().add(new Vec2(-0.5f,2.5f)));
            ball.setGravityScale(1.5f);
            //setting linear velocity to throw the ball.
            ball.setAngularVelocity(10);
            ball.setLinearVelocity(new Vec2(-10,20));
        }else if (code == KeyEvent.VK_SPACE){
            player.jump(JUMPING_SPEED);
            player.setGravityScale(3);
            //player.setLinearVelocity(new Vec2(0,10));

        }

    }

    //stops player walking after certain key is released(in this case, A or D
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            player.stopWalking();
            //setLinearVelocity to get rid of character sliding after releasing key A
            player.setLinearVelocity(new Vec2(0,0));
            sneakerSqueakingSound.play();
        } else if (code == KeyEvent.VK_D) {
            player.stopWalking();
            //setLinearVelocity to get rid of character sliding after releasing key D
            player.setLinearVelocity(new Vec2(0,0));
            sneakerSqueakingSound.play();
        }
        else if (code == KeyEvent.VK_S){
            try {
                GameSaverLoader.save(level, "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_L){
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }



    }

    public void updatePlayer(Player player, GameLevel l){
        this.player=player;
        this.level = l;
    }

}
