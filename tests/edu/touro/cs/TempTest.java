package edu.touro.cs;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

//// TODO : Replace this file with your code
//class Timer
//{
//    private long start = -1, stop =-1;
//    void start(){
//        if (stop != -1) throw new RuntimeException("Must call clear before start if stopped");
//        start = System.nanoTime();
//    }
//    void stop(){
//        if (start == -1) throw new RuntimeException("Start must be called before start");
//        stop = System.nanoTime();}
//
//    long getElapsedTime(){return stop-start;}
//
//    void clear()
//    {
//        start = stop = -1;
//    }
//}
//class BigOhTester
//{
//    BigOhTesterInterface ti;
//    int times;
//    BigOhTester(BigOhTesterInterface ti, int times)
//    {
//        this.ti = ti;
//        this.times = times;
//    }
//
//    <T> long run(Consumer<T> method, T arg){
//        method.accept(arg); //warmup JIT compiler
//        Timer t= new Timer();
//        t.start();
//        for (int i = 0;i<times;i++) {
//            method.accept(arg);
//        }
//        t.stop();
//        long time = t.getElapsedTime()/times;
//        return time;
//    }
//
//    <T> BigOhTime getTimeEfficiency(Consumer<T> method, T arg100, T arg1000,  T arg10000,  T arg100000)
//    {
//        long _100 = run(method, arg100);
//        long _1000 = run(method, arg1000);
//        long _10000 = run(method, arg10000);
//        long _100000 = run(method, arg100000);
//
//        if (isConst(_100,_1000,_10000, _100000))
//            return BigOhTime.Constant;
//    }
//
//    private boolean isConst(long l, long l1, long l2, long l3) {
//        double avg = (l+l1+l2+l3)/4;
//        if (approximate(avg, l, ) &&
//    }
//}
//
//enum BigOhTime {Constant, N, LogN};
//interface BigOhTesterInterface
//{
//    <T> void testMethods(Consumer<T> method, T arg100, T arg1000,  T arg10000,  T arg100000);
//}
//
//class CUT{ int foo(){ return 3;}}
//class Test2
// {
//     static int constant() {
//         int sum = 0;
//         for (int i = 0; i < 100; i++)
//             sum += i;
//         return sum;
//     }
//     static int OrderN(int n) {
//         int sum = 0;
//         for (int i = 0; i < n; i++)
//             sum += i;
//         return sum;
//     }
//     static int OrderNSquared(int n) {
//         int sum = 0;
//         for (int i = 0; i < n * n; i++)
//             sum += i;
//         return sum;
//     }
//     static int OrderNLogN(int n) {
//         double logN = Math.log(n);
//         int sum = 0;
//         for (int i = 0; i < n * logN; i++)
//             sum += i;
//         return sum;
//     }
//     static int OrderExponential(int n) {
//         double max = Math.pow(2,n);
//         int sum = 0;
//         for (int i = 0; i < max; i++)
//             sum += i;
//         return sum;
//     }
// }
//
//
public class TempTest {

    @Test
    public void Order1() {

       // HighLowGameHumanPicksModel model = new HighLowGameHumanPicksModel();

      //  model.hi = 999;

    }
    }
//
//}