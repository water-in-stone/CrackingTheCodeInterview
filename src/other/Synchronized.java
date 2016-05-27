package other;

/**
 * Created by Young on 2016/5/27.
 * wang645788@gmail.com
 */
public class Synchronized {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();

/*
        //对于同一个对象myObject的同步方法，只有一个线程能调用
        MyClass thread1 = new MyClass("one", myObject);
        MyClass thread2 = new MyClass("two", myObject);
*/

        MyClass thread1 = new MyClass("1", new MyObject());
        MyClass thread2 = new MyClass("2", new MyObject());

        //调用start方法才是让另一个线程去执行
        thread1.start();
        thread2.start();
    }
}

class MyClass extends Thread {
    private String name;
    private MyObject myObject;

    MyClass(String name, MyObject myObject) {
        this.name = name;
        this.myObject = myObject;
    }

    public void run() {
        myObject.foo(name);
       /* if (name.equals("1")) {
            MyObject.foo1(name);
        } else {
            MyObject.bar(name);
        }*/
    }
}

class MyObject {
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + " is execute method foo");
            Thread.sleep(2000);
            System.out.println("Thread " + name + " execute method foo ok");
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " execute method foo end");
        }
    }
/*
    //可以synchronized (this){}的形式来达到同步方法的效果
    public void foo(String name) {
        synchronized (this){
            try {
                System.out.println("Thread " + name + " is execute method foo");
                Thread.sleep(2000);
                System.out.println("Thread " + name + " execute method foo ok");
            } catch (InterruptedException e) {
                System.out.println("Thread " + name + " execute method foo end");
            }
        }
    }
*/

    /**
     * 对于同一个类的静态同步方法，即使是不同名字的方法也不能被两个线程调用，因为
     * static synchronized 就等于 class lock
     */
    public static synchronized void foo1(String name) {
        try {
            System.out.println("Thread " + name + " is execute method foo");
            Thread.sleep(2000);
            System.out.println("Thread " + name + " execute method foo ok");
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " execute method foo end");
        }
    }

    public static synchronized void bar(String name) {
        try {
            System.out.println("Thread " + name + " is execute method foo");
            Thread.sleep(2000);
            System.out.println("Thread " + name + " execute method foo ok");
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " execute method foo end");
        }
    }

}


