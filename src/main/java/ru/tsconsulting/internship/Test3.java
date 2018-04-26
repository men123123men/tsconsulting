package ru.tsconsulting.internship;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Test3 extends AbstractTest {
    private static volatile AtomicBoolean val1 = new AtomicBoolean();
    private static volatile AtomicBoolean val2 = new AtomicBoolean();

    private static volatile AtomicBoolean val3 = new AtomicBoolean();
    private static volatile AtomicReference<AtomicBoolean> ref = new AtomicReference<>(val3);



    public static void main(String... args) throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            assert size() == 0;

            Thread th1 = th();
            Thread th2 = th();
            Thread th3 = th();

            th1.start();
            th2.start();
            th3.start();

            th1.join();
            th2.join();
            th3.join();

//            assert size() == 3;
//            assert containsKey(1);
//            assert containsKey(2);
//            assert containsKey(3);
//            assert contains(th1);
//            assert contains(th2);
//            assert contains(th3);

            clear();

            System.out.println("Checked " + i);
        }
    }

    private static Thread th() {
        return new Thread(() -> {
//            boolean b1 = val1.get();
//            boolean b2 = val2.get();
//
//            while (!val1.compareAndSet(b1, !b1))
//                b1 = !b1;
//            if(b1)
//                while (!val2.compareAndSet(b2, !b2))
//                    b2 = !b2;
//
//            if(!b1&b2) {
//                while (!val1.compareAndSet(b1, !b1))
//                    b1 = !b1;
//                while (!val2.compareAndSet(b2, !b2))
//                    b2 = !b2;
//            }
//            System.out.println(b1?b2?"3":"2":"1");
//
//            //put(b1?b2?3:2:1);





//            boolean b1 = val1.get();
//            boolean b2 = val2.get();
//            boolean b3 = val3.get();
//
//            if(b1||b3)
//                while (!val1.compareAndSet(b1, !b1))
//                    b1 = !b1;
//            if(b2||b1)
//                while (!val2.compareAndSet(b2, !b2))
//                    b2 = !b2;
//            if(b3||b2)
//                while (!val3.compareAndSet(b3, !b3))
//                    b3 = !b3;
//
////            System.out.println((b1?1:0)+""+(b2?1:0)+""+(b3?1:0));
//            //System.out.println(b1?1:b2?2:3);
//            put(b1?1:b2?2:3);


//            boolean b1 = val1.getAndSet(!val1.get());
//            boolean b2 = val2.getAndSet(!val2.get());
//            boolean b3 = val3.getAndSet(!val3.get());

//            if(b1||b3)
//                while (!val1.compareAndSet(b1, !b1))
//                    b1 = !b1;
//            if(b2||b1)
//                while (!val2.compareAndSet(b2, !b2))
//                    b2 = !b2;
//            if(b3||b2)
//                while (!val3.compareAndSet(b3, !b3))
//                    b3 = !b3;

//            System.out.println((b1?1:0)+""+(b2?1:0)+""+(b3?1:0));
//            System.out.println(b1?1:b2?2:3);

//            if(b1) {
//                put(1);
//                return;
//            }
//            if(b2) {
//                put(2);
//                return;
//            }
//            if(b3) {
//                put(3);
//                return;
//            }
            //put(b1?1:b2?2:b3?3:4);




//            boolean b1 = val1.get();
//            boolean b2 = val2.get();
//            System.out.println(b1+"\t"+b2);

//            if (b1){
//                while (!val1.compareAndSet(b1, !b1));
//                    b1 = !b1;
//                put(1);
//            } else if(b2){
//                while (!val2.compareAndSet(b2, !b2));
//                    b2 = !b2;
//                put(2);
//            } else {
//                while (!val1.compareAndSet(b1, !b1));
//                    b1 = !b1;
//                while (!val2.compareAndSet(b2, !b2));
//                    b2 = !b2;
//                    put(3);
//            }

//            if (val1.getAndSet(!b1)) {
//                put(1);
//            } else if(val2.getAndSet(!b2)){
//                put(2);
//            } else
//                put(3);



//            // Правки можно внисить от этой линии
//            AtomicBoolean local = val1;
//
//            if (local.compareAndSet(false, true)) {
//                while(val1 != null) { }
//                if (local.compareAndSet(true, false)) {
//                    put(1);
//                    return;
//                }
//                put(3);
//                val1 = local;
//                return;
//            }
//
//            if (local.compareAndSet(true,  false)) {
//                while(!local.get()) { }
//                val1 = null;
//                put(2);
//                return;
//            }
//
//            local.set(true);
//            put(3);
//            while (local.get()) {
//            }
//            val1 = local;
//            // До этой





//            // работает
//            if(val1.compareAndSet(false, true))
//                put(1);
//            else {
//                if (val2.compareAndSet(false, true))
//                    put(2);
//                else {
//                    put(3);
//                    val1.set(false);
//                    val2.set(false);
//                }
//            }

//            // работает
//            if(val1.getAndSet(true)){
//                if(val2.getAndSet(true)){
//                    put(3);
//                    val1.set(false);
//                    val2.set(false);
//                } else
//                    put(2);
//            } else
//                put(1);

//              // Работает
//            if(val1.compareAndSet(false,true))
//                put(1);
//            else {
//                if(val2.getAndSet(true)){
//                    put(3);
//                    val2.set(false);
//                    val1.set(false);
//                } else
//                    put(2);
//            }



//              // Не работает
//            if(val1.compareAndSet(false,true))
//                put(1);
//            else {
//                if(val2.getAndSet(false)){
//                    put(3);
//                    val1.set(false);
//                }else {
//                    put(2);
//                    val2.set(true);
//                }
//            }

//              // Не работает
//            if(val1.compareAndSet(false,true))
//                put(1);
//            else {
//                if(val2.getAndSet(true)){
//                    put(3);
//                    val2.set(false);
//
//                } else put(2);
//
//            }

//              // Не работает
//            if(val1.compareAndSet(false,true))
//                put(1);
//            else {
//                if(val2.getAndSet(false)){
//                    put(3);
//                    val1.set(false);
//                } else {
//                    put(2);
//                    val2.set(true);
//
//                }
//            }



//              // Не работает
            //put(val1.compareAndSet(true,false)?1:val2.getAndSet(!val2.get())?2:3);

            if(val1.compareAndSet(false,true)){
                put(1);
            } else{
                if(val2.getAndSet(true)){

                    put(3);
                    val2.set(false);
                }else {
                    put(2);

                }

            }
                //put(val2.getAndSet(!val2.get())?2:3);


        });
    }



}