package cluedo.logic.map;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import game.exceptions.WrongFiledTypeException;

public class MapParser{

    private static char[][] mapCharArray;
    private static ArrayList<ArrayList<String>> mapList;
    private static File fileName;

    public MapParser(){
        //mapCharArray = ca;
    }

    public void openFile(String fn){
        System.out.println("mp 1");
        try {
              ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(fn).getFile());          
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<String> tmpList = new ArrayList<>();
                String[]  tmpArr = line.split(",");
                for (int i = 0; i < tmpArr.length; ++i){
                    tmpList.add(tmpArr[i]);
                }
                mapList.add(tmpList);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Error");
        }
    }

    public boolean isCorrectCharacters(ArrayList<ArrayList<String>> list) throws WrongFiledTypeException{
        boolean retVal = false;
        for (int i = 0; i < list.size(); ++i){
            for (int j = 0; j < list.get(i).size(); ++j){
                if (list.get(i).get(j).equals("F") || list.get(i).get(j).equals("R") || list.get(i).get(j).equals("E")){		// TODO add more field types;
                    retVal = true;
                }
                else{
                    throw new WrongFiledTypeException("Wrong field type found!");
                }
            }
        }
        return retVal;
    }

    public static ArrayList<ArrayList<String>> getMapList(){
        return mapList;
    }

 /*   public static void main(String[] args) {
        ArrayList<ArrayList<String>> ml = new ArrayList<ArrayList<String>>();
        MapParser mp = new MapParser(ml, args[0]);
        //mp.openFile(fileName);
        /*for (int i = 0; i < ml.size(); ++i){
            System.out.println(ml.get(i));
        }*/
    /*    for (int i = 0; i < ml.size(); ++i){
            for (int j = 0; j < ml.get(i).size(); ++j){
                System.out.print(ml.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }*/
}
