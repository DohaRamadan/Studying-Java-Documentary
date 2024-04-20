package org.example;

import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
    interface Evaluate<T> {
        boolean test(T t);
    }

    interface Evaluate2<T, U> {
        boolean test(T t, U u);
    }

    public void lambdas(){
        // these two are the same
        Evaluate<Integer> inst = n -> n > 0;
        Predicate<Integer> inst2 = n -> n > 0;
        System.out.println(inst.test(10) + " " + inst2.test(10));

        // these two are the same
        // we call it ins.test(str, n);
        Evaluate2<String, Integer> ins = (str , n) -> str.length() == n;
        BiPredicate<String, Integer> ins2 = (str, n) -> str.length() == n;
        System.out.println(ins.test("Mohamed", 3) + " " + ins2.test("Mohamed", 3));

        // for getting an object
        Supplier<Double> getRand = Math::random;
        Supplier<LocalTime> getTime = LocalTime::now;
        System.out.println(getRand.get());

        // takes first argument and returns last argument
        Function<String, Integer> function = String::length;
        BiFunction<String, String, Integer> function1 = (str, str1) -> str.length() + str1.length();

        // UnaryOperator and BinaryOperator are the same as
        // Function and BiFunction except that the parameter type and the argument type are the same.
    }
}
