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

import java.util.Collection;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO I am well aware the "SafeReturnConstructor" and
 * "GenericReturnConstructor" are much alike as are their tests.
 * They were made sloppy because the library will likely not change much in my
 * current vision. Upcoming releases will feature better tests, when I have
 * learned more about them.
 */
class GenericExceptionReturnableTest {

    private static final Integer RETURN_VALUE = 22;//simply a lucky number
    private static final String FIRST_E_VALUE = "This is a test.";
    private static final String SECOND_E_VALUE = "This was a test.";

    private ExceptionReturnable<String, Integer> warning;
    private ExceptionReturnable<String, Integer> exception;
    private ExceptionReturnable<String, Integer> normal;
    final private GenericReturnConstructor<String, Integer> constructor =
            new GenericReturnConstructor<>();
    //private ExceptionReturnable<String, Integer> empty;


    @BeforeEach
    void setUp()
    {
        warning = constructor.construct(RETURN_VALUE, FIRST_E_VALUE,SECOND_E_VALUE);
        exception = constructor.construct(FIRST_E_VALUE);
        normal = constructor.construct(RETURN_VALUE);
    }

    @AfterEach
    void tearDown() {
        this.exception = null;
        this.warning = null;
        this.normal = null;
    }

    @Test
    void warningHasCorrectWarnings()
    {
        assertEquals(warning.getExceptions().size(), 2);
    }

    @Test
    void warningHasReturnValue()
    {
        if(warning.hasReturnValue())
        {
            assertEquals(warning.getReturn(), RETURN_VALUE);
        }
        else
        {
            fail("Warning must have return value.");
        }
    }

    @Test
    void normalHasNoException()
    {
        assertEquals(normal.getExceptions().isEmpty(), true);
    }

    @Test
    void normalHasReturnValue()
    {
        if(normal.hasReturnValue())
        {
            assertEquals(normal.getReturn(), RETURN_VALUE);
        }
        else
        {
            fail("Normal must have return value.");
        }
    }

    @Test
    void exceptionHasException()
    {
        assertEquals(exception.getExceptions().contains(FIRST_E_VALUE), true);
    }

    @Test
    void exceptionDoesNotReturnValue()
    {
        assertEquals(exception.hasReturnValue(), false);
    }

    /*
    All kinds of null testing. This library may never throw a
    NullPointerException. That would make it depend on itself to wrap them.
    It also ensures that the user is more carefull with null, because his code
    will break, instead of the library.
     */

    @Test
    void nullTestNormalReturn()
    {
        ExceptionReturnable<String, Integer> nullReturn =
                constructor.construct((Integer)null);
        if(nullReturn.hasReturnValue())
        {
            assertEquals(nullReturn.getReturn(), null);
        }
        else
        {
            fail("When passing a null to an exceptionReturnable value, it" +
                    " should accept it and state there is a value.");
        }
    }

    @Test
    void nullTestExceptionReturn()
    {
        ExceptionReturnable<String, Integer> nullReturn = constructor.construct(
                (Collection<String>) null);
        assertEquals(nullReturn.getExceptions(), null);
        //fail("When passing a null to an exceptionReturnable information, it" +
        //" should accept it and state there is a value.");

    }

    /**
     * Special case, when one of the two (exceptions and return value)
     * are null, the null is ignored and becomes the return kind that was not
     * passed as null. This is strange behaviour, but it should take this
     * responsibility away from the code, because now there is a centralized
     * place to test it.
     *
     * In this case, hasReturnValue should return false.
     */
    @Test
    void nullReturnValueConstructsException()
    {
        ExceptionReturnable<String, Integer> nullReturn = constructor.construct(
                (Integer) null, FIRST_E_VALUE, SECOND_E_VALUE);
        assertEquals(nullReturn.hasReturnValue(), false);
    }

    /**
     * Special case, when one of the two (exceptions and return value)
     * are null, the null is ignored and becomes the return kind that was not
     * passed as null. This is strange behaviour, but it should take this
     * responsibility away from the code, because now there is a centralized
     * place to test it.
     *
     * In this case, the exceptions that are null should be turned into an empty
     * list.
     */
    @Test
    void nullExceptionConstructsNormal()
    {
        ExceptionReturnable<String, Integer> nullReturn = constructor.construct(
                RETURN_VALUE,(Collection<String>)null);
        try
        {
            assertEquals(nullReturn.getExceptions().isEmpty(), true);
        }
        catch(NullPointerException npe)
        {
            fail("getExceptions() should have returned a non-null value.");
        }

    }

    @Test
    void doubleNullWarning()
    {
        ExceptionReturnable<String, Integer> nullReturn = constructor.construct(
                (Integer)null, (Collection<String>) null);
        //should just return a SafeReturn, but has only null values.
        if(nullReturn.hasReturnValue())
        {
            assertEquals(nullReturn.getReturn(), null);
        }
        else
        {
            fail("When passing a null to an exceptionReturnable value, it" +
                    " should accept it and state there is a value.");
        }
        assertEquals(nullReturn.getExceptions(), null);
    }
}