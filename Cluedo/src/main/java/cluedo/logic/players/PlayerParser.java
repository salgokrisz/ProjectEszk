/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.players;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Bence
 */
public class PlayerParser {
    
    private static ArrayList<String> playersData;
    
    public PlayerParser(){
        playersData = new ArrayList<>();
    }
    
    public static void openFile(String fileName){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line; 
            while((line = br.readLine()) != null){ 
                playersData.add(line);
            } 
        }catch(IOException ex){
            System.out.println("Can't open file. File is not found or damaged: Filename: "+fileName);
        }
    }
    
    public static ArrayList<String> getPlayersData(){
        ArrayList<String> data = new ArrayList<>();
        for(int i = 0;i<playersData.size();i++){
            data.add(playersData.get(i));
        }
        return data;
    }
    
    
    
    
}
