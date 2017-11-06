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
 * Should be used to make/create instances of {@see ExceptionInformation}.
 * <br><br>
 * Call {@link #newBuilder} to get a generic builder.
 *
 * @author Elwin Slokker
 */
public interface ExceptionInformationBuilder
{
    /**
     * @return Creates a builder implementation capable of building the
     * information objects.
     */
    public static ExceptionInformationBuilder newBuilder()
    {return new ExceptionInformationBuilderGeneric();}

    /**
     * Set the information message.
     *
     * @param message the message you want to pass to the user.
     */
    public void setMessage(final String message);

    /**
     * Set the exception severity.
     *
     * @param level the level or severity of the exception.
     */
    public void setLevel(final Level level);

    /**
     * Optional setter.
     *
     * @param throwable the caught exception.
     */
    public void setThrowable(final Throwable throwable);

    /**
     * Set the object that encountered the exception.
     *
     * @param thrower
     */
    public void setThrower(final Object thrower);

    /**
     * Makes/creates an {@see ExceptionInformation} from provided information.
     *
     * @return an approriate implementation of {@see ExceptionInformation}.
     */
    public ExceptionInformation build();

    /**
     * Small utility method to make a standard formatted message.
     *
     * @param threadName name of the thread where the exception occurred
     * @param exception description of the exception. Something like
     *                  "index out of bounds: length: 4 index: 8".
     * @param exceptionLocation preferably class and row number.
     *                          Otherwise at least class. May also include
     *                          method name. <br> Examples "theClass.method",
     *                          "theClass on row 56", "theClass in method"
     * @return A formatted string preferably to be used in
     * {@link #setMessage(String)}.
     */
    public default String makeMessage(String threadName, String exception,
                                      String exceptionLocation)
    {
        StringBuilder builder = new StringBuilder("Exception in thread \"");
        builder.append(threadName);
        builder.append("\"");
        builder.append(exception);
        builder.append("\nat");
        builder.append(exceptionLocation);
        return builder.toString();
    }
}
