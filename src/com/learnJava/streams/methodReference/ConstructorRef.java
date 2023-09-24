package com.learnJava.streams.methodReference;

import com.learnJava.streams.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
@FunctionalInterface
interface FiveConstructorFunction<A,B,C,D,E,R>{
    R apply(A a,B b,C c,D d, E e);
}
class Box
{
    int a,b,c,d,e;

    public Box(int a, int b, int c, int d, int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public String toString() {
        return "Box{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                '}';
    }
}
public class ConstructorRef {


    public static void main(String[] args) {
        Supplier<Apple> s1=Apple::new;
        Apple a1=s1.get();


        Supplier<Apple> s2=()->new Apple();
        Apple a2=s2.get();


        Function<Integer,Apple> s3=Apple::new;
        Apple a3=s3.apply(110);


        Function<Integer,Apple> s4=(weight) -> new Apple(weight);
        Apple a4=s4.apply(220);


        List<Integer> weights= Arrays.asList(7,3,4,10);
        List<Apple> apples=map(weights,Apple::new);


        // Two argument Constructor :

        BiFunction<String,Integer,Apple> s5=Apple::new;
        Apple a5=s5.apply("Green",110);


        BiFunction<String, Integer,Apple> s6= (color,weight) -> new Apple(color,weight);
        Apple a6=s6.apply("Green",80);




        // customer functional interface to accept 5 arguments

        FiveConstructorFunction<Integer,Integer,Integer,Integer,Integer,Box> bx=Box::new;
        Box b1=bx.apply(1,2,3,4,5);
        System.out.println(b1);




    }
    public static List<Apple> map(List<Integer> list, Function<Integer,Apple> fun)
    {
        List<Apple> result=new ArrayList<>();
        for(Integer e:list)
        {
            result.add(fun.apply(e));
        }
        return result;
    }

}
