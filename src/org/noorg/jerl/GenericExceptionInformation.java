package org.noorg.jerl;

import java.util.logging.Level;

/**
 * Simple exception information provider that can 100% be defined when returned.
 * 
 * @author Elwin Slokker
 */
public class GenericExceptionInformation implements ExceptionInformation
{
    private final String message;
    private final Level level;
    private final Throwable original;
    private final Object thrower;

    /**
     * This constructor initialises simply all fields.
     * 
     * @param message Information about the exception.
     * @param level The severity of the exception.
     * @param throwable The {@see Throwable} that was caught and caused this 
     * <br>exception message to be made.
     * @param thrower The object that made this information.
     */
    public GenericExceptionInformation(final String message, final Level level, 
            final Throwable throwable, final Object thrower)
    {
        this.message = message;
        this.level = level;
        this.original = throwable;
        this.thrower = thrower;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage()
    {
        return this.message;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevel()
    {
        return this.level;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Throwable getOriginalThrowable()
    {
        return this.original;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Object getThrower()
    {
        return this.thrower;
    }
}