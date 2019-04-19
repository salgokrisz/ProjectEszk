
package cluedo.logic.fields;



/**
 *  * This class represents a special field on the map.
 * This field is the starter point of the players.
 * This class is extends the Field class.
 *
 */
public class StartField extends Field {
    private String belongsTo;
    
    public StartField(int x,int y,boolean walkeAble,boolean someOneOn,String belongsTo){
        super(x,y,FieldType.START,walkeAble,someOneOn);
        this.belongsTo = belongsTo;
    }
    
    public StartField(StartField other){
        super(other);
        this.belongsTo=other.getBelongsTo();
    }
    
    @Override
    public Object cloneObject(){
        return new StartField(this);
    }
    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
    }

    public String getBelongsTo() {
        return belongsTo;
    }
    
    @Override
    public String toString(){
        return super.toString()+" belingsTo:"+belongsTo;
    }
    @Override
    public boolean equals(Object obj){
         if(obj==null){
            return false;
        }
        if(obj.getClass()!=StartField.class){
            return false;
        }else{
            return super.equals(obj);
        }
    }

    public int hashCode(){
        return super.hashCode();
    }   
}
