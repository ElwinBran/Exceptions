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

import java.util.Collection;

/**
 * Should be used to make/create instances of {@see ExceptionReturnable}.
 *
 * May be used in the future and you, the library user, are free to use it as well.
 *
 * @author Elwin Slokker
 *
 * @param <E> Type of object that provides information about exceptions.
 * @param <R> The required return type. The type that returns when no exceptions
 *           occurred.
 */
public interface BuildableExceptionReturnable<E extends Object,
        R extends Object>
{
    /**
     * Sets the to be returned result/value to {@code returnValue}.
     * @param returnValue to be returned value.
     */
    public void setResult(R returnValue);

    /**
     * Sets the to be returned exception information to {@code info}.
     * @param info to be returned information about encountered exception.
     */
    public void setInformation(Collection<E> info);

    /**
     * @return a wrapper object for methods that might encounter exceptions that
     * <br> complies to {@see ExceptionReturnable}.
     * @throws Throwable when unable to construct an ExceptionReturnable.
     * <br>Always make sure no exception is thrown. This is always preventable
     * <br>by simply providing the builder with enough information.
     */
    public ExceptionReturnable<E, R> build();
}
