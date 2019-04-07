package cluedo.logic.map;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import cluedo.exceptions.WrongFiledTypeException;

public class MapParser{

    private static char[][] mapCharArray;
    private static ArrayList<ArrayList<String>> mapList;
    private static File fileName;

    public MapParser(){
        mapList=new ArrayList<>();
        //mapCharArray = ca;
    }

    public void openFile(String fn){
        try {
                ClassLoader classLoader = getClass().getClassLoader();
	        File file = new File(classLoader.getResource(fn).getFile());          
                BufferedReader br = new BufferedReader(new FileReader(file));

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
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Error");
        }
    }

    public boolean isCorrectCharacter(String character){// throws WrongFiledTypeException{
       return  character.equals("F") || character.equals("R") || character.equals("E");

    }

    public static ArrayList<ArrayList<String>> getMapList(){
        return mapList;
    }
}
