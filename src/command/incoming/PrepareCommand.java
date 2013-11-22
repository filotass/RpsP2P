/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.incoming;

import command.Command;
import command.outgoing.SendCommand;
import game.Game;
import gui.GameForm;
import java.util.ArrayList;
import main.Main;

/**
 *
 * @author FFF
 */
public class PrepareCommand implements Command{

    public static final String code = "Prepare";
    
    private String destinationPeerName;
    private String gameID;
    private ArrayList<String> peerNames;
    private Main main;
    private int numOfRounds;
    private String message;
    
    
    public PrepareCommand(Main main, String destinationPeerName, String gameID, int numOfRounds, ArrayList<String> peerNames, String message){
        this.main = main;
        this.destinationPeerName = destinationPeerName;
        this.peerNames = peerNames;
        this.gameID = gameID;
        this.numOfRounds = numOfRounds;
        this.message = message;
        
    }

    @Override
    public String getCode() {
        return PrepareCommand.code;
    }

    @Override
    public void run() {
        if(this.destinationPeerName.equals(main.getUsername())){
            if(main.getServer().getGame(gameID)==null){
                main.getServer().addGame(gameID, new Game(gameID, numOfRounds, peerNames, new GameForm(main)));
            }
        }else{
            main.schedule(new SendCommand(main.getServer(), destinationPeerName, message));
        }
        
    }
    
}
