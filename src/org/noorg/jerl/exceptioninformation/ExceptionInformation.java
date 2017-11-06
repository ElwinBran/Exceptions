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
 * Tries to provide all information on an exception.
 * 
 * @author Elwin Slokker
 */
public interface ExceptionInformation
{
    /**
     * @return A string that explains what went wrong.
     * <br>(the unexpected situation).
     */
    public String getMessage();
    /**
     * @return An indication of how bad the exception is.
     */
    public Level getLevel();
    
    /**
     * Indicates whether {@see #getOriginalThrowable} returns a real value or
     * <br> <code>null</code>.
     * @return 
     */
    public boolean hasThrowable();
    
    /**
     * @return The {@see Throwable} that was caught in the method that returned 
     * <br>this object.
     */
    public Throwable getOriginalThrowable();
    
    /**
     * @return The object that made this exception.
     * <br>Can be used to determine class, for instance.
     */
    public Object getThrower();

}