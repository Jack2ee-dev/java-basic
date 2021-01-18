package java_basic.ch12_Thread;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx12 {
    
    public static void main(String[] args) throws Exception {
        ThreadEx12_1 t1 = new ThreadEx12_1("thread1");
        ThreadEx12_2 t2 = new ThreadEx12_2("thread2");
        t1.start();
        t2.start();
    }
}

class ThreadEx12_1 extends Thread {
    
    public ThreadEx12_1(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        try {
            sleep(5 * 1000);
        } catch (InterruptedException e) {}
    }
}

class ThreadEx12_2 extends Thread {
    
    public ThreadEx12_2(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        Map<Thread, StackTraceElement[]> map = getAllStackTraces();
        Iterator<Thread> it = map.keySet().iterator();
        
        int x = 0;
        while (it.hasNext()) {
            Thread t = it.next();
            StackTraceElement[] ste = map.get(t);
            System.out.println(
                "[" + ++x + "] name : " + t.getName() + ", group : " + t.getThreadGroup().getName()
                    + ", daemon : " + t.isDaemon());
            
            for (int i = 0; i < ste.length; i++) {
                System.out.println(ste[i]);
            }
            System.out.println();
        }
    }
}