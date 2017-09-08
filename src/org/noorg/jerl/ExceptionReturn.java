
package org.noorg.jerl;

/**
 * An unsuccessful return that did encounter an exception and could not make a value.
 * 
 * @author Elwin Slokker
 * @param <E> An exception type that matches the exception.
 * @param <R> The required return type. The type that returns in most cases.
 */
public class ExceptionReturn<E extends ExceptionMessageInterface, R extends Object> implements ExceptionReturnable<E, R>
{
    /**
     * The exception.
     */
    private final E exception;
    
    /**
     * Simple constructor, used for passing the exception.
     * 
     * @param exception the exception object that needs to passed to the calling code.
     */
    public ExceptionReturn(E exception)
    {
        this.exception = exception;
    }
    
    /**
     * This object has no return value.
     * @return always {@code false}.
     */
    @Override
    public boolean hasReturnValue()
    {
        return false;
    }

    /**
     * This object always has an exception.
     * @return always {@code true}.
     */
    @Override
    public boolean hasException()
    {
        return true;
    }

    /**
     * This object has no value as {@see #hasReturnValue hasReturnValue()}
     * already indicates. 
     * <br> DO NOT CALL.
     * @return a {@see Throwable}.
     * @deprecated This method is only here for compliance with the interface.
     */
    @Deprecated
    @Override
    public R getValue()
    {
        throw new UnsupportedOperationException("This has no value, since something went wrong in the method that created this object.");
    }

    /**
     * @return an exception object that should contain details about what went 
     * <br> wrong in the method that created this object.
     */
    @Override
    public E getException()
    {
        return this.exception;
    }
}
