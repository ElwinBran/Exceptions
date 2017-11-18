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
 * Wraps return values from methods that might encounter exceptions.
 * <br><br>
 * Always call {@link #hasReturnValue()} or {@link #hasException()} and
 * check the <br> outcome before calling {@link #getReturn()}<br> or
 * {@link #getExceptions()} respectively.
 * <br>Use whenever a method could encounter an 'exception' and cannot return a
 * <br> concrete value. For instance, when getting a {@code String} from a file,
 * <br> but the file is corrupt. The method could return {@code null}, throw a
 * <br> {@see Throwable} or return this type. <br> For more information on the
 * why, check out included documentation.
 * 
 * @author Elwin Slokker
 *
 * @param <E> Type of object that provides information about exceptions.
 * @param <R> The required return type. The type that returns when no exceptions
 *           occurred.
 */
public interface ExceptionReturnable<E extends Object, R extends Object>
{
    /**
     * Indicates whether {@see #getValue getValue()} will return a value.
     * @return <code>true</code>, if the method returned something usefull;
     * <br> <code>false</code> otherwise.
     */
    public boolean hasReturnValue();

    /**
     * @return the value that was put into this object by the called method.
     * @throws Throwable when called while
     * {@link #hasReturnValue hasReturnValue()} {@code == false}.
     * <br>May return any kind of Throwable, it is up to the implementing
     * classes to decide.
     */
    public R getReturn();

    /**
     * @return the exception that was put into this object by the called method.
     * <br>If there are no exceptions, simply returns an empty list.
     */
    public Collection<E> getExceptions();
}
