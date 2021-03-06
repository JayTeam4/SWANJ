package com.example.simonsays.android.view;
import com.example.simonsays.R;
import com.example.simonsays.controller.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import com.example.simonsays.R.layout;
import com.example.simonsays.R.menu;
import com.example.simonsays.controller.SimonSayscontroller;
import com.example.simonsays.model.Diamond;
import com.example.simonsays.model.Grid;
import com.example.simonsays.model.Layout;
import com.example.simonsays.model.Objects;
import com.example.simonsays.model.Player;
import com.example.simonsays.model.Score;

import android.os.Bundle;
import android.os.Handler;
import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends Activity
{
    TableLayout tableLay;
    private List<Objects> pickedobjects = new ArrayList<Objects>();  
    private ImageButton[] currentButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        String[] color = getColors();
        String size = (String) getIntent().getExtras().get("objectSize");
       // String size = getIntent().getExtras().getString("objectSize");
        String[] shape = getShapes();
        populateList(numOfObjects, color, size, shape);
        Score score = new Score(numOfObjects);
        Player player = new Player(getIntent().getExtras().getString("user"), score);

       // final AI testAI = new AI(pickedobjects, this);
        
        //TextView;
        
//        testAI.addNewShapeToList();
//        testAI.addNewShapeToList();
//        testAI.addNewShapeToList();      
//        
        if(getIntent().getExtras().getString("layout").contains("grid"))
        {
            
            
            Layout g = new Grid(pickedobjects,numOfObjects,this);
            g.createLayout();
            setcurrentButtons(g.getButtons());
            
            final SimonSayscontroller testAI = new SimonSayscontroller(pickedobjects, this, g);
            
            testAI.setbuttons(currentButtons);
            
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);
            // set title
            alertDialogBuilder.setTitle("Your Title");

            // set dialog message
            alertDialogBuilder
                .setMessage("Are you Ready?!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        //testAI.setContinue(false);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {    
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                testAI.playGame();
                                
                            }
                        }, 1000);
                    }
                  });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        if(getIntent().getExtras().getString("layout").contains("diamond"))
        {
            final Diamond d = new Diamond(pickedobjects,numOfObjects,this);
            d.createLayout();
            setcurrentButtons(d.getButtons());
            
            final SimonSayscontroller testAI = new SimonSayscontroller(pickedobjects, this, d);
            
            testAI.setbuttons(currentButtons);
            
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);
            // set title
            alertDialogBuilder.setTitle("Your Title");

            // set dialog message
            alertDialogBuilder
                .setMessage("Are you Ready?!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
//                    	testAI.playGame();
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {    
//                            @Override
//                            public void run() {
//                         	   testAI.playGame();                                
//                            }
//                        }, 3000);
                        
                        Runnable run = new Runnable() {    
                            @Override
                            public void run() {
                         	   testAI.playGame();                                
                            }
                        };
                        
                        Handler handler = new Handler();
                        handler.postDelayed(run, 3000);
                        
                    }
                  });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
//        testAI.setbuttons(currentButtons);
//        
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//				this);
//        // set title
//		alertDialogBuilder.setTitle("Your Title");
//
//		// set dialog message
//		alertDialogBuilder
//			.setMessage("Are you Ready?!")
//			.setCancelable(false)
//			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog,int id) {
//					// if this button is clicked, close
//					// current activity
//					testAI.setContinue(false);
//					Handler handler = new Handler();
//					handler.postDelayed(new Runnable() {	
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//						    testAI.playGame();
//							
//						}
//					}, 3000);
//				}
//			  });
//		// create alert dialog
//		AlertDialog alertDialog = alertDialogBuilder.create();
//		alertDialog.show();
////        	testAI.addNewButtonToPattern();
////        	testAI.checkUserInput();
    			
        

    }// end of onCreate
    public static int getImageId(Context context, String imageName) 
    {        
        return context.getResources().getIdentifier("R.drawable." + imageName, null, context.getPackageName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play, menu);
        return true;
    }
    
    private String[] getColors()
    {
        String[] result;
        int size = 0;
        int currentIndex = 0;
        if(getIntent().getExtras().getString("red") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("blue") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("green") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("purple") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("orange") != null)
        {
            size++;
        }
        if(getIntent().getExtras().getString("yellow") != null)
        {
            size++;
        }
        
        result = new String[size];

        if(getIntent().getExtras().getString("red") != null)
        {
            result[currentIndex] = "red";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("blue") != null)
        {
            result[currentIndex] = "blue";
            currentIndex++;
        }

        if(getIntent().getExtras().getString("purple") != null)
        {
            result[currentIndex] = "purple";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("orange") != null)
        {
            result[currentIndex] = "orange";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("yellow") != null)
        {
            result[currentIndex] = "yellow";
            currentIndex++;
        }
        if(getIntent().getExtras().getString("green") != null)
        {
          result[currentIndex] = "green";
          currentIndex++;
        }        
        return result;
    }
    
    private String[] getShapes()
    {
        String[] result;
        int size = 0;
        int currentIndex = 0;
        if(getIntent().getExtras().getString("square") != null)
        {
            size++;
        }
        
        if(getIntent().getExtras().getString("triangle") != null)
        {
            size++;
        }
        
        if(getIntent().getExtras().getString("circle") != null)
        {
            size++;
        }
        
        result = new String[size];
        
        if(getIntent().getExtras().getString("square") != null)
        {
            result[currentIndex] = "square";
            currentIndex++;
        }
        
        if(getIntent().getExtras().getString("triangle") != null)
        {
            result[currentIndex] = "triangle";
            currentIndex++;
        }
        
        if(getIntent().getExtras().getString("circle") != null)
        {
            result[currentIndex] = "circle";
            currentIndex++;
        }
        
        return result;
    }
    
    public void populateList(int num, String[] color, String size, String[] shape)
    {
        Random r = new Random();
        for(int i = 0; i < num; i++)
        {         
            int j = r.nextInt(color.length);
            int k = r.nextInt(shape.length);
            pickedobjects.add(new Objects(shape[k], color[j], size, i));
        }       
    }
    
    public void setcurrentButtons(ImageButton[] ibarray)
    {
        currentButtons = ibarray;
    }
    
    public ImageButton[] getCurrentButtons()
    {
    	return currentButtons;
    }
    
    

}
