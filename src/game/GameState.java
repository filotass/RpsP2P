package game;


public interface GameState {

	//public void responseToPreparation(String gameID, String peerName, boolean isAccepted);
        public void cancelReceived(String peerName);
	public void readyReceived(int round, String peerName);
	public void answerReceived(int round, String peerName, String rpsChoice);

}
