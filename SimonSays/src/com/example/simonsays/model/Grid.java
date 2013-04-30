                 
package com.example.simonsays.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.R.integer;
import android.R.layout;
import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableLayout.LayoutParams;

import com.example.simonsays.R;
import com.example.simonsays.R.id;
import com.example.simonsays.android.view.PlayActivity;



/**
 * @author Jay Lewis
 *
 */

public class Grid extends Layout
{
    List<Integer> playerSequence = new ArrayList<Integer>();
    private List<Objects> selectedObjects;
    private int numObjects;
    private Activity activity;
    private final ImageButton[] buttonArray;
    
    public Grid(List<Objects> pickedobjects, int numOfObjects, Activity act)
    {
        selectedObjects = pickedobjects;
        numObjects = numOfObjects;
        activity = act;
        buttonArray = new ImageButton[numObjects];
        playerSequence = new ArrayList<Integer>();
    }
    public void createLayout()
    {
//      4 = 2x2
//      5 -> 9 = 3x3
//      10 -> 16 = 4x4
//      17 -> 25 = 5x5
        
        TableLayout tableLay;
        tableLay = (TableLayout)activity.findViewById(R.id.tableLayout1);   
        
        //grid    
        String colorString = "";
        String shapeString = "";                
        String objectString = "";
        int sizeNum;
        if (selectedObjects.get(0).getSize().equals("Small"))
        {
             sizeNum = 50;
        }
        else if (selectedObjects.get(0).getSize().equals("Medium"))
        {
             sizeNum = 75;
        }
        else //(selectedObjects.get(0).getSize() == "Large")
        {
              sizeNum = 100;
        }
        int drawableID;
       // buttonArray = new ImageButton[numObjects];

        for (int i = 0; i < numObjects; i++)
        {
            final int k = i;
            
            buttonArray[i] = new ImageButton(activity); 
        
            colorString = selectedObjects.get(i).getColor();
            shapeString = selectedObjects.get(i).getShape();                                                        
            objectString = colorString + "_" + shapeString;               
            
            drawableID = activity.getResources().getIdentifier(objectString, "drawable", activity.getPackageName());
            buttonArray[i].setImageResource(drawableID);
            
            final int oldDrawableID = drawableID;
            
            buttonArray[i].setBackgroundColor(0xFFFFFF);
            buttonArray[i].setScaleType(ScaleType.FIT_XY);   
            buttonArray[i].setId(i);
            buttonArray[i].setOnClickListener(new OnClickListener()
          {              
              @Override
              public void onClick(View v) 
              {
                  String newShape = selectedObjects.get(k).getShape();  
                  String newColor = "black";
                  String newobjectString = newColor + "_" + newShape;
                  
                  int newdrawableID = activity.getResources().getIdentifier(newobjectString, "drawable", activity.getPackageName());
                  buttonArray[k].setImageResource(newdrawableID);
                  //playerSequence.add(buttonArray[k].getId());
                  addToSequence(buttonArray[k].getId());
                                    
                  // SLEEP 2 SECONDS HERE ...
                  Handler handler = new Handler(); 
                  handler.postDelayed(new Runnable() 
                  { 
                       public void run() 
                       { 
                           //this is what the image will return to after the seconds has executed
                           
                           buttonArray[k].setImageResource(oldDrawableID); 
                       } 
                  }, 1000); 
              }
          }        
                  );
        }
        if(numObjects == 4)
        {
            TableRow[] tr = new TableRow[2];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
                                                           
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[1].addView(buttonArray[2],sizeNum,sizeNum);
               tr[1].addView(buttonArray[3],sizeNum,sizeNum);
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               
        }
        else if(numObjects == 5 ||
                numObjects == 6 || 
                numObjects == 7 ||
                numObjects == 8 ||
                numObjects == 9)
        {
            TableRow[] tr = new TableRow[3];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
               
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[0].addView(buttonArray[2],sizeNum,sizeNum);
       
               tr[1].addView(buttonArray[3],sizeNum,sizeNum);
               
               if (numObjects >= 5)
               {
                   tr[1].addView(buttonArray[4],sizeNum,sizeNum);
               }
               if (numObjects >= 6)
               {
                   tr[1].addView(buttonArray[5],sizeNum,sizeNum);
               }
               if (numObjects >= 7)
               {
                   tr[2].addView(buttonArray[6],sizeNum,sizeNum);
               }
               if (numObjects >= 8)
               {
                   tr[2].addView(buttonArray[7],sizeNum,sizeNum);
               }
               if (numObjects >= 9)
               {
                   tr[2].addView(buttonArray[8],sizeNum,sizeNum);
               }
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]);  
               
        }
        else if(numObjects == 10 || 
                numObjects == 11 ||
                numObjects == 12 ||
                numObjects == 13 ||
                numObjects == 14 ||
                numObjects == 15 ||
                numObjects == 16 )
        {
            TableRow[] tr = new TableRow[4];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
            tr[3] = new TableRow(activity);

               
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[0].addView(buttonArray[2],sizeNum,sizeNum);
               tr[0].addView(buttonArray[3],sizeNum,sizeNum);
               
               tr[1].addView(buttonArray[4],sizeNum,sizeNum);
               tr[1].addView(buttonArray[5],sizeNum,sizeNum);
               tr[1].addView(buttonArray[6],sizeNum,sizeNum);
               tr[1].addView(buttonArray[7],sizeNum,sizeNum);
               
               tr[2].addView(buttonArray[8],sizeNum,sizeNum);
               if (numObjects >= 10)
               {
                   tr[2].addView(buttonArray[9],sizeNum,sizeNum);
               }
               if (numObjects >= 11)
               {
                   tr[2].addView(buttonArray[10],sizeNum,sizeNum);
               }
               if (numObjects >= 12)
               {
                   tr[2].addView(buttonArray[11],sizeNum,sizeNum);
               }
               if (numObjects >= 13)
               {
                   tr[3].addView(buttonArray[12],sizeNum,sizeNum);
               }
               if (numObjects >= 14)
               {
                   tr[3].addView(buttonArray[13],sizeNum,sizeNum);
               }
               if (numObjects >= 15)
               {
                   tr[3].addView(buttonArray[14],sizeNum,sizeNum);
               }
               if (numObjects >= 16)
               {
                   tr[3].addView(buttonArray[15],sizeNum,sizeNum);
               }
 
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]);  
               tableLay.addView(tr[3]);  
        }
        else
        {
            TableRow[] tr = new TableRow[5];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
            tr[3] = new TableRow(activity);
            tr[4] = new TableRow(activity);                                                  
               
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[0].addView(buttonArray[2],sizeNum,sizeNum);
               tr[0].addView(buttonArray[3],sizeNum,sizeNum);            
               tr[0].addView(buttonArray[4],sizeNum,sizeNum);
               tr[1].addView(buttonArray[5],sizeNum,sizeNum);
               tr[1].addView(buttonArray[6],sizeNum,sizeNum);
               tr[1].addView(buttonArray[7],sizeNum,sizeNum);
               tr[1].addView(buttonArray[8],sizeNum,sizeNum);
               tr[1].addView(buttonArray[9],sizeNum,sizeNum);
               tr[2].addView(buttonArray[10],sizeNum,sizeNum);
               tr[2].addView(buttonArray[11],sizeNum,sizeNum);
               tr[2].addView(buttonArray[12],sizeNum,sizeNum);
               tr[2].addView(buttonArray[13],sizeNum,sizeNum);
               tr[2].addView(buttonArray[14],sizeNum,sizeNum);
               tr[3].addView(buttonArray[15],sizeNum,sizeNum);
               
               
               if (numObjects >= 17)
               {
                   tr[3].addView(buttonArray[16],sizeNum,sizeNum);
               }
               if (numObjects >= 18)
               {
                   tr[3].addView(buttonArray[17],sizeNum,sizeNum);
               }
               if (numObjects >= 19)
               {
                   tr[3].addView(buttonArray[18],sizeNum,sizeNum);
               }
               if (numObjects >= 20)
               {
                   tr[3].addView(buttonArray[19],sizeNum,sizeNum);
               }
               if (numObjects >= 21)
               {
                   tr[4].addView(buttonArray[20],sizeNum,sizeNum);
               }
               if (numObjects >= 22)
               {
                   tr[4].addView(buttonArray[21],sizeNum,sizeNum);
               }
               if (numObjects >= 23)
               {
                   tr[4].addView(buttonArray[22],sizeNum,sizeNum);
               }
               if (numObjects >= 24)
               {
                   tr[4].addView(buttonArray[23],sizeNum,sizeNum);
               }
               if (numObjects >= 25)
               {
                   tr[4].addView(buttonArray[24],sizeNum,sizeNum);
               }
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]);  
               tableLay.addView(tr[3]); 
               tableLay.addView(tr[4]);   
        }
    
    }
    public void createGrid()
    {
//      4 = 2x2
//      5 -> 9 = 3x3
//      10 -> 16 = 4x4
//      17 -> 25 = 5x5
        
        TableLayout tableLay;
        tableLay = (TableLayout)activity.findViewById(R.id.tableLayout1);   
        
        //grid    
        String colorString = "";
        String shapeString = "";                
        String objectString = "";
        int sizeNum;
        if (selectedObjects.get(0).getSize().equals("Small"))
        {
             sizeNum = 50;
        }
        else if (selectedObjects.get(0).getSize().equals("Medium"))
        {
             sizeNum = 75;
        }
        else //(selectedObjects.get(0).getSize() == "Large")
        {
              sizeNum = 100;
        }
        int drawableID;
       // buttonArray = new ImageButton[numObjects];

        for (int i = 0; i < numObjects; i++)
        {
            final int k = i;
            
            buttonArray[i] = new ImageButton(activity); 
        
            colorString = selectedObjects.get(i).getColor();
            shapeString = selectedObjects.get(i).getShape();                                                        
            objectString = colorString + "_" + shapeString;               
            
            drawableID = activity.getResources().getIdentifier(objectString, "drawable", activity.getPackageName());
            buttonArray[i].setImageResource(drawableID);
            
            final int oldDrawableID = drawableID;
            
            buttonArray[i].setBackgroundColor(0xfff3f3f3);
            buttonArray[i].setScaleType(ScaleType.FIT_XY);   
            buttonArray[i].setId(i);
            buttonArray[i].setOnClickListener(new OnClickListener()
          {              
              @Override
              public void onClick(View v) 
              {
                  playerSequence.add(buttonArray[k].getId());
                  String newShape = selectedObjects.get(k).getShape();  
                  String newColor = "black";
                  String newobjectString = newColor + "_" + newShape;
                  
                  int newdrawableID = activity.getResources().getIdentifier(newobjectString, "drawable", activity.getPackageName());
                  buttonArray[k].setImageResource(newdrawableID);
                                    
                  // SLEEP 2 SECONDS HERE ...
                  Handler handler = new Handler(); 
                  handler.postDelayed(new Runnable() 
                  { 
                       public void run() 
                       { 
                           //this is what the image will return to after the seconds has executed
                          
                           buttonArray[k].setImageResource(oldDrawableID); 
                           
                           
                       } 
                  }, 1000); 
              }
          }        
                  );
        }
        if(numObjects == 4)
        {
            TableRow[] tr = new TableRow[2];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
                                                           
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[1].addView(buttonArray[2],sizeNum,sizeNum);
               tr[1].addView(buttonArray[3],sizeNum,sizeNum);
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               
        }
        else if(numObjects == 5 ||
                numObjects == 6 || 
                numObjects == 7 ||
                numObjects == 8 ||
                numObjects == 9)
        {
            TableRow[] tr = new TableRow[3];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
               
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[0].addView(buttonArray[2],sizeNum,sizeNum);
       
               tr[1].addView(buttonArray[3],sizeNum,sizeNum);
               
               if (numObjects >= 5)
               {
                   tr[1].addView(buttonArray[4],sizeNum,sizeNum);
               }
               if (numObjects >= 6)
               {
                   tr[1].addView(buttonArray[5],sizeNum,sizeNum);
               }
               if (numObjects >= 7)
               {
                   tr[2].addView(buttonArray[6],sizeNum,sizeNum);
               }
               if (numObjects >= 8)
               {
                   tr[2].addView(buttonArray[7],sizeNum,sizeNum);
               }
               if (numObjects >= 9)
               {
                   tr[2].addView(buttonArray[8],sizeNum,sizeNum);
               }
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]);  
               
        }
        else if(numObjects == 10 || 
                numObjects == 11 ||
                numObjects == 12 ||
                numObjects == 13 ||
                numObjects == 14 ||
                numObjects == 15 ||
                numObjects == 16 )
        {
            TableRow[] tr = new TableRow[4];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
            tr[3] = new TableRow(activity);

               
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[0].addView(buttonArray[2],sizeNum,sizeNum);
               tr[0].addView(buttonArray[3],sizeNum,sizeNum);
               
               tr[1].addView(buttonArray[4],sizeNum,sizeNum);
               tr[1].addView(buttonArray[5],sizeNum,sizeNum);
               tr[1].addView(buttonArray[6],sizeNum,sizeNum);
               tr[1].addView(buttonArray[7],sizeNum,sizeNum);
               
               tr[2].addView(buttonArray[8],sizeNum,sizeNum);
               if (numObjects >= 10)
               {
                   tr[2].addView(buttonArray[9],sizeNum,sizeNum);
               }
               if (numObjects >= 11)
               {
                   tr[2].addView(buttonArray[10],sizeNum,sizeNum);
               }
               if (numObjects >= 12)
               {
                   tr[2].addView(buttonArray[11],sizeNum,sizeNum);
               }
               if (numObjects >= 13)
               {
                   tr[3].addView(buttonArray[12],sizeNum,sizeNum);
               }
               if (numObjects >= 14)
               {
                   tr[3].addView(buttonArray[13],sizeNum,sizeNum);
               }
               if (numObjects >= 15)
               {
                   tr[3].addView(buttonArray[14],sizeNum,sizeNum);
               }
               if (numObjects >= 16)
               {
                   tr[3].addView(buttonArray[15],sizeNum,sizeNum);
               }
 
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]);  
               tableLay.addView(tr[3]);  
        }
        else
        {
            TableRow[] tr = new TableRow[5];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
            tr[3] = new TableRow(activity);
            tr[4] = new TableRow(activity);                                                  
               
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[1],sizeNum,sizeNum);
               tr[0].addView(buttonArray[2],sizeNum,sizeNum);
               tr[0].addView(buttonArray[3],sizeNum,sizeNum);            
               tr[0].addView(buttonArray[4],sizeNum,sizeNum);
               tr[1].addView(buttonArray[5],sizeNum,sizeNum);
               tr[1].addView(buttonArray[6],sizeNum,sizeNum);
               tr[1].addView(buttonArray[7],sizeNum,sizeNum);
               tr[1].addView(buttonArray[8],sizeNum,sizeNum);
               tr[1].addView(buttonArray[9],sizeNum,sizeNum);
               tr[2].addView(buttonArray[10],sizeNum,sizeNum);
               tr[2].addView(buttonArray[11],sizeNum,sizeNum);
               tr[2].addView(buttonArray[12],sizeNum,sizeNum);
               tr[2].addView(buttonArray[13],sizeNum,sizeNum);
               tr[2].addView(buttonArray[14],sizeNum,sizeNum);
               tr[3].addView(buttonArray[15],sizeNum,sizeNum);
               
               
               if (numObjects >= 17)
               {
                   tr[3].addView(buttonArray[16],sizeNum,sizeNum);
               }
               if (numObjects >= 18)
               {
                   tr[3].addView(buttonArray[17],sizeNum,sizeNum);
               }
               if (numObjects >= 19)
               {
                   tr[3].addView(buttonArray[18],sizeNum,sizeNum);
               }
               if (numObjects >= 20)
               {
                   tr[3].addView(buttonArray[19],sizeNum,sizeNum);
               }
               if (numObjects >= 21)
               {
                   tr[4].addView(buttonArray[20],sizeNum,sizeNum);
               }
               if (numObjects >= 22)
               {
                   tr[4].addView(buttonArray[21],sizeNum,sizeNum);
               }
               if (numObjects >= 23)
               {
                   tr[4].addView(buttonArray[22],sizeNum,sizeNum);
               }
               if (numObjects >= 24)
               {
                   tr[4].addView(buttonArray[23],sizeNum,sizeNum);
               }
               if (numObjects >= 25)
               {
                   tr[4].addView(buttonArray[24],sizeNum,sizeNum);
               }
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]);  
               tableLay.addView(tr[3]); 
               tableLay.addView(tr[4]);   
        }
    }
    public int getScale(String s)
    {
        if(s == "Small")
        {
            return 50;
        }
        if (s == "Medium")
        {
            return 100;
        }
        if (s == "Large")
        {
            return 150;
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
    
    public ImageButton[] getButtons()
    {
        return buttonArray;
    }
    public List<Integer> getPlayerSequence()
    {
        return playerSequence;
                
    }
    public void addToSequence(Integer i)
    {
        playerSequence.add(i);
    }
    
    public void setSequence(List<Integer> newArray)
    {
    	playerSequence = newArray;
    }
    
    
    
}//end of class
