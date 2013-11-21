package command;

import java.util.ArrayList;

public interface ServerCommandSet {
	
	public void leaveReceived(String peerName);
	//public void replaceMeReceived(String peerName, String replacer, HashMap<String, TCPaddress> neighbours);
	public void joinReceived(String peerName);
	public void peersInfoReceived(ArrayList<String> peers);

}
