            	 
package com.example.simonsays;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableLayout.LayoutParams;
import com.example.simonsays.PlayActivity;



/**
 * @author Jay Lewis
 *
 */
public class Grid extends Layout
{
    private List<Objects> selectedObjects;
    private int numObjects;
    private Activity activity;
    
    Grid(List<Objects> pickedobjects, int numOfObjects, Activity act)
    {
        selectedObjects = pickedobjects;
        numObjects = numOfObjects;
        activity = act;
    }
    
    public void createGrid()
    {
        
        TableLayout tableLay;
        tableLay = (TableLayout)activity.findViewById(R.id.tableLayout1);      
        
        //grid    
        String colorString = "";
        String shapeString = "";                
        String objectString = "";
        int drawableID;
        ImageButton[] buttonArray = new ImageButton[numObjects];
        
        if(numObjects == 4)
        {
            
            for (int k = 0; k < numObjects; k++)
            {
               buttonArray[k] = new ImageButton(activity);
            }
            TableRow[] tr = new TableRow[2];  
            tr[0] = new TableRow(activity);
            
           //tr[0].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, numObjects));
            tr[1] = new TableRow(activity);
            //tr[1].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, numObjects));             
                          
               
               for (int i = 0; i < numObjects; i++)
               {
                   colorString = selectedObjects.get(i).getColor();
                   shapeString = selectedObjects.get(i).getShape();              
                                          
                   objectString = colorString + "_" + shapeString;

                   drawableID = activity.getResources().getIdentifier(objectString, "drawable", activity.getPackageName());
                   buttonArray[i].setImageResource(drawableID);
                   buttonArray[i].setBackgroundColor(0xfff3f3f3);
               }
               int countRight = 0;
               int countDown = 0;
               tr[0].addView(buttonArray[0],100,100);
               tr[0].addView(buttonArray[1]);
               tr[1].addView(buttonArray[2]);
               tr[1].addView(buttonArray[3]);
               
               
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               
        }
        else if(numObjects >= 5 || numObjects <= 9 )
        {
           
        }
        else if(numObjects >= 10 || numObjects <= 16)
        {
                  
        }
        else
        {
                    
        }
    }

    private float getScale(String s)
    {
        if(s == "small")
        {
            return 1;
        }
        if (s == "medium")
        {
            return (float) 1.5;
        }
        if (s == "large")
        {
            return 2;
        }
        return 0;

    }

    /**
     * @return the selectedObjects
     */
    public List<Objects> getSelectedObjects()
    {
        return selectedObjects;
    }

    /**
     * @param selectedObjects the selectedObjects to set
     */
    public void setSelectedObjects(List<Objects> selectedObjects)
    {
        this.selectedObjects = selectedObjects;
    }

    /**
     * @return the activity
     */
    public Activity getActivity()
    {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(Activity activity)
    {
        this.activity = activity;
    }
    
    
    
    
}//end of class
