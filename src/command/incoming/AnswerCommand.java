/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.incoming;

import command.Command;
import game.Game;
import gui.GameForm;
import gui.MainForm;
import network.Server;

/**
 *
 * @author FFF
 */
public class AnswerCommand implements Command{

    public static final String code = "Answer";
    
    private String peerName;
    private String answer;
    private GameForm gameForm;
    private Game game;
   
    
    public AnswerCommand(String peerName, String answer, Game game, GameForm gameForm){
 
        this.peerName = peerName;
        this.answer = answer;
        this.game = game;
        this.gameForm = gameForm;

    }
    
    
    
    @Override
    public String getCode() {
        return AnswerCommand.code;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
