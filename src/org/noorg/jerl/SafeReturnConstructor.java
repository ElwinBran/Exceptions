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
package org.noorg.jerl;

import org.noorg.jerl.exceptioninformation.ExceptionInformation;
import org.noorg.jerl.safereturnimpl.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Makes/creates {@see SafeReturn} objects.
 * <br><br>
 * There is really not much else to it. Simply pass what information the called
 * <br>method has to this object and it will make the right SafeReturn.
 * <br>Do not mind the superclass. This class should be used on its own.
 *
 * @author Elwin Slokker
 *
 * @param <R> The required return type. The type that returns when no exceptions
 *           occurred.
 */
public class SafeReturnConstructor<R extends Object>
        extends GenericReturnConstructor<ExceptionInformation, R>
{
    /**
     * @param value the value to pass to the caller.
     * @return a {@see SafeReturn} that was exceptionless.
     */
    @Override
    public SafeReturn<R> construct(final R value)
    {
        return new SafeNormalReturn<>(value);
    }

    /**
     * @param exceptionInformation the collection of information about the
     *                             exception(s).
     * @return a {@see SafeReturn} that encountered a fatal exception.
     */
    @Override
    public SafeReturn<R> construct(
            final Collection<ExceptionInformation> exceptionInformation)
    {
        return new SafeExceptionReturn<R>(new ArrayList<>(exceptionInformation));
    }

    /**
     * @param exceptionInformation the array of information about the
     *                             exception(s).
     * @return a {@see SafeReturn} that encountered a fatal exception.
     */
    @Override
    public SafeReturn<R> construct(ExceptionInformation... exceptionInformation)
    {
        return new SafeExceptionReturn<R>(
                super.arrayToCollection(exceptionInformation));
    }

    /**
     * Use for making 'warning'-like returns.
     *
     * @param value the value to pass to the caller.
     * @param exceptionInformation the collection of information about the
     *                             exception(s).
     * @return a {@see SafeReturn} that encountered a non-fatal exception.
     */
    @Override
    public SafeReturn<R> construct(final R value,
            final Collection<ExceptionInformation> exceptionInformation)
    {

        return new SafeWarningReturns<>(new ArrayList<>(exceptionInformation), value);
    }

    /**
     * Use for making 'warning'-like returns.
     *
     * @param value the value to pass to the caller.
     * @param exceptionInformation the array of information about the
     *                             exception(s).
     * @return a {@see SafeReturn} that encountered a non-fatal exception.
     */
    @Override
    public SafeReturn<R> construct(final R value,
                      ExceptionInformation... exceptionInformation)
    {
        return new SafeWarningReturns<R>(
                super.arrayToCollection(exceptionInformation), value);
    }
}
