/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.Game;
import game.GameState;
import game.Peer;
import main.Main;


/**
 *
 * @author FFF
 */
public class AwaitingState implements GameState{

    private Game game;
    
    public AwaitingState(Game game){
        this.game = game;
    }
    
    @Override
    public void readyReceived(int round, String peerName) {
       Peer peer = game.getPeer(peerName);
       peer.setStatus(Game.READY_STATUS);
       game.getGameForm().setTable(game);
       game.checkReadyStatus();
    }

    @Override
    public void answerReceived(int round, String peerName, String rpsChoice) {
        System.err.println("Not supported in this state.");
    }

    @Override
    public void cancelReceived(String peerName) {
        
    }
    
}
