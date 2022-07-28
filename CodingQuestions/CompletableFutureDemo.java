package CodingQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //CompletableFuture f1 = new CompletableFutureDemo();

        CompletableFuture<List> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            List<String> l = new ArrayList<>();
            l.add("yes im in");
            return l;
        });
       // System.out.println(future.get().get(0));

        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

// Attach a callback to the Future using thenApply()
        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
            return "Hello " + name;
        });

        System.out.println("MAin thread is waiting");
// Block and get the result of the future.
        System.out.println(greetingFuture.get()); // Hello Rajeev

        //System.out.println(future.get());
    }


}

