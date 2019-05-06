package cluedo.logic.parsers;


import static cluedo.tools.Tools.LOG;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MapParser{
    private static List<List<String>> mapList=new ArrayList<>();

    public void openFile(String fn){
        mapList.clear();
        try (BufferedReader br=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fn), StandardCharsets.UTF_8));){
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
    private boolean correctPlayerRoleInString(String roleInString){
        return roleInString.equals("Peacock")||roleInString.equals("Mustard")||
                roleInString.equals("Plum") || roleInString.equals("Green")||
                roleInString.equals("White") || roleInString.equals("Scarlet");
    }
    private boolean correctRoomName(String roomName){
        return roomName.equals("Cards.Rooms.Hall")||roomName.equals("Cards.Rooms.Eatery")||roomName.equals("Cards.Rooms.Kitchen")
               || roomName.equals("Cards.Rooms.Terrace")||roomName.equals("Cards.Rooms.Planetarium")||roomName.equals("Cards.Rooms.LivingRoom")
                || roomName.equals("Cards.Rooms.Cinema") || roomName.equals("Cards.Rooms.GuestHouse") || roomName.equals("Cards.Rooms.Bath");
    }
    private boolean checkFieldWithDoubleDots(String fieldSymbol){
        boolean correct=false;
               String[] parts=fieldSymbol.split(":");
            if(parts.length==3 || parts.length==2 || parts.length==4){
                       switch(parts.length){
                    case 4:
                        correct= parts[0].equals("E")&&correctRoomName(parts[1])&&parts[2].equals("1")&&correctRoomName(parts[3]);
                    break;
                    case 3:
                    correct= parts[0].equals("E")&&(correctRoomName(parts[1])||parts[1].equals("En"))&&parts[2].equals("0");
                    break;
                    case 2:
                    if(parts[0].equals("St")){
                        correct= correctPlayerRoleInString(parts[1]);
                    }else if(parts[0].equals("R")){
                        correct= correctRoomName(parts[1]);
                    }
                    break;
                    default:
                        break;
            }  
            }
                
               
        return correct;
    }
    public boolean isCorrectCharacter(String fieldSymbol){
        boolean correct;
        if(fieldSymbol.contains(":")){
            correct=checkFieldWithDoubleDots(fieldSymbol);
        }else{
            correct=fieldSymbol.equals("F") || fieldSymbol.equals("En")||fieldSymbol.equals("I");
        }
        return correct;
    }

    public static List<List<String>> getMapList(){
        return mapList;
    }
}
