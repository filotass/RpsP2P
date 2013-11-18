package command;

import java.util.HashMap;

public interface ServerCommandSet {
	
	public void joinReceived(String peerName, TCPaddress peerAddress);
	public void leaveReceived(String peerName);
	public void replaceMeReceived(String peerName, String replacer, HashMap<String, TCPaddress> neighbours);
	public void broadcastReceived(String peerName, TCPaddress tcpAdress, int numOfHops);
	public void peersInfoReceived(HashMap<String,TCPaddress> peerAddresses);

}
