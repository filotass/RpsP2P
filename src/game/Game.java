/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.states.*;
import gui.GameForm;
import java.util.ArrayList;


/**
 *
 * @author FFF
 */
public class Game implements GameState{
    
    public static final String READY_STATUS = "READY";
    public static final String CANCELED_STATUS = "CANCELED";
    public static final String AWAITING_STATUS = "AWAITING";
    public static final String ANSWERED_STATUS = "ANSWERED";
    
    public static final String ROCK = "ROCK";
    public static final String PAPER = "PAPER";
    public static final String SCISSORS = "SCISSORS";
    
    private GameState awaitingState;
    private GameState runningState;
    private GameState endingState;
    
    private GameState currentState = null;
    
    private ArrayList<Peer> peers;
    private int currentRound;
    private int numOfRounds;
    private GameForm gameForm;
    private String gameID;
    
    
    public Game(String gameID, int numOfRounds, ArrayList<String> peerNames, GameForm gameForm){
        
        awaitingState = new AwaitingState(this);
        runningState = new RunningState(this);
        endingState = new EndingState(this);
    
        this.currentState = this.awaitingState;
        this.numOfRounds = numOfRounds;
        this.gameForm = gameForm;
        this.gameID = gameID;
        this.peers = new ArrayList<>();
        for(String peerName: peerNames){
            Peer peer = new Peer(peerName);
            if(peerName.equals(gameID)){
                peer.setStatus(READY_STATUS);
            }
            peers.add(peer);
         }
        gameForm.setGame(this);
        gameForm.setTable(this);
    }

    public String getGameID() {
        return gameID;
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
    
     public Peer getPeer(String peerName) {
        for(Peer peer: peers){
            if(peer.getName().equals(peerName)){
                return peer;
            }
        }
        return null;
    }
    
    
    @Override
    public void readyReceived(int round, String peerName) {
      currentState.readyReceived(round, peerName);
    }

    @Override
    public void answerReceived(int round, String peerName, String rpsChoice) {
        currentState.answerReceived(round, peerName, rpsChoice);
    }

    @Override
    public void cancelReceived(String peerName) {
        currentState.cancelReceived(peerName);
    }

    public void checkReadyStatus() {
        boolean ready = true;
        for(Peer peer: peers){
            if(!peer.getStatus().equals(Game.READY_STATUS)){
                ready = false;
                break;
            }
        }
        
        if(ready){
            this.currentState = runningState;
            this.currentRound += 1;
            gameForm.activateRound();
        }
    }

    public void checkAnsweredStatus() {
        boolean answered = true;
        for(Peer peer: peers){
            if(!peer.getStatus().equals(Game.ANSWERED_STATUS)){
                answered = false;
                break;
            }
        }
        
        if(answered){
            this.evaluateResults();
            gameForm.setTable(this);
            if(this.currentRound == this.numOfRounds){
                this.currentState = endingState;
            }else{
                this.currentState = awaitingState;
                gameForm.activateReady();
            }
        }
    }

    private void evaluateResults() {
        for(Peer peer: peers){
            peer.setPrevRoundPoints(0);
        }
        for(Peer peer: peers){
            int roundPoints = 0;
            for(Peer peer2: peers){
                if(peer.getPrev_choice().equals(Game.ROCK) && peer2.getPrev_choice().equals(Game.SCISSORS)){
                    roundPoints++;
                }else if(peer.getPrev_choice().equals(Game.SCISSORS) && peer2.getPrev_choice().equals(Game.PAPER)){
                    roundPoints++;
                }else if(peer.getPrev_choice().equals(Game.PAPER) && peer2.getPrev_choice().equals(Game.ROCK)){
                    roundPoints++;
                }
            }
            peer.setPrevRoundPoints(roundPoints);
        }
    }
    
}
