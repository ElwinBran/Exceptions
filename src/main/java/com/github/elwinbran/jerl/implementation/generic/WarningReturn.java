/*
 * Copyright (c) 2017 Elwin Slokker
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.github.elwinbran.jerl.implementation.generic;


import com.github.elwinbran.jerl.ExceptionReturnable;
import java.util.Collection;

/**
 * A passable return that encountered a minor (non-fatal) exception.
 * <br>Albeit minor, it was important enough to 'warn' the calling code.
 * 
 * @author Elwin Slokker
 *
 * @param <E> Type of object that provides information about exceptions.
 * @param <R> The required return type. The type that returns when no exceptions
 *           occurred.
 */
public class WarningReturn<E extends Object, R extends Object>
        implements ExceptionReturnable<E, R>
{
    /**
     * The warning.
     */
    private final Collection<E> information;
    /**
     * The return value.
     */
    private final R value;
    
    /**
     * Simple constructor, used for passing the value and the exception.
     * <br>Should not be used directly in most cases. Rather call one of the
     * <br>builders or factories provided by this library.
     *
     * @param exceptions the warning object that needs to passed to the calling
     * <br>code.
     * @param value the object you want the calling code to receive.
     */
    public WarningReturn(Collection<E> exceptions, R value)
    {
        this.value = value;
        this.information = exceptions;
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
     * @return the (return) value provided by the method that created this 
     * object.
     */
    @Override
    public R getReturn()
    {
        return this.value;
    }
    
    /**
     * @return an exception/warning object that should contain details about 
     * <br> what went wrong in the method that created this object.
     */
    @Override
    public Collection<E> getExceptions()
    {
        return this.information;
    }
}
