package org.example;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Optionals {

    public void optionals(){
        Optional<Double> opt1 = Optional.of(DoubleStream.of(1.0, 2, 3)
                                                        .sum());
        opt1.ifPresent(num -> System.out.println("Number Present " + num));
        System.out.println(opt1.orElse(Math.random()));
    }

    public Optional<String> howtoDealWithNull(String param){
        // this equates to return  param == null ? Optional.empty() : param
        return Optional.ofNullable(param);
    }

}
