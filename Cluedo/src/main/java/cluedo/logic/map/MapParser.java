package cluedo.logic.map;

import java.io.*;
import java.util.*;
import static cluedo.tools.Tools.LOG;

public class MapParser{
    private static List<List<String>> mapList=new ArrayList<>();

    public void openFile(String fn){
        mapList.clear();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fn).getFile());
        try (FileReader fr=new FileReader(file); BufferedReader br = new BufferedReader(fr);){
                String line;
                boolean wasErrorInFile=false;
                while ((line = br.readLine()) != null && !wasErrorInFile) {
                    ArrayList<String> tmpList = new ArrayList<>();
                    String[]  tmpArr = line.split(",");
                    int i=0;
                    while (i < tmpArr.length && !wasErrorInFile){
                        if(isCorrectCharacter(tmpArr[i])){
                        tmpList.add(tmpArr[i]);
                        }else{
                            wasErrorInFile=true;
                        }
                        i+=1;
                    }
                    mapList.add(tmpList);
                }
                if(wasErrorInFile){
                    mapList.clear();
                }
        }catch(FileNotFoundException e){
            LOG.warning("File not found");
        }catch (IOException e){
            LOG.warning("IO Error");
        }catch(Exception e){
            LOG.warning(e.getMessage());
        }
    }

    public boolean isCorrectCharacter(String character){
       return  character.equals("F") || character.equals("R") || character.equals("E");

    }

    public static List<List<String>> getMapList(){
        return mapList;
    }
}
