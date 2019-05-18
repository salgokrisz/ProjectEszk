package cluedo.logic.intrics;

import cluedo.logic.cards.Card;
import cluedo.logic.controller.GameController;
import cluedo.logic.controller.GamePhase;
import cluedo.logic.player.Ai;
import cluedo.logic.room.Point;
import cluedo.tools.languagestring.LanguageStrings;
import java.util.List;
import java.util.Objects;


public class Intrics{
    private final String text;
    private final IntricsType type;

    public Intrics(String text, IntricsType type){
        this.text = text;
        this.type = type;
    }
    public Intrics(Intrics other){
        this.text=other.getText();
        this.type=other.getType();
    }
    public String getText(){
        return this.text;
    }

    public IntricsType getType(){
        return this.type;
    }

    @Override
    public int hashCode(){
        return Objects.hash(text, type);
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(!o.getClass().equals(this.getClass())){
            return false;
        }
        Intrics other = (Intrics) o;
        return text.equals(other.getText()) && type==other.getType();
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(LanguageStrings.getString(text)).append(System.lineSeparator()).append(LanguageStrings.getString("Card.Usage")).append(System.lineSeparator())
                .append(LanguageStrings.getString(type.toString()));
        return sb.toString();
    }
    public String toStringForPanel(){
        StringBuilder sb=new StringBuilder();
        sb.append("<html>").append(LanguageStrings.getString(text)).append("<br>").append(LanguageStrings.getString("Card.Usage"))
        .append("<br>").append(LanguageStrings.getString(type.toString())).append("</html>");
        return sb.toString();
    }
    public Object cloneObject(){
        return new Intrics(this);
    }
    
    public void effect(GameController gameController){
        List<Point> availablePositions;
        switch(text){
            case "Cards.Intrics.Desc.noAnswer":
                if (!gameController.getPlayerWhoHasToProve().getIsComputer()) {
                    gameController.fireDisplayShowProofCardView(new Card(text,"....","Cards.Intrics.Desc.noAnswer",cluedo.logic.cards.Card.Type.UNKNOWN), gameController.getPlayerWhoHasToProve());
                }else{
                     gameController.showCardForAi(new Card(text,"....","Cards.Intrics.Desc.noAnswer",cluedo.logic.cards.Card.Type.UNKNOWN), gameController.getPlayerWhoHasToProve());
                }               
                break;
            case "Cards.Intrics.Desc.lookAtAlso":
                gameController.fireDisplayShowProofCardView(gameController.getShowedCard(), gameController.getPlayerWhoHasToProve());
                break;
            case "Cards.Intrics.Desc.giveSix":
                availablePositions = gameController.chooseAvailableFieldsInARadius(gameController.getActualPlayer().getDroppedNumber()+6);
                if (!gameController.getActualPlayer().getIsComputer()) {
                    gameController.fireDisplayMoveView(availablePositions);
                } else {
                    ((Ai) gameController.getActualPlayer()).setAvailablePositionsToMove(availablePositions);
                }
                break;
            case "Cards.Intrics.Desc.turnAgain":
                gameController.setActualGamePhase(GamePhase.ROLLORUSESECRETCORRIDOR);
                gameController.nextPlayerIsComing();
                break;
            case "Cards.Intrics.Desc.stepStartSomeone":
                break;
            case "Cards.Intrics.Desc.remainPlace":
                break;
            case "Cards.Intrics.Desc.stepAnyWhere":
                availablePositions = gameController.chooseAvailableFieldsInARadius(999);
                if (!gameController.getActualPlayer().getIsComputer()) {
                    gameController.fireDisplayMoveView(availablePositions);
                } else {
                    ((Ai) gameController.getPlayers().get(gameController.getActualPlayerIndex())).setAvailablePositionsToMove(availablePositions);
                }
                break;
            case "Cards.Intrics.Desc.showCard":
                break;
            case "Cards.Intrics.Type.clock":
                GameController.AddOneToClock();
                gameController.fireRefreshNumberOfDrawnClockCards();
                break;
            default:
                break;
                
        }
        if(gameController.getActualPlayer().getIsComputer()){
            Ai actualAiPlayer=(Ai)gameController.getActualPlayer();
            actualAiPlayer.appendToInformation(LanguageStrings.getString("Intrics.UsedIntricsCard")+System.lineSeparator()+LanguageStrings.getString(text));
            gameController.setActualPlayer(actualAiPlayer);
        }
        
    }

}