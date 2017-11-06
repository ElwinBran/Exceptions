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
package org.noorg.jerl.exceptioninformation;

import java.util.logging.Level;

/**
 * A simple generic implementation of {@see ExceptionInformationBuilder} that
 * <br>creates the standard provided implementations of
 * {@see ExceptionInformation}.
 *
 * @author Elwin Slokker
 */
public class ExceptionInformationBuilderGeneric
        implements ExceptionInformationBuilder
{
    /**
     * Holds the message.
     */
    private String message = null;

    /**
     * Holds the exception severity.
     */
    private Level level = null;

    /**
     * May hold a caught exception.
     */
    private Throwable throwable = null;

    /**
     * Holds the object were the exception was encountered.
     */
    private Object thrower = null;

    /**
     * Should only be known to subclasses.
     * <br>Might be made public in future releases, but as of now there is no
     * <br> reason to create it directly and only causes tight coupling.
     */
    protected ExceptionInformationBuilderGeneric() {}


    /**
     * {@inheritDoc}
     */
    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setThrower(Object thrower) {
        this.thrower = thrower;
    }

    /**
     * Makes one of the default implementations.
     *
     * TODO: this method should be rewritten to be more maintainable.
     */
    @Override
    public ExceptionInformation build()
    {
        if(this.throwable == null)//I deeply regret having to make this check.
        {
            return new NoThrowableExceptionInformation(this.message,
                    this.level, this.thrower);
        }
        else
        {
            return new FullExceptionInformation(this.message, this.level,
                    this.throwable, this.thrower);
        }
    }
}
