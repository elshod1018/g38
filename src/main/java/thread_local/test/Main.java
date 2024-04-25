package thread_local.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
    static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("ddMMyyyy"));

    public static void main(String[] args) {
//        simpleDateFormatterExample();
        Random random = new Random();
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 1000; i++) {
                executorService.execute(() -> System.out.println(random.nextInt(10, 100)));
            }
        } catch (Exception e) {
        }
    }

    private static void simpleDateFormatterExample() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 1000; i++) {
                executorService.execute(() -> {
                    try {
                        System.out.println(simpleDateFormatThreadLocal.get().parse("01012001"));
                    } catch (ParseException ignored) {
                    }
                });
            }
        } catch (Exception e) {
        }
    }
}
