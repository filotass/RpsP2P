package network;
import command.Command;
import command.CommandFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import main.Main;

public class PeerConnection extends Thread{

	
	private Socket socket;
	private BufferedReader streamIn;
	private BufferedWriter streamOut;
	
	private boolean closed = false;
	private int id;
	private static int increment = 0;
        
        private Main main;
	
	
	public PeerConnection(Main main, Socket socket){
		this.socket = socket;
		if(increment == Integer.MAX_VALUE){
			increment = 0;
		}else{
			increment++;
		}
		id = increment;
                this.main = main;
		this.open();
	}

	
	public void open(){
		try{
			streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			streamOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to close connection to client.
	 * This happens if client wants to close
	 * the connection or if an error occurs.
	 */
	public void close() {
		if (!closed){	// If client is not closed
			closed = true;
			try {
				streamIn.close();
				streamOut.close();
				socket.close();	// close the connection
				System.out.println("Connection to client was closed.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void run(){
		try{
                    System.out.println("Conneciton accepted");
                    while (true){
                        String input = streamIn.readLine();
                        if(input!=null){
                            System.out.println(input);
                            Command command = CommandFactory.getCommand(main, this.id, input);
                            System.out.println("OK1");
                            if(command!=null){
                                    System.out.println("input accepted");
                                    main.schedule(command);
                            }else{
                                    System.err.println("Uknown command :"+ input);
                            }
                        }else{
                            throw new Exception("Connection has been closed.");
                        }
                    }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void send(String messageToSend){
            System.out.println("Out:"+messageToSend);
		try{
			if (this.isClosed())	// Check again if client is closed
				return; 			// If it is exit and don't send the message
				
			if (messageToSend.length() > 0){// check if message length is >0
				streamOut.write(messageToSend+"\n");	// If it is finally send the message
				streamOut.flush();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isClosed(){ 
		return this.closed; 
	}
	
	public int getConnectionID(){ 
		return this.id;
	}


}
