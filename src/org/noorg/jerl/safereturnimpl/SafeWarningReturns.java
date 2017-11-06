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
package org.noorg.jerl.safereturnimpl;

import org.noorg.jerl.exceptioninformation.ExceptionInformation;
import org.noorg.jerl.SafeReturn;
import java.util.Collection;

/**
 * A passable return that encountered a minor (non-fatal) exception.
 * <br>Albeit minor, it was important enough to 'warn' the calling code.
 * 
 * @author Elwin Slokker
 *
 * @param <R> The required return type. The type that returns in most cases.
 */
public class SafeWarningReturns<R extends Object> extends SafeReturn<R>
{
    /**
     * The warning.
     */
    private final Collection<ExceptionInformation> information;
    /**
     * The return value.
     */
    private final R value;
    
    /**
     * Simple constructor, used for passing the value and the exception.
     * <br>Should not be used directly in most cases. Rather call one of the
     * <br>builders or factories provided by this library.
     *
     * @param exceptions the warning object(s) that needs to passed to the
     *                   <br>calling code.
     * @param value the object you want the calling code to receive.
     */
    public SafeWarningReturns(Collection<ExceptionInformation> exceptions, R value)
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
     * This object always has an exception.
     * @return always {@code true}.
     */
    @Override
    public boolean hasException()
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
    public Collection<ExceptionInformation> getExceptions()
    {
        return this.information;
    }
}
