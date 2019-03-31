/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.players.Green;
import cluedo.logic.players.Mustard;
import cluedo.logic.players.Peacock;
import cluedo.logic.players.Plum;
import cluedo.logic.players.Scarlet;
import cluedo.logic.players.White;
import java.util.ArrayList;

/**
 *
 * @author Bence
 */
public class PlayerFactory {

    private ArrayList<String> playerList;
    private ArrayList<Player> players = new ArrayList<>();
    
    public PlayerFactory(String fileName){

    }

    private void createPlayers(ArrayList<String> playersList) {
        for(int i = 0; i<playerList.size();i++){
            String[] data = playerList.get(i).split(",");
            if(data[0].equals("G")){
                Green g = new Green(data[1],data[2]);
                players.add(g);
            }else if(data[0].equals("M")){
                Mustard m = new Mustard(data[1],data[2]);
                players.add(m);
            }else if(data[0].equals("Pe")){
                Peacock pe = new Peacock(data[1],data[2]);
                players.add(pe);
            }else if(data[0].equals("Pl")){
                Plum g = new Plum(data[1],data[2]);
                players.add(pl);
            }else if(data[0].equals("S")){
                Scarlet g = new Scarlet(data[1],data[2]);
                players.add(s);
            }else if(data[0].equals("W")){
                White g = new White(data[1],data[2]);
                players.add(w);
            }
           
        }
        
    }
    
    /*public ArrayList<Player> getPlayers(){
        ArrayList<Player> data = new ArrayList<>();
        for(int i = 0; i<players.size();i++){
            data.add(players.get(i));
        }
        return data;
    }*/
}
