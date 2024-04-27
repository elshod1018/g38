package thread_local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        withThreadLocal();
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        //thread-5 -> new Simp() for 6
        // thread-6 -> new Simp() for 6
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    Date parse = simpleDateFormat.parse("01012024");
                    System.out.println(System.identityHashCode(simpleDateFormat) + " -> " + parse + " -> " + Thread.currentThread());
                } catch (ParseException e) {

                }
            });
        }
    }

    private static void withThreadLocal() {
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        //thread-5 -> new Simp() for 6
        // thread-6 -> new Simp() for 6
        ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("ddMMyyyy"));
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    SimpleDateFormat simpleDateFormat = simpleDateFormatThreadLocal.get();
                    Date parse = simpleDateFormat.parse("01012024");
                    System.out.println(System.identityHashCode(simpleDateFormat) + " -> " + parse + " -> " + Thread.currentThread());

                } catch (ParseException e) {

                }
            });
        }
    }
}
