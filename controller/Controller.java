package controller;

import view.View;

public class Controller{

    View view;
    public Controller(){

    }

    /**
     * This method runs the game.
     */
    public void start(){
        view = new View();
    }
}