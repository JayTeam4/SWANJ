//  Author         :  Jay Lewis
//  Student Number :  J00270628
//  Date Submitted :  **/**/****
//  File           :  *file*
//  Instructor     :  Dawn McKinney
//  Class          :  CIS 121 (6:00 Pm)
//  Identification :  *name*
//  Purpose        :  
//                    
//            	 
package com.example.simonsays;

import java.util.List;
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
import com.example.simonsays.PlayActivity;
/**
 * @author Jay Lewis
 *
 */
public class Diamond extends Layout
{
    private List<Objects> selectedObjects;
    private int numObjects;
    private Activity activity;
    
    Diamond(List<Objects> pickedobjects, int numOfObjects, Activity act)
    {
        selectedObjects = pickedobjects;
        numObjects = numOfObjects;
        activity = act;
    }
    public void createDiamond()
    {
        //diamond 4 objects = 3x3
        // 5 -> 8 = 5x5
        // 9 -> 12 = 7x7
        // 13 -> 16 = 9x9
        // 17 -> 20 = 11x11
        // 21 -> 24 = 13x13
        // 25 = special case 13x13 1 in middle
        
        
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
        final ImageButton[] buttonArray = new ImageButton[numObjects];
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
                  }, 500); 
              }
          }        
                  );
        }
        

        final ImageButton[] blankButtonArray = new ImageButton[numObjects*2];
        for (int i = 0; i < numObjects*2; i++)
        {
        blankButtonArray[i] = new ImageButton(activity);
        blankButtonArray[i].setImageResource(R.drawable.blank);
        blankButtonArray[i].setClickable(false);
        
        }
                       
        if (numObjects == 4)
        {
            TableRow[] tr = new TableRow[3];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
                                                           
               tr[0].addView(blankButtonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
               
               tr[1].addView(buttonArray[1],sizeNum,sizeNum);
               tr[1].addView(blankButtonArray[2],sizeNum,sizeNum);
               tr[1].addView(buttonArray[2],sizeNum,sizeNum);
               
               tr[2].addView(blankButtonArray[3],sizeNum,sizeNum);
               tr[2].addView(buttonArray[3],sizeNum,sizeNum);
               tr[2].addView(blankButtonArray[4],sizeNum,sizeNum);
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]);               
        }
        else if (numObjects == 5||
                 numObjects == 6||
                 numObjects == 7||
                 numObjects == 8)
        {
            TableRow[] tr = new TableRow[3];  
            tr[0] = new TableRow(activity);
            tr[1] = new TableRow(activity);
            tr[2] = new TableRow(activity);
            tr[3] = new TableRow(activity);
            tr[4] = new TableRow(activity);
                                                           
               tr[0].addView(blankButtonArray[0],sizeNum,sizeNum);
               tr[0].addView(blankButtonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(blankButtonArray[0],sizeNum,sizeNum);
               tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
               
               tr[1].addView(buttonArray[1],sizeNum,sizeNum);
               tr[1].addView(blankButtonArray[2],sizeNum,sizeNum);
               tr[1].addView(buttonArray[2],sizeNum,sizeNum);
               tr[1].addView(buttonArray[2],sizeNum,sizeNum);
               tr[1].addView(buttonArray[2],sizeNum,sizeNum);
               
               tr[2].addView(blankButtonArray[3],sizeNum,sizeNum);
               tr[2].addView(buttonArray[3],sizeNum,sizeNum);
               tr[2].addView(blankButtonArray[4],sizeNum,sizeNum);
               tr[2].addView(blankButtonArray[4],sizeNum,sizeNum);
               tr[2].addView(blankButtonArray[4],sizeNum,sizeNum);
               
               
                                                       
               tableLay.addView(tr[0]);
               tableLay.addView(tr[1]);
               tableLay.addView(tr[2]); 
        }
        else if (numObjects == 9||
                 numObjects == 10||
                 numObjects == 11||
                 numObjects == 12)
        {
            
        }
        else if (numObjects == 13||
                 numObjects == 14||
                 numObjects == 15||
                 numObjects == 16)
        {
            
        }
        else if (numObjects == 17||
                 numObjects == 18||
                 numObjects == 19||
                 numObjects == 20)
        {
            
        }
        else if (numObjects == 21||
                 numObjects == 22||
                 numObjects == 23||
                 numObjects == 23)
        {
            
        }
        else// (numObjects == 25)
        {
            
        }
        
        
    }//end of createDiamond

    /**
     * @param pickedobjects
     */
    public Diamond(List<Objects> pickedobjects)
    {
        // TODO Auto-generated constructor stub
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
