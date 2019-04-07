package cluedo.logic.intrics;

import java.util.*;
import java.io.*;

public class IntricsParser{

    private String text;
    private String type;

    public IntricsParser(String text, String type){
        this.text = text;
        this.type = type;
    }

    public IntricsParser parseFile(String fileName){
        IntricsParser ip;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            String[] tmpList = line.split(";");
            return ip = new IntricsParser(tmpList[0], tmpList[1]);
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Error");
        }
        return null;
    }

    public void setText(String tex){
        text = tex;
    }

    public void setType(String t){
        type = t;
    }

    public String getText(){
        return text;
    }

    public String getType(){
        return type;
    }

}
