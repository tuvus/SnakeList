package SnakeList;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2)
@Warmup(iterations = 2)
@Measurement(iterations = 100, timeUnit = TimeUnit.MILLISECONDS, time = 1)
public class SnakeListGetBenchmark {
    @Benchmark
    public void snakeListBenchmark1(Blackhole blackhole) {
        GetOperation(new SnakeList(Integer.class, 100), blackhole);
    }

    @Benchmark
    public void arrayListBenchmark1(Blackhole blackhole) {
        GetOperation(new ArrayList<Integer>(100), blackhole);
    }

    @Benchmark
    public void controlArrayListBenchmark1(Blackhole blackhole) {
        GetOperation(new ControlArrayList(Integer.class,100), blackhole);
    }

    void GetOperation(List<Integer> list, Blackhole blackhole) {
        Random random = new Random(14124);
        for (int i = 0; i < 10000; i++) {
            list.add(random.nextInt());
        }
        for (int i = 0; i < 50000; i++) {
            blackhole.consume(list.get(random.nextInt(list.size())));
        }
    }
}
