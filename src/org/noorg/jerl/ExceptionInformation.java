
package org.noorg.jerl;

import java.util.logging.Level;

/**
 * Provides everything about an exception.
 * 
 * @author Elwin Slokker
 */
public interface ExceptionInformation
{
    /**
     * @return A string that explains what went wrong 
     * <br>(the unexpected situation).
     */
    public String getMessage();
    /**
     * @return An indication of how bad the exception is.
     */
    public Level getLevel();
    
    /**
     * @return The {@see Throwable} that was caught in the method that returned 
     * <br>this object.
     */
    public Throwable getOriginalThrowable();
    
    /**
     * @return The object that made this exception.
     */
    public Object getThrower();
}