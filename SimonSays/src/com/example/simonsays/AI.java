package com.example.simonsays;
import android.R.integer;
import android.R.layout;
import android.app.Activity;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Checkable;
import android.widget.ImageButton;
import android.widget.Toast;

public class AI {
    private List<Objects> allObjects;
    private List<Objects> currentlist;
    private Activity activity;
    private int currentround;
    private ImageButton[] buttonsOnScreen;
    private ImageButton[] pattern = new ImageButton[100];
    private Boolean cont = true;
    private Layout lay;
    
    AI(List<Objects> myList, Activity act, Layout g)
    {
        allObjects = myList;
        currentround = 0;
        currentlist = new ArrayList<Objects>();
        activity = act;
        lay = g;
    }
    
    public void addRound()
    {
        currentround++;
    }
    
    public void addNewShapeToList()
    {
        Random r = new Random();
        int i = r.nextInt(allObjects.size());
        currentlist.add(allObjects.get(i));
    }
    
    public Objects getListAt(int i)
    {
        return currentlist.get(i);
    }
    
    public void setbuttons(ImageButton[] ib)
    {
        buttonsOnScreen = ib;
    }
    
    
    public void addNewButtonToPattern()
    {
        Random r = new Random();
        int i = r.nextInt(buttonsOnScreen.length);
        pattern[currentround] = buttonsOnScreen[i];
        //pattern[currentround].setId(buttonsOnScreen[i].getId());
        addRound();
        showPattern();
    }
    
    public void showPattern()
    {
        for(int i = 0; i<currentround; i++)
        {
        	if(pattern[i] == null )
        		break;
        	else
        	{
        	    final int k = i;
        	    Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    
                    @Override
                    public void run()
                    {
                        activity.findViewById(pattern[k].getId()).performClick();
                        
                    }
                }, 3000*i); 
        	}
        }
    }
    
    private void showButtonAt(int i) 
    {
    	activity.findViewById(pattern[i].getId()).performClick();
	}

	public void disableButtonsExcept(int exception)
    {
    	for(int i = 0; i < buttonsOnScreen.length; i++)
    	{
    		if(i != exception)
    		{
    			buttonsOnScreen[i].setActivated(false);
    		}
    		else {
    			buttonsOnScreen[i].setActivated(true);
			}
    	}
    }
    
    public void disableButtons()
    {
    	for(int i = 0; i < buttonsOnScreen.length; i++)
    	{
    		
    		buttonsOnScreen[i].setActivated(false);
    	}
    }
    
    public void enableButtons()
    {
    	for(int i = 0; i < buttonsOnScreen.length; i++)
    	{
    		
    		buttonsOnScreen[i].setActivated(true);
    	}
    }
    
    public void setContinue(Boolean set)
    {
    	cont = set;
    }
    public Boolean getContinue()
    {
    	return cont;
    }

	public void checkUserInput() {
		for(int i = 0; i<currentround; i++)
		{
			//if()
		}
		
	}
	public void playGame()
	{
	    lay.createLayout();

	    
	    boolean gameFailed = false;
	    
	    while(gameFailed != true)
	    {
	        addNewButtonToPattern();
	        showPattern();
	        
	        int i = 0;
	        for (ImageButton ib: lay.getPlayerSequence())
            {
              if(ib.getId() != pattern[i].getId())
              {
                  gameFailed = true;
                  Toast.makeText(activity.getApplicationContext(), "this is my Toast message!!! =)", Toast.LENGTH_LONG).show();
              }
            }
	       

	    }
	    
	    
	    
	}


}
