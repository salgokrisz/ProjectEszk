/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.player.Ai;
import cluedo.logic.player.Player;
import cluedo.logic.role.Green;
import cluedo.logic.role.Mustard;
import cluedo.logic.role.Peacock;
import cluedo.logic.role.Plum;
import cluedo.logic.role.Role;
import cluedo.logic.role.Scarlet;
import cluedo.logic.role.White;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Bence
 */
public class PlayerFactoryTest {
    
    @Test
    public void testcreatePlayersWithWhitePlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("W,PLAYER");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new White("White");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
    @Test
    public void testcreatePlayersWithGreenPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("G,PLAYER");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Green("Green");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithPlumPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("Pl,PLAYER");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Plum("Plum");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithPeacockPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("Pe,PLAYER");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Peacock("Peacock");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithMustardPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("M,PLAYER");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Mustard("Mustard");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithScarletPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("S,PLAYER");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Scarlet("Scarlet");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithWhiteAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("W,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        System.out.println(player.size());
        String result = player.get(0).getRole().toString();
        Role role = new White("White");
        Player p = new Ai(role,true);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithGreenAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("G,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Green("Green");
        Player p = new Ai(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithMustardAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("M,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Mustard("Mustard");
        Player p = new Ai(role,true);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithPeacockAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("Pe,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Peacock("Peacock");
        Player p = new Ai(role,true);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
      @Test
    public void testcreatePlayersWithPlumAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("Pl,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Plum("Plum");
        Player p = new Ai(role,true);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithScarletAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("S,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = player.get(0).getRole().toString();
        Role role = new Scarlet("Scarlet");
        Player p = new Ai(role,true);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testCreatePlayersWithMultiplePlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("S,PLAYER");
        players.add("M,PLAYER");
        players.add("W,PLAYER");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = "";
        for(int i = 0; i<player.size();i++){
           result = result +" "+ player.get(i).getRole().toString();
        }
        
        Role roleS = new Scarlet("Scarlet");
        Role roleM = new Mustard("Mustard");
        Role roleW = new White("White");
        Player pS = new Player(roleS,false);
        Player pM = new Player(roleM,false);
        Player pW = new Player(roleW,false);
        
        String expectedResult = " "+pS.getRole().toString()+" "+pM.getRole().toString()+" "+pW.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
    @Test
    public void testCreatePlayersWithMultipleAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("S,AI");
        players.add("M,AI");
        players.add("W,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = "";
        for(int i = 0; i<player.size();i++){
           result = result +" "+ player.get(i).getRole().toString();
        }
        
        Role roleS = new Scarlet("Scarlet");
        Role roleM = new Mustard("Mustard");
        Role roleW = new White("White");
        Player pS = new Ai(roleS,true);
        Player pM = new Ai(roleM,true);
        Player pW = new Ai(roleW,true);
        
        String expectedResult = " "+pS.getRole().toString()+" "+pM.getRole().toString()+" "+pW.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testCreatePlayersWithMultipleMixed(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        players.add("S,AI");
        players.add("M,PLAYER");
        players.add("W,AI");
        pf.createPlayers(players);
        List<Player> player = pf.getPlayers();
        String result = "";
        for(int i = 0; i<player.size();i++){
           result = result +" "+ player.get(i).getRole().toString();
        }
        
        Role roleS = new Scarlet("Scarlet");
        Role roleM = new Mustard("Mustard");
        Role roleW = new White("White");
        Player pS = new Ai(roleS,true);
        Player pM = new Player(roleM,false);
        Player pW = new Ai(roleW,true);
        
        String expectedResult = " "+pS.getRole().toString()+" "+pM.getRole().toString()+" "+pW.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
}
