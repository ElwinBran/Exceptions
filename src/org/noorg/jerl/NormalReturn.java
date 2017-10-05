
package org.noorg.jerl;

/**
 * A successful return that encountered no exceptions.
 * 
 * @author Elwin Slokker
 * @param <E> The exception information the caller expects.
 * @param <R> The required return type.
 */
public class NormalReturn<E extends ExceptionInformation, R extends Object> 
        implements ExceptionReturnable<E, R>
{
    /**
     * The return value.
     */
    private final R value;
    
    /**
     * Simple constructor, used for passing the value.
     * 
     * @param value the object you want the calling code to receive.
     */
    public NormalReturn(final R value)
    {
        this.value = value;
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
     * This object has no exception.
     * @return always {@code false}.
     */
    @Override
    public boolean hasException()
    {
        return false;
    }

    /**
     * @return the (return) value provided by the method that created this 
     * <br>object.
     */
    @Override
    public R getValue()
    {
        return value;
    }

    /**
     * This object has no exception as {@see #hasException hasException()} 
     * already indicates. 
     * <br> DO NOT CALL.
     * @return a {@see Throwable}.
     * @deprecated This method is only here for compliance with the interface.
     */
    @Deprecated
    @Override
    public E getException()
    {
        throw new UnsupportedOperationException("This has no exception, since "
                + "all went well in the method that created this object.");
    }
}
