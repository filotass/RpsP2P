package command;

import command.incoming.AnswerCommand;
import command.incoming.CancelCommand;
import command.incoming.JoinCommand;
import command.incoming.PrepareCommand;
import command.incoming.ReadyCommand;
import java.util.ArrayList;
import main.Main;

public class CommandFactory {

    public static final String S = "~";
    
	public static Command getCommand(Main main, int peerConID, String message){
            String[] params = message.split(CommandFactory.S);
            
            String code = params[0];
            if(code.equals(JoinCommand.code)){
                return new JoinCommand(main, peerConID, params[1], main.getMainForm(), message);
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
            }else if(code.equals(ReadyCommand.code)){
                return new ReadyCommand(main, params[1], params[2], Integer.parseInt(params[3]), params[4], message);
            }else if(code.equals(AnswerCommand.code)){
               return new AnswerCommand(main, params[1], params[4],params[5], params[2],Integer.parseInt(params[3]), message);
            }else if(code.equals(CancelCommand.code)){
                 return new CancelCommand(main, params[1], params[2], params[3], message);
            }

            return null;
	}
}
