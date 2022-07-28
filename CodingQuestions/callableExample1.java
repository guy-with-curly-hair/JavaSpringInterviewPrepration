package CodingQuestions;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;


public class callableExample1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c1 = () -> {
            Thread.sleep(10000);
            System.out.println(" running 1st callable ");
            return "Hi";
        };

        Callable<Integer> c2 = () ->
        {
            int random = new Random(10).nextInt();
            return random;
        };

        FutureTask<String> f2 = new FutureTask<String>(c1);
        f2.run();

        ExecutorService x = Executors.newFixedThreadPool(10);
        Future<Integer> f1 = x.submit(c2);
         x.submit(f2);



        System.out.println(" task 2" + f2.get());
        System.out.println(" task 2" + f2.get());
        x.shutdownNow();
    }

}

