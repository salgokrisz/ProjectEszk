/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.player.Ai;
import cluedo.logic.player.level.ExperienceLevel;
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
    private static final String PLAYER_STRING="PLAYER";
   private Role getAppropriateRole(String roleInString, String playerName){
       Role role=null;
       switch(roleInString){
           case "Plum":
               role=new Plum(playerName);
               break;
           case "Scarlet":
               role=new Scarlet(playerName);
               break;
           case "Green":
               role=new Green(playerName);
               break;
           case "White":
               role=new White(playerName);
               break;
           case "Mustard":
               role=new Mustard(playerName);
               break;
           case "Peacock":
               role=new Peacock(playerName);
               break;
           default:
               break;
       }
       return role;
   }

    public List<Player> createPlayers(List<String> playersList) {
        List<Player> players=new ArrayList<>();
        for(int i = 0; i<playersList.size();i++){
            String[] data = playersList.get(i).split(":");
            Role role=getAppropriateRole(data[2].trim(), data[1].trim());
            Player player;
            if(data[0].trim().equals("AI") || data[0].trim().equals("Számítógép")){
                ExperienceLevel experienceLevel;
                if(data[3].trim().equals("Kezdő") || data[3].trim().equals("Beginner")){
                    experienceLevel=ExperienceLevel.BEGINNER;
                }else{
                    experienceLevel=ExperienceLevel.INTERMEDIATE;
                }
                player=new Ai( role,true, experienceLevel);
            }else{
                player=new Player(role, false);
            }  
        players.add(player);
    }
        return players;
    }

}
