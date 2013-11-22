package network;

import game.Game;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import main.Main;

public class Server extends Thread{

        private Main main;
        private int portNum;
        
	private ArrayList<Integer> peerConnectionIDs;
	private HashMap<Integer, PeerConnection> peerConnections;
	private HashMap<String, Integer> routerMap;
	

        private HashMap<String, Game> games;
        
	
	private final Object lockConnections = new Object();
	private final Object lockRouterMap= new Object();
        private final Object lockGames= new Object();
	
	public Server(Main main, int portNum){
		this.portNum = portNum;
                this.main = main;
		peerConnections = new HashMap<>();
		routerMap = new HashMap<>();
                peerConnectionIDs= new ArrayList<>();
                games = new HashMap<>();
                this.start();
	}
	
	public void run(){
                try {
                    ServerSocket server = new ServerSocket(portNum);
                    while (true) {
                            try{
                                Socket socket = server.accept();
                                this.addPeerConnection(new PeerConnection(main, socket));
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
                } catch (IOException e) {
                        e.printStackTrace();
                }
	}
	
	public void addPeerConnection(PeerConnection peerConnection){
            synchronized(lockConnections){
		PeerConnection p = peerConnections.put(peerConnection.getConnectionID(), peerConnection);
		if(p==null){
			peerConnectionIDs.add(peerConnection.getConnectionID());
		}
            }
	}
	
	public void removePeerConnection(Integer peerConnectionID){
            synchronized(lockConnections){
		PeerConnection p = peerConnections.remove(peerConnectionID);
		if(p!=null){
			peerConnectionIDs.remove(p.getConnectionID());
		}
            }
	}
	
	public PeerConnection getPeerConnection(int peerConnectionID){
		return peerConnections.get(peerConnectionID);
	}
	
	
	public void addRouterEntry(String peerName, int peerConnectionID){
            synchronized(lockRouterMap){
		routerMap.put(peerName, peerConnectionID);
            }
	}
	
	public void removeRouterEntry(String peerName){ 
            synchronized(lockRouterMap){
		routerMap.remove(peerName);
            }
	}
	
	public int getRouterEntry(String peerName){ 
		return routerMap.get(peerName);
	}
	

        
        public void addGame(String gameID, Game game){
            synchronized(lockGames){
                games.put(gameID, game);
            }
	}
	
	public void removeGame(String gameID){ 
           synchronized(lockGames){
		games.remove(gameID);
           }
	}
	
	public Game getGame(String gameID){ 
		return games.get(gameID);
	}
        
        public void broadcastMessage(String message){
		for(Integer i:peerConnectionIDs){
			PeerConnection p = peerConnections.get(i);
			if(p!=null){
				p.send(message);
			}
		}
	}
	
	public void sendMessageToPeer(String peerName, String message){
                int i = routerMap.get(peerName);
                PeerConnection p = peerConnections.get(i);
                if(p!=null){
                        p.send(message);
                }
	}
        
        public void propagateMessage(int incomingPeerConnectionID, String message){
            for(Integer i:peerConnectionIDs){
                PeerConnection p = peerConnections.get(i);
                if(p!=null && p.getConnectionID()!=incomingPeerConnectionID){
                        p.send(message);
                }
            }
	}
        
}
