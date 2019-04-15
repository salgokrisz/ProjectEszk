/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

import cluedo.logic.fields.FieldType.Type;

/**
 *
 * @author Bence
 */
public class IntricField extends Field{
    
    public IntricField(int x,int y, boolean walkeAble,boolean someOneOn){
        super(x,y,Type.INTRIC,walkeAble,someOneOn);
    }
}
