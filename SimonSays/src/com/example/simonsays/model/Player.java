        	 
package com.example.simonsays.model;


/**
 * @author Jay Lewis
 *
 */
public class Player
{
    //private
    private String playerName;
    private Score playerScore;
    //public
    public String getName()
    {
        return playerName;
    }//end of getName
    public Player(String name, Score myScore)
    {
        playerName = name;    
        playerScore = myScore;
    }
    public void updateScore(long time)
    {
        playerScore.addOneRound();
        playerScore.addTime(time);
    }
    
    
    
}//end of Player
