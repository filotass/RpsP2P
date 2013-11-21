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
public class AwaitingState implements GameState{


    @Override
    public void responseToPreparation(String gameID, String peerName, boolean isAccepted) {
        System.err.println("Not supported in this state.");
    }

    @Override
    public void readyReceived(String gameID, int round, String peerName) {
       
    }

    @Override
    public void answerReceived(String gameID, int round, String peerName, String rpsChoice) {
        System.err.println("Not supported in this state.");
    }

    @Override
    public void cancelReceived(String gameID, String peerName) {
        
    }
    
}
