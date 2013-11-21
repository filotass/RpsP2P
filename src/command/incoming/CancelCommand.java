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
public class CancelCommand implements Command{

    public static final String code = "Cancel";
    
    @Override
    public String getCode() {
        return CancelCommand.code;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
