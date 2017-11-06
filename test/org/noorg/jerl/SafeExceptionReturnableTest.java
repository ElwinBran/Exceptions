package org.noorg.jerl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noorg.jerl.exceptioninformation.ExceptionInformation;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SafeExceptionReturnableTest
{
    private static final String TEST_TEXT = "This is a test.";
    private static final Integer RETURN_VALUE = 22;//simply a lucky number

    private SafeReturn<Integer> warning;
    private SafeReturn<Integer> exception;
    private SafeReturn<Integer> normal;
    private ExceptionInformation mock = new ExceptionInformation() {
        @Override
        public String getMessage() {
            return "";
        }

        @Override
        public Level getLevel() {
            return Level.OFF;
        }

        @Override
        public boolean hasThrowable() {
            return false;
        }

        @Override
        public Throwable getOriginalThrowable() {
            return null;
        }

        @Override
        public Object getThrower() {
            return null;
        }
    };
    private ExceptionInformation toMock = new ExceptionInformation() {
        @Override
        public String getMessage() {
            return "second mock";
        }

        @Override
        public Level getLevel() {
            return Level.OFF;
        }

        @Override
        public boolean hasThrowable() {
            return false;
        }

        @Override
        public Throwable getOriginalThrowable() {
            return null;
        }

        @Override
        public Object getThrower() {
            return null;
        }
    };


    @BeforeEach
    void setUp()
    {
        final SafeReturnConstructor<Integer> constructor =
                new SafeReturnConstructor<>();
        warning = constructor.construct(RETURN_VALUE, mock, toMock);
        exception = constructor.construct(mock);
        normal = constructor.construct(RETURN_VALUE);
    }

    @AfterEach
    void tearDown()
    {
        this.exception = null;
        this.warning = null;
        this.normal = null;
        this.mock = null;
        this.toMock = null;
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
        assertEquals(exception.getExceptions().contains(mock), true);
    }

    @Test
    void exceptionDoesNotReturnValue()
    {
        assertEquals(exception.hasReturnValue(), false);
    }

}