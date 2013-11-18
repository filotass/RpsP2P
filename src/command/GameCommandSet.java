package command;

import java.util.ArrayList;

public interface GameCommandSet {

	public void preparationReceived(String initiator, int numOfRounds, ArrayList<String> peerNames);
	public void responseToPreparation(String initiator, String peerName, boolean isAccepted);
	
	public void readyReceived(String initiator, int round, String peerName);
	public void answerReceived(String initiator, int round, String peerName, String rpsChoice);
	
	public void cancelReceived(String initiator, String peerName);
	
	
}
