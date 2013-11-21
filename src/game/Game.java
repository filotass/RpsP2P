/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.states.*;
import java.util.ArrayList;
import network.Server;

/**
 *
 * @author FFF
 */
public class Game implements GameState{
    
    private GameState preparationState = new PreparationState();
    private GameState awaitingState = new AwaitingState();
    private GameState runningState = new RunningState();
    private GameState endingState = new EndingState();
    
    private GameState currentState = null;
    
    private ArrayList<Peer> peers;
    
    public Game(String gameID, int numOfRounds, ArrayList<String> peerNames){
        currentState = preparationState;
    }
    
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
