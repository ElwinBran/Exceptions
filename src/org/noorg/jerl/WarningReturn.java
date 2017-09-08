
package org.noorg.jerl;

/**
 * A passable return that encountered a minor exception.
 * Albeit minor, it was important enough to 'warn' the calling code.
 * 
 * @author Elwin Slokker
 * @param <E> An exception type that matches the warning.
 * @param <R> The required return type. The type that returns in most cases.
 */
public class WarningReturn<E extends ExceptionMessageInterface, R extends Object> implements ExceptionReturnable<E, R>
{
    /**
     * The warning.
     */
    private final E exception;
    /**
     * The return value.
     */
    private final R value;
    
    /**
     * Simple constructor, used for passing the value and the exception.
     * 
     * @param exception the warning object that needs to passed to the calling code.
     * @param value the object you want the calling code to receive.
     */
    public WarningReturn(E exception, R value)
    {
        this.value = value;
        this.exception = exception;
    }
    /**
     * This object always has a return value.
     * @return always {@code true}.
     */
    @Override
    public boolean hasReturnValue()
    {
        return true;
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
     * @return the (return) value provided by the method that created this object.
     */
    @Override
    public R getValue()
    {
        return this.value;
    }
    
    /**
     * @return an exception/warning object that should contain details about what went 
     * <br> wrong in the method that created this object.
     */
    @Override
    public E getException()
    {
        return this.exception;
    }
}
