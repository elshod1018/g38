package completeableFuture.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenApplyExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Elshod";
        }, executorService);

        CompletableFuture<String> fullNameCompletableFuture = completableFuture.thenApply((name) -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Nuriddinov " + name;
        });

        CompletableFuture<Void> voidCompletableFuture = fullNameCompletableFuture.thenAccept((s) -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(s);
        });
        voidCompletableFuture.thenRun(() -> {
            System.out.println("Void comp future ... ");
        });

    }
}
