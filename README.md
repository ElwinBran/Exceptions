# java-exception-replacement-library
A system that could replace the standard java Exceptions.

This library was inspired by https://www.atlassian.com/blog/archives/exceptions_are_bad and most credit goes to the writer of the article, Jed Wesley-Smith.
The original article said the 'Either object' is disjoint, but that is not the case in this implementation.
There is also a 'warning' implementation that returns both the normal return value and the exception message.

This library is aiming to replaced checked exceptions. By replacing (most) checked exceptions, your code will get easier to read and change. When getting an object from an DAO and some IOException occured, you could:
<br>&emsp;1) return null
<br>&emsp;2) 'return' an exception, that means that all callers need to have catching, which is not only harder to read, it can also cause duplicate code.
<br>&emsp;3) use the Null Object pattern to work around the null (https://www.tutorialspoint.com/design_pattern/null_object_pattern.htm)
<br>&emsp;4) use this library to return an object that carries the desired object and/or an exception message.
<br>You could be thinking 'Null Objects don not exsist for nothing', I agree and they are probably useful for other cases. But a Null Object cannot tell you why it was created. Of course one could implement a 'getException' for the Null Object but this will either be a useless method for the superclass or be very clunky.

This article https://blogs.msdn.microsoft.com/ericlippert/2008/09/10/vexing-exceptions/ list four kinds of exceptions in code.
This library should be used for 'vexing' and 'exogenous' exceptions. Using it for other exceptions would be counter-productive.
