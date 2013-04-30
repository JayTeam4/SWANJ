package com.example.simonsays.controller;
import android.R.integer;
import android.R.layout;
import android.R.menu;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import com.example.simonsays.model.Layout;
import com.example.simonsays.model.Objects;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Checkable;
import android.widget.ImageButton;
import android.widget.Toast;

public class SimonSayscontroller {
    private List<Objects> allObjects;
    private List<Objects> currentlist;
    private Activity activity;
    private int currentround;
    private ImageButton[] buttonsOnScreen;
    private ImageButton[] pattern = new ImageButton[100];
    private Boolean cont = true;
    private Layout lay;
    private int gameFailed = 0;
    private Thread gameThread;
    private Boolean resume = false;
    private Boolean addNewButton = true;
    private Boolean checkInput = false;
    
    public SimonSayscontroller(List<Objects> myList, Activity act, Layout g)
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
//    	synchronized (mainThread) {
//			try {
//				mainThread.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
    	addNewButton = false;
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
    		final int k = i;
//	    	Handler handler = new Handler();
//	    	handler.postDelayed(new Runnable() {
    		if(pattern[i] == null )
        		break;
    		else{
//    			List<Integer> holder = lay.playerSequence;
	        	//Toast.makeText(activity, "in", Toast.LENGTH_LONG);
	            //activity.findViewById(pattern[k].getId()).performClick();
//	        	lay.setSequence(holder);
    			
    			Runnable run = new Runnable() {
    	    		@Override
    	    		public void run(){
						List<Integer> holder = lay.getPlayerSequence();
			        	//Toast.makeText(activity, "in", Toast.LENGTH_LONG);
			            activity.findViewById(pattern[k].getId()).performClick();
			        	lay.setSequence(holder);
			        	if(k == currentround-1)
			        		setCheckInput(true);
    	    		}
    			};
    			
	        	Handler handler = new Handler();
    	    	//handler.postDelayed(run, 3000*k);
	        	handler.post(run);
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
	public void setCheckInput(Boolean value)
	{
		checkInput = value;
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

	public void checkUserInput() 
	{
//		synchronized (mainThread) {
//			try {
//				mainThread.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		checkInput = false;
		Handler handler = new Handler();
    	handler.post(new Runnable() {
    		@Override
    		public void run(){
    			int numberOfButtonsUserHasPressed = 0;
    			while(numberOfButtonsUserHasPressed< currentround)
    	        {
    	        	if(lay.getPlayerSequence().size() > numberOfButtonsUserHasPressed)
    	        	{
    	        		if(lay.getPlayerSequence().get(numberOfButtonsUserHasPressed) == pattern[numberOfButtonsUserHasPressed].getId())
    	        		{
    	        			numberOfButtonsUserHasPressed++;
    	        		}
    	        		else {
    	        			//Toast.makeText(activity.getApplicationContext(), "You Mest Up", Toast.LENGTH_LONG).show();
    	        			gameFailed++;
    	        			break;
    					}
    	        	}
    	        }
    			addNewButton = true;
    		}
    	});
//		int numberOfButtonsUserHasPressed = 0;
//		while(numberOfButtonsUserHasPressed< currentround)
//        {
//        	if(lay.getPlayerSequence().size() > numberOfButtonsUserHasPressed)
//        	{
//        		if(lay.getPlayerSequence().get(numberOfButtonsUserHasPressed) == pattern[numberOfButtonsUserHasPressed].getId())
//        		{
//        			numberOfButtonsUserHasPressed++;
//        		}
//        		else {
//        			//Toast.makeText(activity.getApplicationContext(), "You Mest Up", Toast.LENGTH_LONG).show();
//        			gameFailed++;
//        			break;
//				}
//        	}
//        }
//		addNewButton = true;
	}
	
	public void playGame()
	{
	    //addNewButtonToPattern();
        //showPattern();
			    
//	    gameFailed = 0;
//	    while(gameFailed == 0)
//	    {
//	    	if(addNewButton)
//	    		addNewButtonToPattern();
//	    	if(checkInput)
//	    		checkUserInput();
//	    }
	    
	    Runnable run = new Runnable() {
    		@Override
    		public void run(){
    			gameFailed = 0;
    		    while(gameFailed == 0)
    		    {
    		    	if(addNewButton)
    		    		addNewButtonToPattern();
    		    	if(checkInput)
    		    		checkUserInput();
    		    }
    		}
		};
		
    	Handler handler = new Handler();
    	//handler.postDelayed(run, 3000*k);
    	handler.post(run);
	    
	    
	    //Looper myloop = new Looper();
//	    Runnable myRunnable = new Runnable(){
//	    	@Override
//	    	public void run(){
//	    		//disableButtons();
//	    		addNewButtonToPattern();
//				checkUserInput();
//	    		Runnable addGame = new Runnable() {
//	    			@Override
//	    			public void run() {
//	    				// TODO Auto-generated method stub
//	    				
//	    			}
//	    		};
	    	
//	    		Runnable checkButtons = new Runnable() {
//	    			@Override
//	    			public void run() {
//	    				// TODO Auto-generated method stub
//	    				checkUserInput();
//	    			}
//	    		};
	    		//checkButtonsThread = new Thread(checkButtons);
	    		//checkButtonsThread.start();
	    		//for(;gameFailed<1;){
	    			//addButtonsThread.run();
	    			//checkButtonsThread.run();
	    			//lay.playerSequence.clear();
	    		//}
//	    	}
//	    };//while (!checkUserInput()){}
//	    gameThread = new Thread(myRunnable);
//	    gameThread.setPriority(Thread.MAX_PRIORITY);
//		gameThread.start();
	    
	}


}
