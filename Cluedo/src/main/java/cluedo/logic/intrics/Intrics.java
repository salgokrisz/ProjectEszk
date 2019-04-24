package cluedo.logic.intrics;

import cluedo.tools.languagestring.LanguageStrings;
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

}