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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noorg.jerl.exceptioninformation.ExceptionInformation;
import org.noorg.jerl.exceptioninformation.ExceptionInformationBuilder;
import org.noorg.jerl.exceptioninformation.ExceptionInformationFactory;

import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionInformationTest
{
    private static final String EXCEPTION_DESCRIPTION = "This is a test";

    private Throwable original = new IOException(EXCEPTION_DESCRIPTION);
    private ExceptionInformation full;
    private ExceptionInformation noThrowable;

    @BeforeEach
    void setUp()
    {
        final ExceptionInformationBuilder builder = ExceptionInformationBuilder.newBuilder();
        builder.setMessage(EXCEPTION_DESCRIPTION);
        builder.setLevel(Level.OFF);
        builder.setThrower(this);
        noThrowable = builder.build();
        builder.setThrowable(original);
        full = builder.build();
    }

    @AfterEach
    void tearDown()
    {
        this.original = null;
        this.full = null;
        this.noThrowable = null;
    }

    @Test
    void fullExceptionHasDescription()
    {
        assertEquals(this.full.getMessage(), EXCEPTION_DESCRIPTION);
    }

    @Test
    void noThrowableExceptionHasDescription()
    {
        assertEquals(this.noThrowable.getMessage(), EXCEPTION_DESCRIPTION);
    }

    @Test
    void fullExceptionShouldHaveThrowable()
    {
        assertEquals(this.full.hasThrowable(), true);
        assertEquals(this.full.getOriginalThrowable(), this.original);
    }

    @Test
    void noThrowableExceptionShouldNotHaveThrowable()
    {
        assertEquals(this.noThrowable.hasThrowable(), false);
        assertEquals(this.noThrowable.getOriginalThrowable(), null);
    }

}