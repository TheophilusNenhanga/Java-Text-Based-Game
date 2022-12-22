package view;

import javax.swing.*;

public class View extends JFrame{

    public static final int FRAME_HEIGHT = 720;
    public static final int FRAME_WIDTH = 480;

    public View(){
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Caver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // this.setVisible(true) omitted in constructor, will need to be added in every other method.
    }

    public void showMainMenu(){
        JPanel panel = new MainMenuPanel(FRAME_WIDTH, FRAME_HEIGHT);
        add(panel);
        this.setVisible(true);
    }
    
}
