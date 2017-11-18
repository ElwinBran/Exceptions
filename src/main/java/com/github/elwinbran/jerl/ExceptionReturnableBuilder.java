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
package com.github.elwinbran.jerl;


import com.github.elwinbran.jerl.implementation.generic.*;
import java.util.Collection;

/**
 * Should be used to make/create instances of {@see ExceptionReturnable}.
 *
 * @author Elwin Slokker
 *
 * @param <E> Type of object that provides information about exceptions.
 * @param <R> The required return type. The type that returns when no exceptions
 *           occurred.
 * @deprecated until further notice use {@see GenericReturnConstructor}.
 */
@Deprecated
public class ExceptionReturnableBuilder<E extends Object, R extends Object>
    implements BuildableExceptionReturnable<E, R>
{
    private Collection<E> information = null;
    private R result = null;

    protected ExceptionReturnableBuilder() {

    }

    /**
     * @return Creates a builder implementation capable of building the
     * implementations <br>found in {@link org.noorg.jerl.safereturnimpl}.
     */
    public static ExceptionReturnableBuilder newBuilder()
    {return new ExceptionReturnableBuilder();}

    /**
     * {@inheritDoc}
     */
    @Override
    public void setResult(R result)
    {
        this.result = result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInformation(Collection<E> info)
    {
        this.information = info;
    }

    /**
     * Makes/creates an ExceptionReturnable.
     *
     * TODO: this method should be rewritten to be more maintainable.
     *
     * @return
     */
    @Override
    public ExceptionReturnable<E, R> build()
    {
        ExceptionReturnable<E, R> returnable = null;
        if(this.result != null && this.information != null)
        {
            returnable = new WarningReturn<>(this.information, this.result);
        }
        else if(this.result == null && this.information != null)
        {
            returnable = new ExceptionReturn<>(this.information);
        }
        else if(this.result != null && this.information == null)
        {
            returnable = new NormalReturn<>(this.result);
        }
        return returnable;
    }
}
