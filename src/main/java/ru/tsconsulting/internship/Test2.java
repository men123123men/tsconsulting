package ru.tsconsulting.internship;

import java.util.concurrent.atomic.AtomicBoolean;

public class Test2 extends AbstractTest {
    private static final AtomicBoolean val = new AtomicBoolean(true);

    public static void main(String... args) throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            assert size() == 0;

            Thread th1 = th();
            Thread th2 = th();

            th1.start();
            th2.start();

            th1.join();
            th2.join();

            assert size() == 2;
            assert containsKey(1);
            assert containsKey(2);
            assert contains(th1);
            assert contains(th2);

            clear();

            System.out.println("Checked " + i);
        }
    }

    private static Thread th() {
        return new Thread(() -> {
            // работает ВСЕГДА
//            boolean b1 = val.get();
//            while (!val.compareAndSet(b1,!b1))
//                b1=!b1;
//            System.out.println(b1?2:1);
//            put(b1?1:2);

            // работает ВСЕГДА
//            if (val.getAndSet(!val.get())) {
//                put(1);
//            } else {
//                put(2);
//            }
            //можно и так
//            put(val.getAndSet(!val.get())?1:2);





            // проходит при val_начальное = false (но не проходит при val_начальное = TRUE)
//            if (val.compareAndSet(false, true)){
//                put(1);
//            } else {
//                put(2);
//                val.set(false);    // или val.compareAndSet(true, false);
//            }

//            // проходит при val_начальное = TRUE (но не проходит при val_начальное = false)
//            if (val.compareAndSet(true,false)){
//                put(1);
//            } else {
//                put(2);
//                val.set(true);
//            }




            // проходит при val_начальное = false (но не проходит при val_начальное = TRUE)
//            if(val.getAndSet(true)) {
//                put(2);
//                val.set(false);
//            } else {
//                put(1);
//            }

            // проходит при val_начальное = false (но не проходит при val_начальное = TRUE)
//            if(!val.getAndSet(true)) {
//                put(1);
//            } else {
//                put(2);
//                val.set(false);
//            }

//            // НЕ проходит никогда
//            if(val.get()) {
//                val.set(false);
//                put(1);
//            } else {
//                val.set(true);
//                put(2);
//            }

//            // проходит при val_начальное = TRUE (но не проходит при val_начальное = false)
//            if(val.getAndSet(false)) {
//                put(1);
//            } else {
//                put(2);
//                val.set(true);
//            }

//            // проходит при val_начальное = TRUE (но не проходит при val_начальное = false)
//            if(!val.getAndSet(false)) {
//                put(2);
//                val.set(true);
//            } else {
//                put(1);
//            }




        });
    }

}