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
 * Simple exception information provider that will not lack information.
 * 
 * @author Elwin Slokker
 */
public class FullExceptionInformation extends BaseExceptionInformation
{
    private final Throwable original;

    /**
     * This constructor initialises simply all fields.
     * 
     * @param message Information about the exception.
     * @param level The severity of the exception.
     * @param throwable The {@see Throwable} that was caught and caused this 
     * <br>exception message to be made.
     * @param thrower The object that made this information.
     */
    protected FullExceptionInformation(final String message, final Level level,
            final Throwable throwable, final Object thrower)
    {
        super(message, level, thrower);
        this.original = throwable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Throwable getOriginalThrowable()
    {
        return this.original;
    }


    @Override
    public boolean hasThrowable() {
        return true;
    }
}