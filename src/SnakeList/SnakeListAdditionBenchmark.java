package SnakeList;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 50, timeUnit = TimeUnit.MILLISECONDS, time = 1)
public class SnakeListAdditionBenchmark {
    @Benchmark
    public void snakeListBenchmark1() {
        RandomOperation(new SnakeList(Integer.class, 100));
    }

    @Benchmark
    public void arrayListBenchmark1() {
        RandomOperation(new ArrayList<Integer>(100));
    }

    @Benchmark
    public void controlArrayListBenchmark1() {
        RandomOperation(new ControlArrayList(Integer.class,100));
    }

    void RandomOperation(List<Integer> list) {
        Random random = new Random(14124);
        for (int i = 0; i < 50000; i++) {
            int randomOperation = random.nextInt(20);
            if (randomOperation == -1) {
                list.clear();
            } else if (randomOperation <= 10 && list.size() > 0) {
                int index = random.nextInt(list.size());
                int number = random.nextInt();
                list.add(index,number);
            } else if (randomOperation <= 12) {
                list.remove(0);
            } else if (randomOperation <= 15 && list.size() > 0) {
                int index = random.nextInt(list.size());
                list.remove(index);
            } else {
                int number = random.nextInt();
                list.add(number);
            }
        }
    }
}