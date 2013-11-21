package game;


public interface GameState {

	public void responseToPreparation(String gameID, String peerName, boolean isAccepted);
        public void cancelReceived(String gameID, String peerName);
	public void readyReceived(String gameID, int round, String peerName);
	public void answerReceived(String gameID, int round, String peerName, String rpsChoice);

}
