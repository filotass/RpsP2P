package command;

public class TCPaddress {

	
	private String ipAddress;
	private int portNum;

	public TCPaddress(String ipAddress, int portNum){
		this.ipAddress = ipAddress;
		this.portNum = portNum;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public int getPortNum() {
		return portNum;
	}
	
	
}
