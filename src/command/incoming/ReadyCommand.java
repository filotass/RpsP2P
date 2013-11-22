/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.incoming;

import command.Command;
import command.outgoing.SendCommand;
import game.Game;
import main.Main;

/**
 *
 * @author FFF
 */
public class ReadyCommand implements Command{

    public static final String code = "Ready";
    
    private String destinationPeerName;
    private String sourcePeerName;
    private String gameID;
    private Main main;
    private int round;
    private String message;
    
    
    public ReadyCommand(Main main, String destinationPeerName, String gameID, int round, String peerName, String message){
        this.main = main;
        this.destinationPeerName = destinationPeerName;
        this.sourcePeerName = peerName;
        this.gameID = gameID;
        this.round = round;
        this.message = message;    
    }
    
    @Override
    public String getCode() {
        return ReadyCommand.code;
    }

    @Override
    public void run() {
        if(destinationPeerName.equals(main.getUsername())){
           Game game = main.getServer().getGame(gameID);
           if(game!=null){
               game.readyReceived(round, sourcePeerName);
           }
         }else{
            main.schedule(new SendCommand(main.getServer(), destinationPeerName, message));
        }
        
    }
    
}
