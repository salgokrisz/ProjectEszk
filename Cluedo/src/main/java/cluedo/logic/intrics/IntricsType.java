package cluedo.logic.intrics;

public enum IntricsType{

       DURING_SUSPECT,
       CLOCK,
       AFTER_DICE,
       END_OF_TURN,
       START_OF_TURN,
       LOOK_AT_CARD,
       INSTEAD_OF_DICE;
    @Override
    public String toString(){
        switch(this){
            case DURING_SUSPECT:
                return "Cards.Intics.Type.duringSuspect";
            case CLOCK:
                return "Cards.Intrics.Type.clock";
            case LOOK_AT_CARD:
                return "Cards.Intrics.Type.lookAtCard";
            case AFTER_DICE:
                return "Cards.Intrics.Type.afterDice";
            case END_OF_TURN:
                return "Cards.Intrics.Type.endOfTurn";
            case START_OF_TURN:
                return "Cards.Intrics.Type.startOfTurn";
            case INSTEAD_OF_DICE:
                return "Cards.Intrics.Type.insteadOfDice";
            default:
                return "";
            
        }
    }
}