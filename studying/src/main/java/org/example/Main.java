package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // Comparing and Comparable
//        List<Employee> l = Arrays.asList(new Employee(2, "Mohamed"), new Employee(0, "Yassin"));
//        Comparator<Employee> comp = Comparator.comparing(Employee::getName);
//        l.sort(comp);

        ExecutorServices ex = new ExecutorServices();
        ex.FutureInterface();

    }
}