# java-exception-replacement-library
A system that could replace the standard java Exceptions.

<b>NOTICE/UPDATE</b>
This project is still being worked on. 
Although there is a full release from a while ago and seemed to be updated once in a while, it will be fully reverted and reset at one point. I have a local project that has the same goal as this one and even incorparates the UEI project into it as well.
This newer local project reflects my current views on OOP and OOD, which is also part of a library to completly overhaul Java.
You may use this library to your hearts content, but it will not be fully supported anymore.

Before using this though, please think carefully about it and contact me if you are looking for a more maintainable and WIP variant.

<b>In short the reasons for using this library instead of exceptions:</b>
<br>-Exceptions are like 'goto'. 
<br>-Checked Exceptions are not a maintainble solution. Method signatures can grow very big and when implementation changes and there is a change in thrown exceptions, all calling code need to change.
<br>-Checked exceptions also complicate the language with their try()...catch() and throws ... declaration.
<br>-Exceptions are not able to handle multiple exceptions. There are enough cases where the thrower might be able to identify more than a single exceptions and may feel the need to throw multiple exceptions. This is impossible by default.
<br>-Exceptions encourage casting, which can cause exceptions.
<br>-Regular exceptions might not be able to carry enough information to be useful to a user.

<b>How to use this library:</b><br>
First off, do not try to replace Errors and RuntimeException. Both can still be used, as long as they never or very rarely show up in the actual product. Exceptions like NPE and ArrayIndexOutOfBoundsException should simply never happen outside of development and when found, prevention is the only solution.
What remains are the Checked Exceptions. The second thing to do when using this library, is never declare a Checked Exception anywhere.
All sources of Checked Exceptions should be from code you did not make, like Java IO and most libraries. Whenever you call a method that throws one or more Checked Exceptions, wrap it and change the return type to the Exception Return object from this library.
The last part is really the gist of it. Obviously this leads to more libraries that wrap existing method with what I like to call
"Unthrowing Methods/Classes". The "Unthrowing" is usually a fair amount of work, but once in place it becomes easily changeable and reusable.

<b>Motivation</b><br>
As stated before, Throwables are a variation on 'goto'. This is because Throwables do not exit a method normally. The rest of the method is skipped completely and this also happens in calling methods that do not catch the Throwable. The syntax seperates this 'code jump' and makes it quite obvious. But that does not excuse them for being external flow control. 
The syntax is necessarily quite verbose, just as this library requires a few calls. But the real problem with normal Exception syntax is the introduction of new keywords. 
Then there is the problem of needing the Subclasses of Exception. As pointed out before this encourages casting and high coupling. This is unacceptable for maintainable code, especially when seeing the occurences of Exceptions. This library strives to include exactly enough information in the replacement. As of this moment that is the most broken part of the library. Multiple messages in an Exception are not even supported.

Let us take an example and see why this library has a practical use. When getting an object from an DAO and some IOException occured, one could:
<br>&emsp;1) return null, which usually leads to a lot of null-checks in the code and NPE's showing up.
<br>&emsp;2) 'return' an exception, bringing along all undesirable side-effects mentioned earlier.
<br>&emsp;3) use the Null Object pattern to work around the null (https://www.tutorialspoint.com/design_pattern/null_object_pattern.htm). Which unfortunately cannot tell us what went wrong or we would have to bloat the interface.
<br>&emsp;4) use this library to return an object that carries the desired object and/or an exception message. It does not break normal program flow, provides enough information and does not cause exceptions (and if it does, the programmer did something wrong).

<b>See also:</b><br>
- This library was inspired by https://www.atlassian.com/blog/archives/exceptions_are_bad and most credit goes to the writer of the article, Jed Wesley-Smith.
The original article said the 'Either object' is disjoint, but that is not the case in this implementation.
There is also a 'warning' implementation that returns both the normal return value and the exception message.

- This article https://blogs.msdn.microsoft.com/ericlippert/2008/09/10/vexing-exceptions/ list four kinds of exceptions in code.
(fatal, boneheaded, vexing and exogenous) This helped me understand what exactly I was doing with replacing exceptions.

- A plea for abolishing unchecked exceptions and start using only the Exception class: http://www.yegor256.com/2015/07/28/checked-vs-unchecked-exceptions.html
His first idea is that subclassing Exception is weird/bad because the exception needs to carry enough information to identify what went wrong. He proposes a sort of SmartException that does carry/knows enough about every case of exception.
The second idea is making everything a checked exception.

<b>License</b><br>
All source code MIT Licensed.
