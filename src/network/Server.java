package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server extends Thread{

	private ArrayList<Integer> peerConnectionIDs;
	private HashMap<Integer, PeerConnection> peerConnections;
	private HashMap<String, Integer> routerMap;
	
	private int portNum;
	
	//private Object lockConnections;
	//private Object lockRouterMap;
	
	private Server(int portNum){
		this.portNum = portNum;
		peerConnections = new HashMap<>();
		routerMap = new HashMap<>();
	}
	
	public void run(){
		try {
			ServerSocket server = new ServerSocket(portNum);
	        while (true) {
	        	try{
	    			Socket socket = server.accept();
					this.add(new PeerConnection(socket));
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(PeerConnection peerConnection){
		PeerConnection p = peerConnections.put(peerConnection.getConnectionID(), peerConnection);
		if(p==null){
			peerConnectionIDs.add(peerConnection.getConnectionID());
		}
	}
	
	public void remove(Integer peerConnectionID){
		PeerConnection p = peerConnections.remove(peerConnectionID);
		if(p!=null){
			peerConnectionIDs.remove(p.getConnectionID());
		}
	}
	
	public PeerConnection get(int peerConnectionID){
		return peerConnections.get(peerConnectionID);
	}
	
	
	public void add(String peerName, int peerConnectionID){
		routerMap.put(peerName, peerConnectionID);
	}
	
	public void remove(String peerName){ 
		routerMap.remove(peerName);
	}
	
	public int get(String peerName){ 
		return routerMap.get(peerName);
	}
	
	public void broadcastMessage(String message){
		for(Integer i:peerConnectionIDs){
			PeerConnection p = peerConnections.get(i);
			if(p!=null){
				p.send(message);
			}
		}
	}
	
	public void sendMessageToPeer(String username, String message){
			int i = routerMap.get(username);
			PeerConnection p = peerConnections.get(i);
			if(p!=null){
				p.send(message);
			}
	}
	
	
}
