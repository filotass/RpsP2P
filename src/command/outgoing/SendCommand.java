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
public class SendCommand implements Runnable{
    
    private Server server;
    private String message;
    private String peerName;
    
    public SendCommand(Server server, String peerName, String message){
        this.server = server;
        this.message = message;
        this.peerName = peerName;
    }
    
    @Override
    public void run() {
        server.sendMessageToPeer(peerName, message);
    }
}
