/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.outgoing;

import command.Command;
import command.CommandFactory;
import command.incoming.JoinCommand;
import network.Server;

/**
 *
 * @author FFF
 */
public class BroadcastJoinCommand implements Command{

    private Server server;
    private String peerName;
    
    public BroadcastJoinCommand(Server server, String peerName){
        this.server = server;
        this.peerName = peerName;
    }
    
    @Override
    public String getCode() {
        return JoinCommand.code;
    }
    

    @Override
    public void run() {
        System.out.println("Running");
        server.broadcastMessage(this.getCode()+CommandFactory.S+peerName);
    }
    
}
