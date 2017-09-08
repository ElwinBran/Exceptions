
package org.noorg.jerl;

/**
 * Defines a type that can return a value and an exception. <br>
 * Use whenever a method could encounter an 'exception' and cannot return a 
 * <br> concrete value. For instance, when getting a {@code String} from a file,
 * <br> but the file is corrupt. The method could return {@code null}, throw a
 * <br> {@see Throwable} or return this type. <br>
 * The purpose of these kinds of objects is to avoid {@see Throwable throwables}
 * <br> and {@code null} returns. There are multiple reasons for avoiding them, 
 * <br> and several ways to replace them too.
 * 
 * @author Elwin Slokker
 * @param <E> Some object that can represent errors in a useful way.
 * @param <R> The required return type. The type that returns in most cases.
 */
public interface ExceptionReturnable<E extends ExceptionMessageInterface, R extends Object>
{
    /**
     * Indicates whether {@see #getValue getValue()} will return a value.
     * @return 
     */
    public boolean hasReturnValue();
    /**
     * Indicates whether {@see #getException getException()} will return a value.
     * @return 
     */
    public boolean hasException();
    /**
     * @return the value, if it has one.
     */
    public R getValue();
    /**
     * @return an exception, if it has one.
     */
    public E getException();
}
