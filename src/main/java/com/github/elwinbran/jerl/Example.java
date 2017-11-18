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

import com.github.elwinbran.uei.BaseExceptions;
import com.github.elwinbran.uei.ExceptionInformation;
import com.github.elwinbran.uei.ExceptionInformationBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;

/**
 * A simple runnable example on how to use JERL.
 * 
 * @author Elwin Slokker
 */
public final class Example
{
    public static void main(String[] args)
    {
        System.out.println("Default exception system:");
        ExceptionReturnable<Integer, String> possibleDefHelloWorld = makeDefHelloWorld();
        //check if there is a return value
        if(possibleDefHelloWorld.hasReturnValue())
        {
            //do something with the return value.
            System.out.println(possibleDefHelloWorld.getReturn());
        }
        possibleDefHelloWorld = makeDefFailing();
        if(possibleDefHelloWorld.hasReturnValue())
        {

        }
        else
        {//there are must be exceptions!
            System.out.println("Loop through exception codes");
            for(Integer exInfo : possibleDefHelloWorld.getExceptions())
            {
                System.out.println(exInfo);
            }
        }
        System.out.println("UEI exceptions:");
        SafeReturn<String> possibleHelloWorld = makeHelloWorld();
        //check if there is a return value
        if(possibleHelloWorld.hasReturnValue())
        {
            //do something with the return value.
            System.out.println(possibleHelloWorld.getReturn());
        }
        possibleHelloWorld = makeWrappingFailing();
        if(possibleHelloWorld.hasReturnValue())
        {

        }
        else
        {//there are must be exceptions!
            System.out.println("Loop through exceptions");
            for(ExceptionInformation exInfo : possibleHelloWorld.getExceptions())
            {
                System.out.println(exInfo);
            }
        }
    }

    private static SafeReturn<String> makeHelloWorld()
    {
        //simply call constructor object and insert return value.
        return new SafeReturnConstructor<String>().construct("Hello world!");
    }
    private static SafeReturn<String> makeWrappingFailing()
    {
        String welp = "wellp";
        return makeFailing();
    }

    private static SafeReturn<String> makeFailing()
    {
        ExceptionInformationBuilder builder =
                ExceptionInformationBuilder.newBuilder();
        builder.setMessage("Hello world could not be made.");
        builder.setThrower(new Object(){private String text = "I am the thrower";});
        builder.setLevel(Level.OFF);
        builder.setType(BaseExceptions.ILLEGAL_ACCESS);
        try
        {
            throwSomething();
        }
        catch(Exception ex)
        {
            
            builder.setThrowable(ex);
        }
        Collection<ExceptionInformation> errors = new ArrayList<>(1);
        errors.add(builder.build());
        return new SafeReturnConstructor<String>().construct(errors);
    }
    
    private static ExceptionReturnable<Integer, String> makeDefHelloWorld()
    {
        //simply call constructor object and insert return value.
        return new GenericReturnConstructor<Integer, String>().construct("Hello world!");
    }

    private static ExceptionReturnable<Integer, String> makeDefFailing()
    {
        Integer[] errorCodes = new Integer[]{2,11};
        return new GenericReturnConstructor<Integer, String>().construct(Arrays.asList(errorCodes));
    }
    
    private static void throwSomething() throws Exception
    {
        throwSomethingElse();
    }
    
    private static void throwSomethingElse() throws Exception
    {
        throw new IndexOutOfBoundsException("what");
    }
}