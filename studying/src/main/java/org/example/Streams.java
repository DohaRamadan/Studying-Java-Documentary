package org.example;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

    public void terminalMethods(){
        // .count
        // .min .max
            // takes a comparator(lambda)
            // return Optional<T>
        // .findAny findFirst
            // return Optional<T>
        // .collect
        // .reduce
        // .anyMatch .allMath .noneMath
            // takes a predicate
            // returns a boolean
        // forEach
    }

    // Intermediate operations get elements one-by-one and process them.
    public void intermediateOperations(){
        // .peek  method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline
        Stream.of("Alex", "Joeeeeeee", "Joeeeeeee", "Alan")
                .peek(name -> System.out.println("peek " + name))
                .filter(name -> name.length() > 4)
                .distinct()
                .limit(2)
                .forEach(name -> System.out.println("forEach " + name));

        // map takes an element and converts to an element based on the function
        Stream.of("Alex", "Joeeeeeee", "Joeeeeeee", "Alan")
                .map(String::length)
                .forEach(System.out::println);

        // sorted is stateful, it needs to see all the elements before it can sort it
        Stream.of(1, 5, 6, 4, 2, 7)
                .sorted()
                .forEach(System.out::print);
    }

    public void primitiveStreams(){
        // Int Stream for primitive type int, short, byte, and char
        IntStream st1 = IntStream.of(1, 2, 3, 4);

        // Double Stream for primitive type double, float
        DoubleStream st2 = DoubleStream.of(1.0, 2.0, 3.0, 4.0);

        // Long stream for primitive type long
        LongStream st3 = LongStream.of(1L, 2L, 3L, 4L);
    }

    public void primitiveStreamsMapping(){
        Stream.of("ash", "beech", "sycamore")
                .map(String::toLowerCase)
                .forEach(System.out::println);

        DoubleStream dblStream = Stream.of("ash", "beech", "sycamore")
                .mapToDouble(String::length);

        IntStream intStream = Stream.of("ash", "beech", "sycamore")
                .mapToInt(String::length);

        LongStream longStream = Stream.of("ash", "beech", "sycamore")
                                      .mapToLong(String::length);

        Stream<String> stringStream = IntStream.of(1, 2, 3)
                .mapToObj(n -> "Number " + n);
        stringStream.forEach(System.out::println);
    }
}
