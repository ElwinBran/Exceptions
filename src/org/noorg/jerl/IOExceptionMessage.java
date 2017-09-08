
package org.noorg.jerl;

import java.util.logging.Level;

/**
 *
 * @author Elwin Slokker
 */
public class IOExceptionMessage implements ExceptionMessageInterface
{
    @Override
    public String getMessage()
    {
        return "Something went wrong with an IO action.";
    }

    @Override
    public Level getLevel()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
