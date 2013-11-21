/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.GameState;
import java.util.ArrayList;

/**
 *
 * @author FFF
 */
public class PreparationState implements GameState{
    
        


    @Override
    public void responseToPreparation(String gameID, String peerName, boolean isAccepted) {
      
    }

    @Override
    public void readyReceived(String gameID, int round, String peerName) {
       System.err.println("Not supported in this state.");
    }

    @Override
    public void answerReceived(String gameID, int round, String peerName, String rpsChoice) {
        System.err.println("Not supported in this state.");
    }

    @Override
    public void cancelReceived(String gameID, String peerName) {
      
    }
}
