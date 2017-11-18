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

import com.github.elwinbran.uei.ExceptionInformation;

/**
 * Wraps return values from methods that might encounter exceptions.
 * <br><br>
 * This class is simply a less verbose version of {@see ExceptionReturnable}.
 * <br>It becomes less verbose by predefining the exception information type as
 * {@see ExceptionInformation}, which is provided by this library.
 * <br>
 * <br>It is called 'Safe' because that would be the best alternative name for
 * <br> ExceptionReturnable. It would never throw an exception (instead gives
 * <br>information about them) and is thus 'safe'.
 *
 * @author Elwin Slokker
 */
public abstract class SafeReturn<R extends Object>
        implements ExceptionReturnable<ExceptionInformation, R> { }
