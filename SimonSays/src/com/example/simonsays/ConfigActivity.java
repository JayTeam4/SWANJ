package com.example.simonsays;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class ConfigActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);
        
        
      //  addItemsOnSpinner1();

    }

//    public void addItemsOnSpinner1()
//    {
//        Spinner spinNumOfObjects = (Spinner)findViewById(R.id.spinner1);
////        List<String> list = new ArrayList<String>();
////        list.add("list 1");
////        list.add("list 2");
////        list.add("list 3");
//        ArrayAdapter<String> spinAdapterNumOfObjects = new ArrayAdapter<String>(this,
//            android.R.layout.simple_spinner_item, R.array.numOfObjects_array);
//        spinAdapterNumOfObjects.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinNumOfObjects.setAdapter(spinAdapterNumOfObjects);
//        
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    Button button;

    


}






