1. It can be understood as a concise representation of an anonymous function that can be passed around.<br>


It doesn't have  a name, but it has list of parameters, a body , a return type and  also possible list of exceptions that can be thrown.

Lambda expression lets you pass the code concisely.

A functional interface is an interface that declares exactly one abstract method.

Lambda expressions can be used only where a functional interface is expected.



Functional Interface 

@FunctionalInterface :  This annotation is used to indicate that the interface is intended to be a functional interface

The compiler will return a meaningful error if you define an interface using the @FunctionalInterface annotation and it isn’t a functional interface

@FunctionalInterface annotation isn’t mandatory, but it’s good practice to use it when an interface is designed for that purpose

1. The java.util.function.Predicate<T> interface defines an abstract method named test that accepts an object of generic type T and returns a boolean.

2. The java.util.function.Consumer<T> interface defines an abstract method named accept that takes an object of generic type T and returns no result (void).
3. The java.util.function.Function<T, R> interface defines an abstract method named apply that takes an object of generic type T as input and returns an object of generic type R.



#### Method references
Method references can be seen as shorthand for lambdas calling only a specific method. 
