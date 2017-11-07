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

import org.noorg.jerl.genericreturnimpl.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Makes/creates {@link ExceptionReturnable} objects.
 * <br><br>
 * There is really not much else to it. Simply pass what information the called
 * <br>method has to this object and it will make the right ExceptionReturnable.
 *
 * @author Elwin Slokker
 *
 * @param <E> Type of object that provides information about exceptions.
 * @param <R> The required return type. The type that returns when no exceptions
 *           occurred.
 */
public class GenericReturnConstructor<E extends Object,R extends Object>
{
    /**
     * @param value the value to pass to the caller.
     * @return a {@see ExceptionReturnable} that had no exceptions.
     */
    public ExceptionReturnable<E, R> construct(final R value)
    {
        return new NormalReturn<>(value);
    }

    /**
     * @param exceptionInformation the collection of information about the
     *                             exception(s).
     * @return a {@see ExceptionReturnable} that encountered a fatal exception.
     */
    public ExceptionReturnable<E, R> construct(
            final Collection<E> exceptionInformation)
    {
        return new ExceptionReturn<E, R>(avoidNull(exceptionInformation));
    }

    /**
     * @param exceptionInformation the array of information about the
     *                             exception(s).
     * @return a {@see ExceptionReturnable} that encountered a fatal exception.
     */
    public ExceptionReturnable<E, R> construct(E... exceptionInformation)
    {
        return new ExceptionReturn<E, R>(
                avoidNull(exceptionInformation));
    }

    /**
     * General use construct method.
     * <br>Will ignore if one of the to arguments are null and call the correct
     * <br>method instead. ({@code value == null} then
     * {@link #construct(Collection)} <br>is called and the opposite also works)
     *
     * @param value the value to pass to the caller.
     * @param exceptionInformation the collection of information about the
     *                             exception(s).
     * @return a {@see ExceptionReturnable} that encountered a non-fatal
     * exception.
     */
    public ExceptionReturnable<E, R> construct(final R value,
            final Collection<E> exceptionInformation)
    {
        if(value == null && exceptionInformation != null)
        {
            return construct(exceptionInformation);
        }
        else if(value != null && exceptionInformation == null)
        {
            return construct(value);
        }
        else
        {//a true warning return that has exceptions and a value.
            return new WarningReturn<E, R>(
                    avoidNull(exceptionInformation), value);
        }
    }

    /**
     * General use construct method.
     * <br>Will ignore if one of the to arguments are null and call the correct
     * <br>method instead. ({@code value == null} then
     * {@link #construct(E...)} <br>is called and the opposite also works)
     *
     * @param value the value to pass to the caller.
     * @param exceptionInformation the array of information about the
     *                             exception(s).
     * @return a {@see ExceptionReturnable} that encountered a non-fatal
     * exception.
     */
    public ExceptionReturnable<E, R> construct(final R value,
                                               E... exceptionInformation)
    {
        if(value == null && exceptionInformation != null)
        {
            return construct(exceptionInformation);
        }
        else if(value != null && exceptionInformation == null)
        {
            return construct(value);
        }
        else {//a true warning return that has exceptions and a value.
            return new WarningReturn<E, R>(
                    avoidNull(exceptionInformation), value);
        }
    }

    /**
     * Converts array of information to a {@see Collection}.
     * <br>Do not call this directly, but let {@link #avoidNull(Object[])} or
     * {@link #avoidNull(Collection)}<br> take care of it implicitly.
     *
     * @param exceptionInformation the array to be converted. May not be null
     *                             or NPE's will occur.
     * @return A collection containing all information from the array.
     */
    protected Collection<E> arrayToCollection(E... exceptionInformation)
    {
        final ArrayList<E> information =
                new ArrayList<>(exceptionInformation.length);
        for(E exInfo : exceptionInformation)
        {
            information.add(exInfo);
        }
        return information;
    }

    /**
     * Literally avoids null pointer exceptions by testing for null and passing
     * it back to the user.
     *
     * @param exceptionInformation a possibly null array of information of
     *                             exceptions.
     * @return A collection to be given directly to a ExceptionReturnable
     * constructor (a real java constructor, not this class).
     */
    protected Collection<E> avoidNull(final E... exceptionInformation)
    {
        if(exceptionInformation == null)
        {
            return null;
        }
        else
        {
            return arrayToCollection(exceptionInformation);
        }
    }

    /**
     * Literally avoids null pointer exceptions by testing for null and passing
     * it back to the user.
     *
     * @param exceptionInformation a possibly null collection of information of
     *                             exceptions.
     * @return A collection to be given directly to a ExceptionReturnable
     * constructor (a real java constructor, not this class).
     */
    protected Collection<E> avoidNull(final Collection<E> exceptionInformation)
    {
        if(exceptionInformation == null)
        {
            return null;
        }
        else
        {
            return new ArrayList<>(exceptionInformation);//copies collection.
        }
    }
}
