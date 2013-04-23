package com.example.simonsays;
import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.widget.ImageButton;

public class AI {
    private List<Objects> allObjects;
    private List<Objects> currentlist;
    private Activity activity;
    private int currentround;
    private ImageButton[] buttonsOnScreen;
    private ImageButton[] pattern = new ImageButton[1000];
    
    AI(List<Objects> myList, Activity act)
    {
        allObjects = myList;
        currentround = 0;
        currentlist = new ArrayList<Objects>();
        activity = act;
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
        addRound();
        alertbox("Are you ready!", "GO");
    }
    
    public void showPattern()
    {
        for(int i = 0; i<currentround; i++)
        {
        	if(pattern[i] == null )
        		break;
        	activity.findViewById(pattern[i].getId()).performClick();
        }
    }
    
    protected void alertbox(String title, String mymessage)
    {
	    new AlertDialog.Builder(activity)
	       .setMessage(mymessage)
	       .setTitle(title)
	       .setPositiveButton("GO",
	          new DialogInterface.OnClickListener() {
	          public void onClick(DialogInterface dialog, int whichButton){
	        	  showPattern();
	          }
	          })
	       .show();
    }

}
