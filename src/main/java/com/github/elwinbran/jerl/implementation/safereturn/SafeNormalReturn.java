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
import java.util.Collections;

/**
 * A successful return that encountered no exceptions.
 * 
 * @author Elwin Slokker
 * @param <R> The required return type.
 */
public class SafeNormalReturn<R extends Object> extends SafeReturn<R>
{
    /**
     * The return value.
     */
    private final R value;
    
    /**
     * Simple constructor, used for passing the value.
     * <br>Should not be used directly in most cases. Rather call one of the
     * <br>builders or factories provided by this library.
     * 
     * @param value the object you want the calling code to receive.
     */
    public SafeNormalReturn(final R value)
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
     * @return the (return) value provided by the method that created this 
     * <br>object.
     */
    @Override
    public R getReturn()
    {
        return value;
    }

    /**
     * This object has no exception(s).
     *
     * @return an empty {@see Collection}.
     */
    @Override
    public Collection<ExceptionInformation> getExceptions()
    {
        return Collections.EMPTY_LIST;
    }
}
