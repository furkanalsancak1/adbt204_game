package game.controls;

import game.general.MyView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
With this class, the character Player moves only if the cursor is within the image size
 */
public class GiveFocus implements MouseListener {

    private MyView view;

    public GiveFocus(MyView v){
        this.view = v;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
