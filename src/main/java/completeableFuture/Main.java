package completeableFuture;

import java.util.concurrent.*;

public class Main {
    static ExecutorService executorService = Executors.newFixedThreadPool(16);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        method1();
//        completableFuture();
//        completableFutureAsync();
        String register = register();
        System.out.println(register);

    }

    private static String register() throws InterruptedException {
        CompletableFuture.runAsync(() -> {
            System.out.println("Starting save to db");
            try {
                saveDB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished save to db");
        }, executorService);
        CompletableFuture.runAsync(() -> {
            System.out.println("Sending email");
            try {
                sendEmail();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Sent email");
        }, executorService);
        return "Check your email";
    }

    private static void sendEmail() throws InterruptedException {
        Thread.sleep(3000);
    }

    private static void saveDB() throws InterruptedException {
        Thread.sleep(1500);
    }

    private static void completableFutureAsync() {
        CompletableFuture<String> nameCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Elshod";
        }, executorService);

        CompletableFuture<String> fullNameCompletableFuture = nameCompletableFuture
                .thenApplyAsync(name -> {
                    System.out.println(Thread.currentThread());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(name);
                    return "Nuriddinov " + name;
                }, executorService);

        CompletableFuture<String> nullCompletableFuture = fullNameCompletableFuture
                .thenApply(fullName -> {
                    System.out.println(Thread.currentThread());
                    System.out.println(fullName);
                    return null;
                });
        nullCompletableFuture.thenRun(() -> System.out.println("Ending completable future"));
    }

    private static void completableFuture() {
        CompletableFuture<String> nameCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Elshod";
        }, executorService);

        CompletableFuture<String> fullNameCompletableFuture = nameCompletableFuture
                .thenApply(name -> {
                    System.out.println(Thread.currentThread());
                    System.out.println(name);
                    return "Nuriddinov " + name;
                });

        CompletableFuture<String> nullCompletableFuture = fullNameCompletableFuture
                .thenApply(fullName -> {
                    System.out.println(Thread.currentThread());
                    System.out.println(fullName);
                    return null;
                });
        nullCompletableFuture.thenRun(() -> System.out.println("Ending completable future"));
//        String name = completableFuture.get();
//        System.out.println(name);
    }

    private static void method1() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
                        System.out.println("Starting completablefuture :: " + Thread.currentThread());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Finished completablefuture :: " + Thread.currentThread());
                    }, executorService)
                    .thenRun(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        System.out.println("Then run method");
                    });
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " :: " + Thread.currentThread());
            Thread.sleep(100);
        }
    }
}
