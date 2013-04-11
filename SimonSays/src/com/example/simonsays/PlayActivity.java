package com.example.simonsays;

import com.example.simonsays.R.layout;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends Activity
{
    TableLayout tableLay;
    
    static final String[] numbers = new String[] { 
        "A", "B", "C", "D", "E",
        "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T",
        "U", "V", "W", "X", "Y", "Z",
        "AA","BB","CC","DD","EE" };
    

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        
        //index for keys from config
        //getIntent().getExtras().getString("user");
        //getIntent().getExtras().getString("numOfObjects");
        //getIntent().getExtras().getString("square");
        //getIntent().getExtras().getString("triangle");
        //getIntent().getExtras().getString("circle");
        //getIntent().getExtras().getString("red");
        //getIntent().getExtras().getString("blue");
        //getIntent().getExtras().getString("green");
        //getIntent().getExtras().getString("purple");
        //getIntent().getExtras().getString("orange");
        //getIntent().getExtras().getString("yellow");
        //getIntent().getExtras().getString("layout");
        //getIntent().getExtras().getString("objectSize");             
        
        
        int numOfObjects = Integer.parseInt(getIntent().getExtras().getString("numOfObjects"));
        Score score = new Score(numOfObjects);
        Player player = new Player(getIntent().getExtras().getString("user"), score);
        
        
        if(getIntent().getExtras().getString("layout") == "grid")
        {
            Grid g = new Grid();
        }
        if(getIntent().getExtras().getString("layout") == "diamond")
        {
            Diamond d = new Diamond();
        }
//        4 = 2x2
//        5 -> 9 = 3x3
//        10 -> 16 = 4x4
//        17 -> 25 = 5x5
        
        
        tableLay = (TableLayout)findViewById(R.id.tableLayout1);  
        final ImageButton button1 = new ImageButton(this);      
        button1.setImageResource(R.drawable.blue_circle);
        button1.setBackgroundColor(Color.WHITE);
        
        final ImageButton button2 = new ImageButton(this);      
        button2.setImageResource(R.drawable.red_triangle);
        button2.setBackgroundColor(Color.WHITE);
        
        final ImageButton button3 = new ImageButton(this);      
        button3.setImageResource(R.drawable.green_circle);
        button3.setBackgroundColor(Color.WHITE);
        
        final ImageButton button4 = new ImageButton(this);      
        button4.setImageResource(R.drawable.yellow_triangle);
        button4.setBackgroundColor(Color.WHITE);      
                
        //diamond 4 objects = 3x3
        // 5 -> 8 = 5x5
        // 9 -> 12 = 7x7
        // 13 -> 16 = 9x9
        // 17 -> 20 = 11x11
        // 21 -> 24 = 13x13
        // 25 = special case 13x13 1 in middle
       
        //grid                 
        if(numOfObjects == 4)
        {
               TableRow tr1 = new TableRow(this);   
               tr1.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
               tr1.addView(button1); 
               tr1.addView(button2);
               
               TableRow tr2 = new TableRow(this);   
               tr2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
               tr2.addView(button3); 
               tr2.addView(button4);
               
               tableLay.addView(tr1);
               tableLay.addView(tr2);
               
        }
        else if(numOfObjects >= 5 || numOfObjects <= 9 )
        {
           
        }
        else if(numOfObjects >= 10 || numOfObjects <= 16)
        {
                  
        }
        else
        {
                    
        }

        button1.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v) 
            {
                //next line is the color / shape you want to change to immediatly after click
                button1.setImageResource(R.drawable.black_circle);
                // SLEEP 2 SECONDS HERE ...
                Handler handler = new Handler(); 
                handler.postDelayed(new Runnable() 
                { 
                     public void run() 
                     { 
                         //this is what the image will return to after the seconds has executed
                         button1.setImageResource(R.drawable.blue_circle); 
                     } 
                }, 500); 
            }
        }        
                );     
        
    }// end of onCreate
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play, menu);
        return true;
    }

}
