package com.example.simonsays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
	private List<Objects> allObjects;
	private List<Objects> currentlist;
	private int currentround;
	
	AI(List<Objects> myList)
	{
		allObjects = myList;
		currentround = 0;
		currentlist = new ArrayList<Objects>();
	}
	
	public void addRound()
	{
		currentround++;
	}
	
	public void addNewShapeToList()
	{
		Random r = new Random();
		int i = r.nextInt() % allObjects.size();
		currentlist.add(allObjects.get(i));
	}
	
	public void getListAt(int i)
	{
		currentlist.get(i);
	}

}
