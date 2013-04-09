package com.example.simonsays;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TableLayout;
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
    
//    static final int[] numbers = new int[]
//            {
//            1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25
//            };

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
        
//        4 = 2x2
//        5 -> 9 = 3x3
//        10 -> 16 = 4x4
//        17 -> 25 = 5x5
        
        
        
       
        
//        if(numOfObjects == 4)
//        {
//            tableLay.setc.setRowCount(2);
//            gridlay.setColumnCount(2);
//        }
//        else if(numOfObjects >= 5 || numOfObjects <= 9 )
//        {
//            gridlay.setRowCount(3);
//            gridlay.setColumnCount(3);
//           
//        }
//        else if(numOfObjects >= 10 || numOfObjects <= 16)
//        {
//            gridlay.setRowCount(4);
//            gridlay.setColumnCount(4);           
//        }
//        else
//        {
//            gridlay.setRowCount(5);
//            gridlay.setColumnCount(5);          
//        }
        
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);

// 
//        gridView.setOnItemClickListener(new OnItemClickListener() 
//        {
//            public void onItemClick(AdapterView<?> parent, View v,
//                int position, long id) 
//                {
//                    Toast.makeText(getApplicationContext(),
//                            ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
//                }
//        });
 
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play, menu);
        return true;
    }

}
