package com.example.simonsays;
import android.R.integer;
import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
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
    }
    
    public void showPattern()
    {
        int i = 0;
        activity.findViewById(buttonsOnScreen[i].getId()).performClick();
    }

}
