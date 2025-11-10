package org.example.java19;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.concurrent.*;

import static java.lang.foreign.ValueLayout.JAVA_INT;

public class Java19Enhancements {
    public static void main(String[] args) {
        //virtual threads
        try(ExecutorService executor= Executors.newVirtualThreadPerTaskExecutor()){
            for(int i=0;i<10;i++){
                int taskId=i;
                executor.submit(()->{
                    System.out.println("Running task "+taskId+" on "+Thread.currentThread());
                    Thread.sleep(1000);
                    return taskId;
                });
            }
        }

        //structured concurrency
        try(var scope= new StructuredTaskScope.ShutdownOnFailure()){
            Future<String> user=scope.fork(()->fetchUserData()).get();
            Future<String> orders=scope.fork(()->fetchUserData()).get();

            scope.join();
            scope.throwIfFailed();
            System.out.println(user.resultNow()+" "+orders.resultNow());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Foreign Memory API
        try(Arena arena=Arena.ofConfined()){
            MemorySegment memorySegment=arena.allocate(JAVA_INT);
            memorySegment.set(JAVA_INT,0,42);
            System.out.println(memorySegment.get(JAVA_INT,0));
        }
    }

    static Future<String> fetchUserData(){
            return CompletableFuture.failedFuture(new Throwable("error"));
    }
}
