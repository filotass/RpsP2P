/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command.incoming;

import command.Command;

/**
 *
 * @author FFF
 */
public class AnswerCommand implements Command{

    public static final String code = "Answer";
    
    @Override
    public String getCode() {
        return AnswerCommand.code;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
