/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

/**
 *
 * @author Bence
 */
public class StartField extends Field {
    private String belongsTo;
    
    public StartField(int x,int y,String type,boolean walkeAble,boolean someOneOn,String belongsTo){
        super(x,y,type,walkeAble,someOneOn);
        this.belongsTo = belongsTo;
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
    
    
}
