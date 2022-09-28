package SnakeList;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.SingleShotTime)
@Fork(value = 1)
@Warmup(iterations = 0)
@Measurement(iterations = 2, timeUnit = TimeUnit.NANOSECONDS)
public class SnakeListBenchmarkTests {
    @Benchmark
    public void snakeListBenchmark1() {
        DoOperation(new SnakeList(Integer.class, 100));
    }

    @Benchmark
    public void arrayListBenchmark1() {
        DoOperation(new ArrayList<Integer>(100));
    }

    void DoOperation(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }
}
