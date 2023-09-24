Three kinds of method reference :
1. A method reference to a static method.
   Integer::parseInt
2. A method reference to an instance method by an arbitrary type
   String::length
3. A method reference to an instance method of an existing method
   suppose you have a local variable expensiveTransaction that holds an object of type Transaction, 
   which supports an instance method getValue; you can write expensiveTransaction::getValue




(args)       -> ClassName.staticMethod(args)    : ClassName:staticMethod
(arg0,rest)  -> arg0.instanceMethod(rest)       : ClassName:instanceMethod
(args)       -> expr.instanceMethod(args)       : expr::instanceMethod


