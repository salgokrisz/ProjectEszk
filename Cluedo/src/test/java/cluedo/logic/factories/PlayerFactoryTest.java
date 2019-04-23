/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.player.Ai;
import cluedo.logic.player.level.ExperienceLevel;
import cluedo.logic.player.Player;
import cluedo.logic.role.Green;
import cluedo.logic.role.Mustard;
import cluedo.logic.role.Peacock;
import cluedo.logic.role.Plum;
import cluedo.logic.role.Role;
import cluedo.logic.role.Scarlet;
import cluedo.logic.role.White;
import cluedo.tools.languagestring.Language;
import cluedo.tools.languagestring.LanguageStrings;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Bence
 */
public class PlayerFactoryTest {
    public void changeLanguageIfNecessary(Language lang){
        if(LanguageStrings.getCurrentLanguage()!=lang){
            LanguageStrings.changeLanguage(lang);
        }
    }
    @Test
    public void testcreatePlayersWithWhitePlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.HUN);
        players.add("Ember:Wh:White");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new White("Wh");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
    @Test
    public void testcreatePlayersWithGreenPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        players.add("Human:G:Green");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Green("G");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithPlumPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        players.add("Human:Pl:Plum");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Plum("Pl");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithPeacockPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.HUN);
        players.add("Ember:Pe:Peacock");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Peacock("Pe");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithMustardPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        players.add("Human:M:Mustard");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Mustard("M");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithScarletPlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.HUN);
        players.add("Ember:S:Scarlet");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Scarlet("S");
        Player p = new Player(role,false);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithWhiteAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.HUN);
        players.add("Számítógép:W:White:Kezdő");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new White("W");
        Player p = new Ai(role,true, ExperienceLevel.BEGINNER);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithGreenAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        players.add("AI:G:Green:Beginner");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Green("G");
        Player p = new Ai(role,false, ExperienceLevel.BEGINNER);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithMustarddAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        players.add("AI:Mu:Mustard:Intermediate");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Mustard("Mu");
        Player p = new Ai(role,true, ExperienceLevel.INTERMEDIATE);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithPeacockAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.HUN);
        players.add("Számítógép:Pe:Peacock:Haladó");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Peacock("Pe");
        Player p = new Ai(role,true, ExperienceLevel.INTERMEDIATE);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
      @Test
    public void testcreatePlayersWithPlumAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.HUN);
        players.add("Számítógép:Pl:Plum:Haladó");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Plum("Pl");
        Player p = new Ai(role,true, ExperienceLevel.INTERMEDIATE);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testcreatePlayersWithScarletAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        players.add("AI:Sc:Scarlet:Beginner");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = player.get(0).getRole().toString();
        Role role = new Scarlet("Sc");
        Player p = new Ai(role,true, ExperienceLevel.BEGINNER);
        String expectedResult = p.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testCreatePlayersWithMultiplePlayer(){
        PlayerFactory pf = new PlayerFactory();
        List<String> players = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        players.add("Human:S:Scarlet");
        players.add("Human:M:Mustard");
        players.add("Human:W:White");
        List<Player> player =pf.createPlayers(players, new ArrayList<>());
        String result = "";
        for(int i = 0; i<player.size();i++){
           result = result +" "+ player.get(i).getRole().toString();
        }
        
        Role roleS = new Scarlet("S");
        Role roleM = new Mustard("M");
        Role roleW = new White("W");
        Player pS = new Player(roleS,false);
        Player pM = new Player(roleM,false);
        Player pW = new Player(roleW,false);
        
        String expectedResult = " "+pS.getRole().toString()+" "+pM.getRole().toString()+" "+pW.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
    @Test
    public void testCreatePlayersWithMultipleAi(){
        PlayerFactory pf = new PlayerFactory();
        List<String> playerInfos = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        playerInfos.add("AI:S:Scarlet:Beginner");
        playerInfos.add("AI:M:Mustard:Beginner");
        playerInfos.add("AI:W:White:Intermediate");
        List<Player> players =pf.createPlayers(playerInfos, new ArrayList<>());
        String result = "";
        for(int i = 0; i<players.size();i++){
           result = result +" "+ players.get(i).getRole().toString();
        }
        
        Role roleS = new Scarlet("S");
        Role roleM = new Mustard("M");
        Role roleW = new White("W");
        Player pS = new Ai(roleS,true, ExperienceLevel.BEGINNER);
        Player pM = new Ai(roleM,true, ExperienceLevel.BEGINNER);
        Player pW = new Ai(roleW,true, ExperienceLevel.INTERMEDIATE);
        
        String expectedResult = " "+pS.getRole().toString()+" "+pM.getRole().toString()+" "+pW.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
     @Test
    public void testCreatePlayersWithMultipleMixed(){
        PlayerFactory pf = new PlayerFactory();
        List<String> playerInfos = new ArrayList<>();
        changeLanguageIfNecessary(Language.ENG);
        playerInfos.add("AI:S:Scarlet:Beginner");
        playerInfos.add("Human:M:Mustard");
        playerInfos.add("AI:W:White:Intermediate");
        List<Player> players =pf.createPlayers(playerInfos, new ArrayList<>());
        String result = "";
        for(int i = 0; i<players.size();i++){
           result = result +" "+ players.get(i).getRole().toString();
        }
        
        Role roleS = new Scarlet("S");
        Role roleM = new Mustard("M");
        Role roleW = new White("W");
        Player pS = new Ai(roleS,true, ExperienceLevel.BEGINNER);
        Player pM = new Player(roleM,false);
        Player pW = new Ai(roleW,true, ExperienceLevel.INTERMEDIATE);
        
        String expectedResult = " "+pS.getRole().toString()+" "+pM.getRole().toString()+" "+pW.getRole().toString();
        Assert.assertEquals(result,expectedResult);
    }
    
}
