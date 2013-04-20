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
        

        final ImageButton[] blankButtonArray = new ImageButton[150];
        for (int i = 0; i < 150; i++)
        {
        blankButtonArray[i] = new ImageButton(activity);
        blankButtonArray[i].setImageResource(R.drawable.blank);
        blankButtonArray[i].setClickable(false);
        blankButtonArray[i].setBackgroundColor(Color.WHITE);
        
        }
                       
        if (numObjects == 4)
        {
            
                TableRow[] tr = new TableRow[3]; 
                for (int i = 0; i < tr.length; i++)
                {
                    tr[i] = new TableRow(activity);
                }
                                                           
               tr[0].addView(blankButtonArray[0],sizeNum,sizeNum);
               tr[0].addView(buttonArray[0],sizeNum,sizeNum);
               tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
               
               tr[1].addView(buttonArray[1],sizeNum,sizeNum);
               tr[1].addView(blankButtonArray[2],sizeNum,sizeNum);
               tr[1].addView(buttonArray[2],sizeNum,sizeNum);
               
               tr[2].addView(blankButtonArray[3],sizeNum,sizeNum);
               tr[2].addView(buttonArray[3],sizeNum,sizeNum);
               tr[2].addView(blankButtonArray[4],sizeNum,sizeNum);
               
               for (int x = 0; x < tr.length; x++)
               {
                   tableLay.addView(tr[x]);
               }           
        }
        else if (numObjects == 5||
                 numObjects == 6||
                 numObjects == 7||
                 numObjects == 8)
        {
            TableRow[] tr = new TableRow[5];  
            for (int i = 0; i < tr.length; i++)
            {
                tr[i] = new TableRow(activity);
            }
                                                           
                tr[0].addView(blankButtonArray[0],sizeNum,sizeNum);
                tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
                tr[0].addView(buttonArray[0],sizeNum,sizeNum);
                tr[0].addView(blankButtonArray[2],sizeNum,sizeNum);
                tr[0].addView(blankButtonArray[3],sizeNum,sizeNum);
                
                tr[1].addView(blankButtonArray[4],sizeNum,sizeNum);
                if(numObjects >= 5){  tr[1].addView(buttonArray[4],sizeNum,sizeNum); }
                else{ tr[1].addView(blankButtonArray[17],sizeNum,sizeNum);}
                tr[1].addView(blankButtonArray[5],sizeNum,sizeNum);
                if(numObjects >= 7){  tr[1].addView(buttonArray[6],sizeNum,sizeNum); }
                else{ tr[1].addView(blankButtonArray[18],sizeNum,sizeNum);}
                tr[1].addView(blankButtonArray[6],sizeNum,sizeNum);
                
                tr[2].addView(buttonArray[1],sizeNum,sizeNum);
                tr[2].addView(blankButtonArray[7],sizeNum,sizeNum);
                tr[2].addView(blankButtonArray[8],sizeNum,sizeNum);
                tr[2].addView(blankButtonArray[9],sizeNum,sizeNum);
                tr[2].addView(buttonArray[2],sizeNum,sizeNum);
                
                tr[3].addView(blankButtonArray[10],sizeNum,sizeNum);
                if(numObjects >= 6){  tr[3].addView(buttonArray[5],sizeNum,sizeNum); }
                else{ tr[3].addView(blankButtonArray[19],sizeNum,sizeNum);}
                tr[3].addView(blankButtonArray[11],sizeNum,sizeNum);
                if(numObjects >= 8){  tr[3].addView(buttonArray[7],sizeNum,sizeNum); }
                else{ tr[3].addView(blankButtonArray[20],sizeNum,sizeNum);}
                tr[3].addView(blankButtonArray[12],sizeNum,sizeNum);
                
                tr[4].addView(blankButtonArray[13],sizeNum,sizeNum);
                tr[4].addView(blankButtonArray[14],sizeNum,sizeNum);
                tr[4].addView(buttonArray[3],sizeNum,sizeNum);
                tr[4].addView(blankButtonArray[15],sizeNum,sizeNum);
                tr[4].addView(blankButtonArray[16],sizeNum,sizeNum);
                
                                                                                             
                for (int x = 0; x < tr.length; x++)
                {
                    tableLay.addView(tr[x]);
                }   
               
        }
        else if (numObjects == 9||
                 numObjects == 10||
                 numObjects == 11||
                 numObjects == 12)
        {
            //create tableRows
            TableRow[] tr = new TableRow[7];  
            for (int i = 0; i < tr.length; i++)
            {
                tr[i] = new TableRow(activity);
            }
            
            tr[0].addView(blankButtonArray[0],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[2],sizeNum,sizeNum);
            tr[0].addView(buttonArray[0],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[3],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[4],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[5],sizeNum,sizeNum);
            
            tr[1].addView(blankButtonArray[6],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[7],sizeNum,sizeNum);
            if(numObjects >= 9){tr[1].addView(buttonArray[8],sizeNum,sizeNum);}
            else{ tr[1].addView(blankButtonArray[37],sizeNum,sizeNum);}
            tr[1].addView(blankButtonArray[8],sizeNum,sizeNum);
            tr[1].addView(buttonArray[1],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[9],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[10],sizeNum,sizeNum);
            
            tr[2].addView(blankButtonArray[11],sizeNum,sizeNum);
            tr[2].addView(buttonArray[2],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[12],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[13],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[14],sizeNum,sizeNum);
            if(numObjects >= 10){tr[2].addView(buttonArray[9],sizeNum,sizeNum);}
            else{ tr[2].addView(blankButtonArray[38],sizeNum,sizeNum);}
            tr[2].addView(blankButtonArray[15],sizeNum,sizeNum);
            
            tr[3].addView(buttonArray[3],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[16],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[17],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[18],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[19],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[20],sizeNum,sizeNum);
            tr[3].addView(buttonArray[4],sizeNum,sizeNum);
            
            tr[4].addView(blankButtonArray[21],sizeNum,sizeNum);
            if(numObjects >= 11){tr[4].addView(buttonArray[10],sizeNum,sizeNum);}
            else{ tr[4].addView(blankButtonArray[39],sizeNum,sizeNum);}
            tr[4].addView(blankButtonArray[22],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[23],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[24],sizeNum,sizeNum);
            tr[4].addView(buttonArray[5],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[25],sizeNum,sizeNum);
            
            tr[5].addView(blankButtonArray[26],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[27],sizeNum,sizeNum);
            if(numObjects >= 12){tr[5].addView(buttonArray[11],sizeNum,sizeNum);}
            else{ tr[5].addView(blankButtonArray[40],sizeNum,sizeNum);}
            tr[5].addView(blankButtonArray[28],sizeNum,sizeNum);
            tr[5].addView(buttonArray[6],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[29],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[30],sizeNum,sizeNum);
            
            tr[6].addView(blankButtonArray[31],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[32],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[33],sizeNum,sizeNum);
            tr[6].addView(buttonArray[7],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[34],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[35],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[36],sizeNum,sizeNum);
            
            
            //add tableRows to table layout
            for (int x = 0; x < tr.length; x++)
            {
                tableLay.addView(tr[x]);
            }   
        }
        else if (numObjects == 13||
                 numObjects == 14||
                 numObjects == 15||
                 numObjects == 16)
        {
            //create tableRows
            TableRow[] tr = new TableRow[9];  
            for (int i = 0; i < tr.length; i++)
            {
                tr[i] = new TableRow(activity);
            }
            
            tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[2],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[3],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[4],sizeNum,sizeNum);
            tr[0].addView(buttonArray[0],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[5],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[6],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[7],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[8],sizeNum,sizeNum);
            
            tr[1].addView(blankButtonArray[9],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[10],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[11],sizeNum,sizeNum);
            tr[1].addView(buttonArray[1],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[12],sizeNum,sizeNum);
            tr[1].addView(buttonArray[2],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[13],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[14],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[15],sizeNum,sizeNum);
            
            tr[2].addView(blankButtonArray[16],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[17],sizeNum,sizeNum);
            if(numObjects >= 13){ tr[2].addView(buttonArray[12],sizeNum,sizeNum);}
            else{ tr[2].addView(blankButtonArray[66],sizeNum,sizeNum);}
            tr[2].addView(blankButtonArray[18],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[19],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[20],sizeNum,sizeNum);
            tr[2].addView(buttonArray[3],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[21],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[22],sizeNum,sizeNum);
           
            tr[3].addView(blankButtonArray[23],sizeNum,sizeNum);
            if(numObjects >= 14){ tr[3].addView(buttonArray[13],sizeNum,sizeNum);}
            else{ tr[3].addView(blankButtonArray[67],sizeNum,sizeNum);}
            tr[3].addView(blankButtonArray[24],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[25],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[26],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[27],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[28],sizeNum,sizeNum);
            tr[3].addView(buttonArray[4],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[29],sizeNum,sizeNum);
            
            tr[4].addView(buttonArray[5],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[30],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[31],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[32],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[33],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[34],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[35],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[36],sizeNum,sizeNum);
            tr[4].addView(buttonArray[6],sizeNum,sizeNum);
            
            tr[5].addView(blankButtonArray[37],sizeNum,sizeNum);
            if(numObjects >= 16){ tr[5].addView(buttonArray[15],sizeNum,sizeNum);}
            else{ tr[5].addView(blankButtonArray[68],sizeNum,sizeNum);}
            tr[5].addView(blankButtonArray[38],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[39],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[40],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[41],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[42],sizeNum,sizeNum);
            tr[5].addView(buttonArray[7],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[43],sizeNum,sizeNum);
            
            tr[6].addView(blankButtonArray[44],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[45],sizeNum,sizeNum);
            if(numObjects >= 15){ tr[6].addView(buttonArray[14],sizeNum,sizeNum);}
            else{ tr[6].addView(blankButtonArray[69],sizeNum,sizeNum);}
            tr[6].addView(blankButtonArray[46],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[47],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[48],sizeNum,sizeNum);
            tr[6].addView(buttonArray[8],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[49],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[50],sizeNum,sizeNum);
            
            tr[7].addView(blankButtonArray[51],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[52],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[53],sizeNum,sizeNum);
            tr[7].addView(buttonArray[9],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[54],sizeNum,sizeNum);
            tr[7].addView(buttonArray[10],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[55],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[56],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[57],sizeNum,sizeNum);
            
            tr[8].addView(blankButtonArray[58],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[59],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[60],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[61],sizeNum,sizeNum);
            tr[8].addView(buttonArray[11],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[62],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[63],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[64],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[65],sizeNum,sizeNum);
           
            
            
            
            
            
            //add tableRows to table layout
            for (int x = 0; x < tr.length; x++)
            {
                tableLay.addView(tr[x]);
            }   
        }
        else if (numObjects == 17||
                 numObjects == 18||
                 numObjects == 19||
                 numObjects == 20)
        {
            //create tableRows
            TableRow[] tr = new TableRow[11];  
            for (int i = 0; i < tr.length; i++)
            {
                tr[i] = new TableRow(activity);
            }
            
            tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[2],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[3],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[4],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[5],sizeNum,sizeNum);
            tr[0].addView(buttonArray[0],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[6],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[7],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[8],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[9],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[10],sizeNum,sizeNum);
            
            tr[1].addView(blankButtonArray[11],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[12],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[13],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[14],sizeNum,sizeNum);
            tr[1].addView(buttonArray[1],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[15],sizeNum,sizeNum);
            tr[1].addView(buttonArray[2],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[16],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[17],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[18],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[19],sizeNum,sizeNum);
            
            tr[2].addView(blankButtonArray[20],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[21],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[22],sizeNum,sizeNum);
            tr[2].addView(buttonArray[3],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[23],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[24],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[25],sizeNum,sizeNum);
            tr[2].addView(buttonArray[4],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[26],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[27],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[28],sizeNum,sizeNum);
            
            tr[3].addView(blankButtonArray[29],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[30],sizeNum,sizeNum);
            if(numObjects >= 17){ tr[3].addView(buttonArray[16],sizeNum,sizeNum);}
            else{ tr[3].addView(blankButtonArray[103],sizeNum,sizeNum);}
            tr[3].addView(blankButtonArray[31],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[32],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[33],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[34],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[35],sizeNum,sizeNum);
            tr[3].addView(buttonArray[5],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[36],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[37],sizeNum,sizeNum);
            
            tr[4].addView(blankButtonArray[38],sizeNum,sizeNum);
            tr[4].addView(buttonArray[6],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[39],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[40],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[41],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[42],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[43],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[44],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[45],sizeNum,sizeNum);
            if(numObjects >= 18){ tr[4].addView(buttonArray[17],sizeNum,sizeNum);}
            else{ tr[4].addView(blankButtonArray[104],sizeNum,sizeNum);}
            tr[4].addView(blankButtonArray[46],sizeNum,sizeNum);
            
            tr[5].addView(buttonArray[7],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[47],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[48],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[49],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[51],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[52],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[53],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[54],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[55],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[56],sizeNum,sizeNum);
            tr[5].addView(buttonArray[8],sizeNum,sizeNum);
            
            tr[6].addView(blankButtonArray[57],sizeNum,sizeNum);
            if(numObjects >= 19){ tr[6].addView(buttonArray[18],sizeNum,sizeNum);}
            else{ tr[6].addView(blankButtonArray[105],sizeNum,sizeNum);}
            tr[6].addView(blankButtonArray[58],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[59],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[60],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[61],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[62],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[63],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[64],sizeNum,sizeNum);
            tr[6].addView(buttonArray[9],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[65],sizeNum,sizeNum);
            
            tr[7].addView(blankButtonArray[66],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[67],sizeNum,sizeNum);
            tr[7].addView(buttonArray[10],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[68],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[69],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[70],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[71],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[72],sizeNum,sizeNum);
            tr[7].addView(buttonArray[11],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[73],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[74],sizeNum,sizeNum);
            
            tr[8].addView(blankButtonArray[75],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[76],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[77],sizeNum,sizeNum);
            tr[8].addView(buttonArray[12],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[78],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[79],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[80],sizeNum,sizeNum);
            if(numObjects >= 20){ tr[8].addView(buttonArray[19],sizeNum,sizeNum);}
            else{ tr[8].addView(blankButtonArray[106],sizeNum,sizeNum);}
            tr[8].addView(blankButtonArray[81],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[82],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[83],sizeNum,sizeNum);
            
            tr[9].addView(blankButtonArray[84],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[85],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[86],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[87],sizeNum,sizeNum);
            tr[9].addView(buttonArray[13],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[88],sizeNum,sizeNum);
            tr[9].addView(buttonArray[14],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[89],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[90],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[91],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[92],sizeNum,sizeNum);
            
            tr[10].addView(blankButtonArray[93],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[94],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[95],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[96],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[97],sizeNum,sizeNum);
            tr[10].addView(buttonArray[15],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[98],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[99],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[100],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[101],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[102],sizeNum,sizeNum);
            //add tableRows to table layout
            for (int x = 0; x < tr.length; x++)
            {
                tableLay.addView(tr[x]);
            }   
        }
        else// (numObjects == 21||
             //    numObjects == 22||
              //   numObjects == 23||
               //  numObjects == 24)
        {
            //create tableRows
            TableRow[] tr = new TableRow[13];  
            for (int i = 0; i < tr.length; i++)
            {
                tr[i] = new TableRow(activity);
            }
            
            tr[0].addView(blankButtonArray[1],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[2],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[3],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[4],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[5],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[6],sizeNum,sizeNum);
            tr[0].addView(buttonArray[0],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[7],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[8],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[9],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[10],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[11],sizeNum,sizeNum);
            tr[0].addView(blankButtonArray[12],sizeNum,sizeNum);
            
            tr[1].addView(blankButtonArray[13],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[14],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[15],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[16],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[17],sizeNum,sizeNum);
            tr[1].addView(buttonArray[1],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[18],sizeNum,sizeNum);
            tr[1].addView(buttonArray[2],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[19],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[20],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[21],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[22],sizeNum,sizeNum);
            tr[1].addView(blankButtonArray[23],sizeNum,sizeNum);
            
            tr[2].addView(blankButtonArray[24],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[25],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[26],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[27],sizeNum,sizeNum);
            tr[2].addView(buttonArray[3],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[28],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[29],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[30],sizeNum,sizeNum);
            tr[2].addView(buttonArray[4],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[31],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[32],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[33],sizeNum,sizeNum);
            tr[2].addView(blankButtonArray[34],sizeNum,sizeNum);
            
            tr[3].addView(blankButtonArray[35],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[36],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[37],sizeNum,sizeNum);
            if(numObjects >= 21){ tr[3].addView(buttonArray[20],sizeNum,sizeNum);}
            else{ tr[3].addView(blankButtonArray[144],sizeNum,sizeNum);}
            tr[3].addView(blankButtonArray[38],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[39],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[40],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[41],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[42],sizeNum,sizeNum);
            tr[3].addView(buttonArray[5],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[43],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[44],sizeNum,sizeNum);
            tr[3].addView(blankButtonArray[45],sizeNum,sizeNum);
            
            tr[4].addView(blankButtonArray[46],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[47],sizeNum,sizeNum);
            tr[4].addView(buttonArray[6],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[48],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[49],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[50],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[51],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[52],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[53],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[54],sizeNum,sizeNum);
            if(numObjects >= 24){ tr[4].addView(buttonArray[23],sizeNum,sizeNum);}
            else{ tr[4].addView(blankButtonArray[145],sizeNum,sizeNum);}
            tr[4].addView(blankButtonArray[55],sizeNum,sizeNum);
            tr[4].addView(blankButtonArray[56],sizeNum,sizeNum);
            
            tr[5].addView(blankButtonArray[148],sizeNum,sizeNum);
            tr[5].addView(buttonArray[7],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[57],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[58],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[59],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[60],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[61],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[62],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[63],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[64],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[65],sizeNum,sizeNum);
            tr[5].addView(buttonArray[8],sizeNum,sizeNum);
            tr[5].addView(blankButtonArray[66],sizeNum,sizeNum);
            
            tr[6].addView(buttonArray[9],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[67],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[68],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[69],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[70],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[71],sizeNum,sizeNum);
            if(numObjects == 25){ tr[6].addView(buttonArray[24],sizeNum,sizeNum);}
            else{tr[6].addView(blankButtonArray[146],sizeNum,sizeNum);}
            tr[6].addView(blankButtonArray[72],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[73],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[74],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[75],sizeNum,sizeNum);
            tr[6].addView(blankButtonArray[76],sizeNum,sizeNum);
            tr[6].addView(buttonArray[10],sizeNum,sizeNum);
            
            tr[7].addView(blankButtonArray[77],sizeNum,sizeNum);
            tr[7].addView(buttonArray[11],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[78],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[79],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[80],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[81],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[82],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[83],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[84],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[85],sizeNum,sizeNum);
            tr[7].addView(blankButtonArray[86],sizeNum,sizeNum);
            if(numObjects >= 23){ tr[7].addView(buttonArray[22],sizeNum,sizeNum);}
            else{ tr[7].addView(blankButtonArray[147],sizeNum,sizeNum);}
            tr[7].addView(blankButtonArray[87],sizeNum,sizeNum);
            
            tr[8].addView(blankButtonArray[88],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[89],sizeNum,sizeNum);
            tr[8].addView(buttonArray[12],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[90],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[91],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[92],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[93],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[94],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[95],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[96],sizeNum,sizeNum);
            tr[8].addView(buttonArray[13],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[97],sizeNum,sizeNum);
            tr[8].addView(blankButtonArray[98],sizeNum,sizeNum);
            
            tr[9].addView(blankButtonArray[99],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[100],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[101],sizeNum,sizeNum);
            if(numObjects >= 22){ tr[9].addView(buttonArray[21],sizeNum,sizeNum);}
            else{ tr[3].addView(blankButtonArray[20],sizeNum,sizeNum);}
            tr[9].addView(blankButtonArray[102],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[103],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[104],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[105],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[106],sizeNum,sizeNum);
            tr[9].addView(buttonArray[14],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[107],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[108],sizeNum,sizeNum);
            tr[9].addView(blankButtonArray[109],sizeNum,sizeNum);
            
            tr[10].addView(blankButtonArray[110],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[111],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[112],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[113],sizeNum,sizeNum);
            tr[10].addView(buttonArray[15],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[114],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[115],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[116],sizeNum,sizeNum);
            tr[10].addView(buttonArray[16],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[117],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[118],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[119],sizeNum,sizeNum);
            tr[10].addView(blankButtonArray[120],sizeNum,sizeNum);
            
            tr[11].addView(blankButtonArray[121],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[122],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[123],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[124],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[125],sizeNum,sizeNum);
            tr[11].addView(buttonArray[17],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[126],sizeNum,sizeNum);
            tr[11].addView(buttonArray[18],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[127],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[128],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[129],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[130],sizeNum,sizeNum);
            tr[11].addView(blankButtonArray[131],sizeNum,sizeNum);
            
            tr[12].addView(blankButtonArray[132],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[133],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[134],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[135],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[136],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[137],sizeNum,sizeNum);
            tr[12].addView(buttonArray[19],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[138],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[139],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[140],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[141],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[142],sizeNum,sizeNum);
            tr[12].addView(blankButtonArray[143],sizeNum,sizeNum);
            //add tableRows to table layout
            for (int x = 0; x < tr.length; x++)
            {
                tableLay.addView(tr[x]);
            }   
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
