package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServices {

    public static void differentMethods(){
        // create threads as needed and kill them as you go
        ExecutorService ex = Executors.newCachedThreadPool();

        // create single thread
        ExecutorService ex2 = Executors.newSingleThreadExecutor();

        // create a fixed number of threads
        ExecutorService ex3 = Executors.newFixedThreadPool(10);
    }

    public static void FutureInterface() throws InterruptedException, TimeoutException {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Future<String> f = ex.submit(() -> "Im a string");
        try{
            System.out.println(f.get(200, TimeUnit.MILLISECONDS));
        }catch (InterruptedException | ExecutionException | TimeoutException e){
            System.out.println("Method took longer than expected");
        }
        // we need to shut it down because it won't shut down on its own
        ex.shutdown();
    }



}
