package SnakeList;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 0)
@Measurement(iterations = 10, timeUnit = TimeUnit.NANOSECONDS, time = 1)
public class SnakeListBenchmarkTests {
    @Benchmark
    public void snakeListBenchmark1() {
        DoOperation(new SnakeList(Integer.class, 100));
    }

    @Benchmark
    public void arrayListBenchmark1() {
        DoOperation(new ArrayList<Integer>(100));
    }

    @Benchmark
    public void controlArrayListBenchmark1() {
        DoOperation(new ControlArrayList(Integer.class,100));
    }

    void DoOperation(List<Integer> list) {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }
}
