package game.GUI;

import game.general.Game;
import game.general.GameLevel;
import game.general.GameSaverLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {

    private GameLevel level;
    private Game game;
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton restartButton;
    private JButton exitButton;
    private JButton skipLevelButton;
    private JButton resumeButton;
    private JButton saveButton;
    private JButton loadButton;

    public ControlPanel(Game game){
        this.game = game;

        //sets background color for main panel and buttons in GUI
        mainPanel.setBackground(Color.BLACK);
        pauseButton.setBackground(Color.RED);
        restartButton.setBackground(Color.RED);
        exitButton.setBackground(Color.RED);
        skipLevelButton.setBackground(Color.RED);
        resumeButton.setBackground(Color.RED);
        saveButton.setBackground(Color.RED);
        loadButton.setBackground(Color.RED);

        //action for pause button
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
            }
        });

        //action for restart button
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }
        });

        //action for exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //action for skipLevel button
        skipLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToNextLevel();
            }
        });

        //action for resume button
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resume();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.save();
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.load();
            }
        });

    }

    public JPanel getMainPanel(){

        return mainPanel;
    }


}
