package cluedo.logic.intrics;

import static cluedo.tools.Tools.LOG;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IntricsParser{

    private String text;
    private String type;

    public IntricsParser(String text, String type){
        this.text = text;
        this.type = type;
    }

    public IntricsParser parseFile(String fileName){
        try (FileReader fr=new FileReader(fileName);BufferedReader br = new BufferedReader(fr);){           
            String line = br.readLine();
            String[] tmpList = line.split(";");
            return new IntricsParser(tmpList[0], tmpList[1]);
        }catch(FileNotFoundException e){
            LOG.warning("File not found");
        }catch (IOException e){
            LOG.warning("IO Error");
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
