
package org.noorg.jerl;

import java.util.logging.Level;

/**
 * TODO this is certainly not the final version.
 * @author Elwin Slokker
 */
public interface ExceptionMessageInterface
{
    /**
     * TODO, not sure if simply returning a String of information is enough.
     * @return 
     */
    public String getMessage();
    /**
     * TODO, not sure this is a good method to include.
     * @return 
     */
    public Level getLevel();
}