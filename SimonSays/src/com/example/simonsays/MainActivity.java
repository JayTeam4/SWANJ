package com.example.simonsays;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginListener(); 
    }//end of onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }//end of onCreateOptionsMenu
    public void editTextUserNameListener()
    {
      
        
  
    }//end of editTextUserNameListener
    public void loginListener() 
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
                
                final EditText editText=(EditText) findViewById(R.id.editText1);
                
                if(userName.length() != 0)
                {
                    // this will move from screen to screen
                    Intent intent = new Intent(context, ConfigActivity.class);
                    intent.putExtra("user",edUsername.getText().toString() );               
                    startActivity(intent);  
                    edUsername.setText("");
                    editText.setError(null);
                }  
                else
                {
                    if  (editText.getText().toString().trim().equals(""))
                    {
                       editText.setError("Must enter something as a username!");
                    }//end of if
                    else
                    {
                        editText.setError(null);
                    }//end of else
                }//end of else
            }//end of on click
        });
    }// end of loginListener
}//end of class
 
 
 
