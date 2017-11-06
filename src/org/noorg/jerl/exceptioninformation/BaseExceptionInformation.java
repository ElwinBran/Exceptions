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

import org.noorg.jerl.exceptioninformation.ExceptionInformation;

import java.util.logging.Level;

/**
 * Serves as the base for exception information to prevent duplicate code.
 *
 * @author Elwin Slokker
 */
public abstract class BaseExceptionInformation implements ExceptionInformation
{
    private final String message;
    private final Level level;
    private final Object thrower;

    protected BaseExceptionInformation(final String message, final Level level,
                                       final Object thrower) {
        this.message = message;
        this.level = level;
        this.thrower = thrower;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage()
    {
        return this.message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevel()
    {
        return this.level;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object getThrower()
    {
        return this.thrower;
    }


}
