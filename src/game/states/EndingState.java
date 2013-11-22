/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.Game;
import game.GameState;


/**
 *
 * @author FFF
 */
public class EndingState implements GameState{
    
      private Game game;
    
    public EndingState(Game game){
        this.game = game;
    }


    @Override
    public void readyReceived(int round, String peerName) {
       System.err.println("Not supported in this state.");
    }

    @Override
    public void answerReceived(int round, String peerName, String rpsChoice) {
        System.err.println("Not supported in this state.");
    }

    @Override
    public void cancelReceived(String peerName) {
        System.err.println("Not supported in this state.");
    }
}
