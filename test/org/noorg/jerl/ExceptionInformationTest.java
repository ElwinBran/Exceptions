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