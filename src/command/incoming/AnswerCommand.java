/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.incoming;

import command.Command;
import command.CommandFactory;
import command.outgoing.SendCommand;
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
    
    private String destinationPeerName;
    private String peerName;
    private String answer;
    private String gameID;
    private String message;
    private int round;
    private Main main;

    public AnswerCommand(Main main, String destinationPeerName, String peerName, String answer, String gameID, int round, String message){
        this.main = main;
        this.destinationPeerName = destinationPeerName;
        this.peerName = peerName;
        this.answer = answer;
        this.gameID = gameID;
        this.round = round;
        this.message = message;
        

    }
    
    
    
    @Override
    public String getCode() {
        return AnswerCommand.code;
    }

    @Override
    public void run() {
         if(destinationPeerName.equals(main.getUsername())){
           Game game = main.getServer().getGame(gameID);
           if(game!=null){
               game.answerReceived(round, peerName, answer);
           }
         }else{
            main.schedule(new SendCommand(main.getServer(), destinationPeerName, message));
        }
    }
    
}
