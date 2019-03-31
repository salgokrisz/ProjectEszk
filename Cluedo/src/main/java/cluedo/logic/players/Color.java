/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.players;

/**
 *
 * @author Barby
 */
public enum Color {
    RED, ORANGE, WHITE, GREEN, PURPLE, BLUE;
    @Override
    public String toString(){
        switch(this){
            case RED:
                return "Piros";
            case ORANGE:
                return "Narancssárga";
            case WHITE:
                return "Fehér";
            case GREEN:
                return "Zöld";
            case PURPLE:
                return "Lila";
            case BLUE:
                return "Kék";
            default:
                return "";
        }
    }
}
