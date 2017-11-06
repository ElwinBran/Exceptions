package org.noorg.jerl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noorg.jerl.exceptioninformation.ExceptionInformation;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class GenericExceptionReturnableTest {

    private static final Integer RETURN_VALUE = 22;//simply a lucky number
    private static final String FIRST_E_VALUE = "This is a test.";
    private static final String SECOND_E_VALUE = "This was a test.";

    private ExceptionReturnable<String, Integer> warning;
    private ExceptionReturnable<String, Integer> exception;
    private ExceptionReturnable<String, Integer> normal;
    //private ExceptionReturnable<String, Integer> empty;


    @BeforeEach
    void setUp()
    {
        final GenericReturnConstructor<String, Integer> constructor =
                new GenericReturnConstructor<>();
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

}