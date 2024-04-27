package completeableFuture.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
     /*   CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Completed completable future");
        System.out.println(completableFuture.get());*/
        ExecutorService executorService = Executors.newFixedThreadPool(12);

      /*  CompletableFuture.runAsync(() -> {
            System.out.println("Running thread :: " + Thread.currentThread());
            System.out.println("Hello from run async");
        }, executorService);*/

       /* register();
        String returned = returnMessage();
        System.out.println(returned);
        for (int i = 0; i < 10; i++) {
            System.out.println("MSG :: " + i);
        }*/

        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Completable future returned result";
        });
        System.out.println(completableFuture.get());
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    private static String returnMessage() throws InterruptedException {
        Thread.sleep(1000);
        return "CHeck your email";
    }

    private static void register() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture.runAsync(() -> {
            System.out.println("User is saving to database :: " + Thread.currentThread());
            try {
                saveUser();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("User saved :: " + Thread.currentThread());
        }, executorService);
        CompletableFuture.runAsync(() -> {
            System.out.println("Email sending to email :: " + Thread.currentThread());
            try {
                sendEmail();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Email sent :: " + Thread.currentThread());
        }, executorService);
    }

    private static void sendEmail() throws InterruptedException {
        Thread.sleep(3000);
    }

    private static void saveUser() throws InterruptedException {
        Thread.sleep(2000);
    }
}
