        	 
package com.example.simonsays.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.widget.ImageButton;

/**
 * @author Jay Lewis
 *
 */
abstract public class Layout extends Activity
{
    int numberOfObjects;
    List<Integer> playerSequence = new ArrayList<Integer>();
    int getNumberOfObjects()
    {
        return this.numberOfObjects;
    }//end of getNumberOfObjects

    public void createLayout()
    {       
        
    }
    public List<Integer> getPlayerSequence()
    {
        return playerSequence;
                
    }
    public void addToSequence(Integer ib)
    {
        playerSequence.add(ib);
    }
    public ImageButton[] getButtons()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public void setSequence(List<Integer> newArray)
    {
    	playerSequence = newArray;
    }
}//end of class
