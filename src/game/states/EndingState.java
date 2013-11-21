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
public class EndingState implements GameState{
    


    @Override
    public void responseToPreparation(String gameID, String peerName, boolean isAccepted) {
        System.err.println("Not supported in this state.");
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
        System.err.println("Not supported in this state.");
    }
}
