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
public class BroadcastCommand implements Runnable{

    private Server server;
    private String message;
    
    public BroadcastCommand(Server server, String message){
        this.server = server;
        this.message = message;
    }
    
    @Override
    public void run() {
        server.broadcastMessage(message);
    }
    
}
