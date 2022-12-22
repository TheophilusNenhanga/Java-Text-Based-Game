package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

    static final int FONT_SIZE = 72;
    static final int BUTTON_WIDTH = 140;
    static final int BUTTON_HEIGHT = 30;

    static final int BUTTON_SPACER_SIZE = 20;

    public MainMenuPanel(int width, int height){
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(Box.createRigidArea(new Dimension(0, height / 10)));

        JLabel label = new JLabel("CAVER");
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        add(label);

        add(Box.createRigidArea(new Dimension(0, height / 10)));
        // This line adds space between the label and the following buttons

        JButton newGameButton = new JButton("New Game");
        newGameButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        newGameButton.setForeground(Color.BLACK);
        newGameButton.setBackground(Color.WHITE);
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(newGameButton);

        add(Box.createRigidArea(new Dimension(0, BUTTON_SPACER_SIZE)));

        JButton readStoryButton = new JButton("Read Story");
        readStoryButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        readStoryButton.setForeground(Color.BLACK);
        readStoryButton.setBackground(Color.WHITE);
        readStoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        readStoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(readStoryButton);

        add(Box.createRigidArea(new Dimension(0, BUTTON_SPACER_SIZE)));

        JButton creditsButton = new JButton("Credits");
        creditsButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        creditsButton.setForeground(Color.BLACK);
        creditsButton.setBackground(Color.WHITE);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(creditsButton);

        add(Box.createRigidArea(new Dimension(0, BUTTON_SPACER_SIZE)));

        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        leaderboardButton.setForeground(Color.BLACK);
        leaderboardButton.setBackground(Color.WHITE);
        leaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(leaderboardButton);

        add(Box.createRigidArea(new Dimension(0, BUTTON_SPACER_SIZE)));

        JButton quitButton = new JButton("Quit");
        quitButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        quitButton.setForeground(Color.BLACK);
        quitButton.setBackground(Color.WHITE);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(quitButton);

    }

}
