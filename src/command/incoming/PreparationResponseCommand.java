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
public class PreparationResponseCommand implements Command{

    public static final String code = "PrepResponse";
    
    @Override
    public String getCode() {
        return PreparationResponseCommand.code;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
