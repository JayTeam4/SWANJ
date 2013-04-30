         	 
package com.example.simonsays.model;

/**
 * @author Jay Lewis
 *
 */
public class Score
{
    private int numberOfRounds;
    private int totalObjects;
    private long time;
    
    public Score(int totObjects)
    {
        numberOfRounds = 0;
        time = 0;
        totalObjects = totObjects;
    }
    
    public int getNumberOfRounds()
    {
        return numberOfRounds;
    }//end of getNumberOfRounds
    public long getTime()
    {
        return time;
    }//end of getTime
    public void addOneRound()
    {
       numberOfRounds++;
    }
// something like this can be used to track time for executed method
//    long startTime = System.nanoTime();
//    methodToTime();
//    long endTime = System.nanoTime();
//
//    long duration = endTime - startTime;

    public void addTime(long timeElapsed)
    {
       time += timeElapsed;
        
    }
}//end of class
