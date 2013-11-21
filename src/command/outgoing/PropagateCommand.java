/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.outgoing;

import network.Server;

/**
 *
 * @author FFF
 */
public class PropagateCommand implements Runnable{
    
    private Server server;
    private String message;
    private int inPeerConID;
    
    public PropagateCommand(Server server, int inPeerConID, String message){
        this.server = server;
        this.message = message;
        this.inPeerConID = inPeerConID;
    }
    
    @Override
    public void run() {
        server.propagateMessage(inPeerConID,message);
    }
}
