package com.example.simonsays;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class ConfigActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);
        TextView tvUserName = (TextView) findViewById(R.id.textView2);
        tvUserName.setText(getIntent().getExtras().getString("user"));
        
        logoutListener();
        playListener();
    }//end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }//end of onCreateOptionsMenu
    
    public void logoutListener() 
    {
        Button button;
        
        final EditText  edUsername  = (EditText) findViewById(R.id.editText1);
        final Context context = this;
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() 
        {
            @Override
            public void onClick(View arg0) 
            {
                String userName = edUsername.getText().toString();
                
                if(userName.length() != 0)
                {
                    // this will move from screen to screen
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);                
                }//end of if                        
            }//end of onCLick
        });//end of setOnClickListener
    }// end of logoutListener
    public void playListener()
    {
        Button button;
       
        final Context context = this;
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() 
        {
            @Override
            public void onClick(View arg0) 
            {
                Intent intent = new Intent(context, PlayActivity.class);
                //get number of objects
                Spinner mySpinner = (Spinner)findViewById(R.id.spinner1);
                String spinText = mySpinner.getSelectedItem().toString();
              
                intent.putExtra("numOfObjects", spinText);
                //get shape
                CheckBox square = (CheckBox)findViewById(R.id.checkBox1);
                CheckBox triangle = (CheckBox)findViewById(R.id.checkBox2);
                CheckBox circle = (CheckBox)findViewById(R.id.checkBox3);
                
                if (square.isChecked())
                {
                    intent.putExtra("square", (String)square.getText());
                }
                if (triangle.isChecked())
                {
                    intent.putExtra("triangle", (String)triangle.getText());
                }
                if (circle.isChecked())
                {
                    intent.putExtra("circle", (String)circle.getText());
                }
                //get color
                CheckBox red = (CheckBox)findViewById(R.id.checkBox4);
                CheckBox blue = (CheckBox)findViewById(R.id.checkBox5);
                CheckBox green = (CheckBox)findViewById(R.id.checkBox6);
                CheckBox purple = (CheckBox)findViewById(R.id.checkBox7);
                CheckBox orange = (CheckBox)findViewById(R.id.checkBox8);
                CheckBox yellow = (CheckBox)findViewById(R.id.checkBox9);
                
                if (red.isChecked())
                {
                    intent.putExtra("red", (String)red.getText());
                }
                if (blue.isChecked())
                {
                    intent.putExtra("blue", (String)blue.getText());
                }
                if (green.isChecked())
                {
                    intent.putExtra("green", (String)green.getText());
                }
                if (purple.isChecked())
                {
                    intent.putExtra("purple", (String)purple.getText());
                }
                if (orange.isChecked())
                {
                    intent.putExtra("orange", (String)orange.getText());
                }
                if (yellow.isChecked())
                {
                    intent.putExtra("yellow", (String)yellow.getText());
                }
                //get layout
                RadioGroup myRadioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
                int selected = myRadioGroup.getCheckedRadioButtonId();
                RadioButton buttonSelected = (RadioButton)findViewById(selected);
                String layoutText = (String) buttonSelected.getText();
                               
                intent.putExtra("layout", layoutText);
                
                //get object size
                Spinner mySpinner2 = (Spinner)findViewById(R.id.spinner2);
                String spinText2 = mySpinner2.getSelectedItem().toString();
                
                intent.putExtra("objectSize",spinText2);
                //start
                startActivity(intent);
            }//end of onCLick
        });//end of setOnClickListener
    }
}//end of class






