/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.player.Ai;
import cluedo.logic.role.Green;
import cluedo.logic.role.Mustard;
import cluedo.logic.role.Peacock;
import cluedo.logic.role.Plum;
import cluedo.logic.role.Scarlet;
import cluedo.logic.role.White;
import cluedo.logic.player.Player;
import cluedo.logic.role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will get a List of Strings and it will
 * create a List of Players from it.
 *
 */
public class PlayerFactory {

    private ArrayList<Player> players = new ArrayList<>();
    private static final String PLAYER_STRING="PLAYER";
   

    public void createPlayers(List<String> playersList) {
        for(int i = 0; i<playersList.size();i++){
            String[] data = playersList.get(i).split(",");
            if(data[0].equals("G")){
                addGreenPlayer(data);
            }else if(data[0].equals("M")){
               addMustardPlayer(data);
            }else if(data[0].equals("Pe")){
                addPeacockPlayer(data);
            }else if(data[0].equals("Pl")){
                addPlumPlayer(data);
            }else if(data[0].equals("S")){
                addScarletPlayer(data);
            }else if(data[0].equals("W")){
                addWhitePlayer(data);
            }
           
        }
        
    }
    
    private void addGreenPlayer(String[] data){
        Role role = new Green("Green");
                if(data[1].equals("AI")){                    
                    Player ai = new Ai(role,true);
                    players.add(ai);
                }else if(data[1].equals(PLAYER_STRING)){
                    Player player = new Player(role,false);
                    players.add(player);
                }  
    }
    
    private void addMustardPlayer(String[] data){
         Role role = new Mustard("Mustard");
                if(data[1].equals("AI")){                    
                    Player ai = new Ai(role,true);
                    players.add(ai);
                }else if(data[1].equals(PLAYER_STRING)){
                    Player player = new Player(role,false);
                    players.add(player);
                }
    }
    
    private void addPeacockPlayer(String[] data){
        Role role = new Peacock("Peacock");
                if(data[1].equals("AI")){                    
                    Player ai = new Ai(role,true);
                    players.add(ai);
                }else if(data[1].equals(PLAYER_STRING)){
                    Player player = new Player(role,false);
                    players.add(player);
                }
    }
    
    private void addPlumPlayer(String[] data){
         Role role = new Plum("Plum");
                if(data[1].equals("AI")){                    
                    Player ai = new Ai(role,true);
                    players.add(ai);
                }else if(data[1].equals(PLAYER_STRING)){
                    Player player = new Player(role,false);
                    players.add(player);
                }
    }
    
    private void addScarletPlayer(String[] data){
        Role role = new Scarlet("Scarlet");
                if(data[1].equals("AI")){                    
                    Player ai = new Ai(role,true);
                    players.add(ai);
                }else if(data[1].equals(PLAYER_STRING)){
                    Player player = new Player(role,false);
                    players.add(player);
                }
    }
    
    private void addWhitePlayer(String[] data){
        Role role = new White("White"); 
                 if(data[1].equals("AI")){
                    Player ai = new Ai(role,true);
                    players.add(ai);
                }else if(data[1].equals(PLAYER_STRING)){
                    Player player = new Player(role,false);
                    players.add(player);
                }
    }
    
    public ArrayList<Player> getPlayers(){
        ArrayList<Player> data = new ArrayList<>();
        for(int i = 0; i<players.size();i++){
            data.add(players.get(i));
        }
        return data;
    }
}
