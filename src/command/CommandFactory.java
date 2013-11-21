package command;

import command.incoming.JoinCommand;
import main.Main;

public class CommandFactory {

    public static final String S = "~";
    
	public static Command getCommand(Main main, int peerConID, String message){
            String[] params = message.split("~");
            
            String code = params[0];
            if(code.equals(JoinCommand.code)){
                return new JoinCommand(main.getServer(), peerConID, params[1], main.getMainForm());
            }

            return null;
	}
}
