/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.incoming;

import command.Command;
import gui.MainForm;
import main.Main;
import network.Server;

/**
 *
 * @author FFF
 */
public class JoinCommand implements Command{

    public static final String code = "Join";
    
    private Server server;
    private String peerName;
    private int peerConID;
    private MainForm mainForm;
    private Main main;
    private String message;
    
    public JoinCommand(Main main, int peerConID, String peerName, MainForm m, String message){
        this.server = main.getServer();
        this.peerName = peerName;
        this.peerConID = peerConID;
        this.mainForm = m;
        this.message = message;
    }
    
    
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void run() {
       server.add(peerName, peerConID);
       server.propagateMessage(peerConID, message);
       mainForm.addNewPeer(peerName);
    }
    
}
