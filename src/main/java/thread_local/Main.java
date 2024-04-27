package thread_local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
//thread-5 -> new Simp() for 6
// thread-6 -> new Simp() for 6
        ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("ddMMyyyy"));

        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                try {
                    Date parse = simpleDateFormatThreadLocal.get().parse("01012024");
                    System.out.println(parse);

                } catch (ParseException e) {

                }
            });
        }

    }
}
