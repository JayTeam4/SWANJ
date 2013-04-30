        	 
package com.example.simonsays.model;


/**
 * @author Jay Lewis
 *
 */
public class Objects
{
    private String shape;
    private String color;
    private String size;
    private int number;
    
    public Objects(String sh, String co, String si, int num)
    {
    	shape = sh;
    	color = co;
    	size = si;
    	number = num;
    }
    
    public String getShape()
    {
        return shape;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public String getSize()
    {
        return size;
    }
    
    public int getNum()
    {
    	return number;
    }
    
}
