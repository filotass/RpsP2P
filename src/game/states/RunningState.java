/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.Game;
import game.GameState;
import game.Peer;

/**
 *
 * @author FFF
 */
public class RunningState implements GameState {
    
        
    private Game game;
    
    public RunningState(Game game){
        this.game = game;
    }

    @Override
    public void readyReceived(int round, String peerName) {
       System.err.println("Not supported in this state.");
    }

    @Override
    public void answerReceived( int round, String peerName, String rpsChoice) {
            Peer peer = game.getPeer(peerName);
            peer.setStatus(Game.ANSWERED_STATUS);
            peer.setPrev_choice(rpsChoice);
            game.checkAnsweredStatus();
    }

    

    @Override
    public void cancelReceived(String peerName) {
        
    }
}
