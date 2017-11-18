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
package com.github.elwinbran.jerl.implementation.safereturn;


import com.github.elwinbran.jerl.SafeReturn;
import com.github.elwinbran.uei.ExceptionInformation;
import java.util.Collection;

/**
 * An unsuccessful return that did encounter an exception and could not make a 
 * <br>value.
 * 
 * @author Elwin Slokker
 * @param <R> The required return type. The type that would have been returned
 *           <br>when no exceptions occured.
 */
public class SafeExceptionReturn<R extends Object>
        extends SafeReturn<R>
{
    /**
     * The exception.
     */
    private final Collection<ExceptionInformation> information;
    
    /**
     * Simple constructor, used for passing the exception.
     * 
     * @param exInformation the exception information that needs to passed to 
     * <br>the calling code.
     */
    public SafeExceptionReturn(
            final Collection<ExceptionInformation> exInformation)
    {
        
        this.information = exInformation;
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
     * This object has no value as {@see #hasReturnValue hasReturnValue()}
     * already indicates. 
     * <br> DO NOT CALL.
     *
     * @return a {@see Throwable}.
     */
    @Override
    public R getReturn()
    {
        throw new UnsupportedOperationException("This has no value, since "
              + "something went wrong in the method that created this object.");
    }

    /**
     * @return an exception object that should contain details about what went 
     * <br> wrong in the method that created this object.
     */
    @Override
    public Collection<ExceptionInformation> getExceptions()
    {
        return this.information;
    }
}
