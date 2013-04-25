        	 
package com.example.simonsays;

import java.util.List;
import java.util.Set;

import android.widget.ImageButton;

/**
 * @author Jay Lewis
 *
 */
abstract class Layout
{
    int numberOfObjects;
    List<Integer> playerSequence;
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
    ImageButton[] getButtons()
    {
        // TODO Auto-generated method stub
        return null;
    }
}//end of class
