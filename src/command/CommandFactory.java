package command;

import command.incoming.JoinCommand;
import command.incoming.PrepareCommand;
import java.util.ArrayList;
import main.Main;

public class CommandFactory {

    public static final String S = "~";
    
	public static Command getCommand(Main main, int peerConID, String message){
            String[] params = message.split("~");
            
            String code = params[0];
            if(code.equals(JoinCommand.code)){
                return new JoinCommand(main.getServer(), peerConID, params[1], main.getMainForm(), message);
            }else if(code.equals(PrepareCommand.code)){
                String destinationPeerName = params[1];
                String gameID = params[2];
                int numOfRounds = Integer.parseInt(params[3]);
                int size = params.length;
                ArrayList<String> peerNames = new ArrayList<>();
                for(int i=4;i<size; i++){
                    peerNames.add(params[i]);
                }
                return new PrepareCommand(main, destinationPeerName, gameID, numOfRounds, peerNames, message);
            }

            return null;
	}
}
