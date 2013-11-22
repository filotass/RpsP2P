/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.states.*;
import gui.GameForm;
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
    private int currentRound;
    private int numOfRounds;
    private GameForm gameForm;
    
    
    public Game(String gameID, int numOfRounds, ArrayList<String> peerNames, GameForm gameForm){
        this.currentState = this.preparationState;
        this.numOfRounds = numOfRounds;
        this.gameForm = gameForm;
        this.peers = new ArrayList<>();
        for(String peerName: peerNames){
            Peer peer = new Peer(peerName);
            if(peerName.equals(gameID)){
                peer.setStatus("ACCEPTED");
            }
            peers.add(peer);
         }
        gameForm.setTable(this);
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public GameForm getGameForm() {
        return gameForm;
    }
    
    public ArrayList<Peer> getPeers() {
        return peers;
    }
    
    
    
     @Override
    public void responseToPreparation(String gameID, String peerName, boolean isAccepted) {
        currentState.responseToPreparation(gameID, peerName, isAccepted);
    }

    @Override
    public void readyReceived(String gameID, int round, String peerName) {
      currentState.readyReceived(gameID, round, peerName);
    }

    @Override
    public void answerReceived(String gameID, int round, String peerName, String rpsChoice) {
        currentState.answerReceived(gameID, round, peerName, rpsChoice);
    }

    @Override
    public void cancelReceived(String gameID, String peerName) {
        currentState.cancelReceived(gameID, peerName);
    }
    
}
