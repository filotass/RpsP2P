/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.incoming;

import command.Command;
import command.CommandFactory;
import game.Game;
import game.Peer;
import gui.GameForm;
import gui.MainForm;
import main.Main;
import network.Server;

/**
 *
 * @author FFF
 */
public class AnswerCommand implements Command{

    public static final String code = "Answer";
    
    private String peerName;
    private String answer;
    private String gameID;

    public AnswerCommand(Main main, String destinationPeerName, String peerName, String answer, String gameID, int round, String message){
        this.peerName = peerName;
        this.answer = answer;
        this.gameID = gameID;
        this.gameForm = gameForm;

    }
    
    
    
    @Override
    public String getCode() {
        return AnswerCommand.code;
    }

    @Override
    public void run() {
  
        for(Peer peer: peers){
            if(peer.getName().equals(main.getUsername())){
                peer.setStatus(Game.ANSWERED_STATUS);
                peer.setPrev_choice(Game.SCISSORS);
                game.checkAnsweredStatus();
            }else{
                
    }
    
}
