package view;

import javax.swing.JFrame;

public class View extends JFrame{

    public static final int FRAME_HEIGHT = 600;
    public static final int FRAME_WIDTH = 400;

    public View(){
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Caver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void showMainMenu(){

    }
    
}
