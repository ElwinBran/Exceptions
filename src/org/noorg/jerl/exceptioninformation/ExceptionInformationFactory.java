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
 * A singleton factory that constructs {@see ExceptionInformation} objects.
 *
 * @author Elwin Slokker
 * @deprecated this is not a factory but a constructor.
 * It is not very maintainable at all.
 */
@Deprecated
public class ExceptionInformationFactory
{
    private static final ExceptionInformationFactory INSTANCE = new ExceptionInformationFactory();

    ExceptionInformationFactory()
    {

    }

    /**
     * @return
     */
    public static ExceptionInformationFactory getInstance()
    {
        return INSTANCE;
    }

    /**
     * TODO certainly has to be replaced
     * @param message
     * @param level
     * @param throwable
     * @param thrower
     * @return
     */
    public ExceptionInformation makeInformation(final String message,
            final Level level,  final Throwable throwable, final Object thrower)
    {
        return new FullExceptionInformation(message, level, throwable, thrower);
    }

    /**
     * TODO certainly has to be replaced
     * @param message
     * @param level
     * @param thrower
     * @return
     */
    public ExceptionInformation makeInformation(final String message,
                                    final Level level, final Object thrower)
    {
        return new NoThrowableExceptionInformation(message, level, thrower);
    }
}
