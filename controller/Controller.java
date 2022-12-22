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
        // Creating the view tio be used throughout the program.
        view = new View();
        // The main menu has the buttons that begin teh game.
        view.showMainMenu();
    }
}