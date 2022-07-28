package CodingQuestions;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunExample3 {
  public static void main(String[] args) {
      ExecutorService executor = Executors.newFixedThreadPool(3);

      CompletableFuture.runAsync(() -> performTask("first stage"), executor)
                       .thenRun(() -> performTask("second stage"))
                       .thenRun(() -> performTask("third stage"));
                       //.join();//waits until task is completed
      System.out.println("main exiting starts ");

      CompletableFuture.runAsync(() -> performTask("Again first stage"), executor)
              .thenRun(() -> performTask("Again second stage"))
              .thenRunAsync(() -> performTask("Again third stage"), executor)
              .join();//waits until task is completed

      System.out.println("main exiting exited ");
      executor.shutdown();
  }

  private static void performTask(String stage) {
      System.out.println("---------");
      System.out.printf("stage: %s, time before task: %s, thread: %s%n",
              stage, LocalTime.now(), Thread.currentThread().getName());
      try {
          //simulating long task
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      System.out.printf("stage: %s, time after task: %s, thread: %s%n",
              stage, LocalTime.now(), Thread.currentThread().getName());
  }
}