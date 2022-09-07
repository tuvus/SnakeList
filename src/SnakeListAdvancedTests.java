import org.junit.Assert;
import org.junit.Test;

public class SnakeListAdvancedTests {
    @Test
    public void Test1() {
        SnakeList snakeList = new SnakeList(Boolean.class, 3);
        snakeList.add(false);
        snakeList.add(true);
        snakeList.add(false);
        snakeList.add(false);
        snakeList.add(true);
        snakeList.add(false);
        snakeList.remove(true);
        snakeList.remove(false);
        snakeList.remove(false);
        snakeList.add(false);
        snakeList.add(false);
        Assert.assertArrayEquals(new Boolean[]{false, true, false, false, false}, snakeList.toExactArray());
    }

    @Test
    public void Test2() {
        SnakeList snakeList = new SnakeList(String.class, 0);
        snakeList.add("alpha");
        snakeList.add(0, "beta");
        snakeList.add(0, "omega");
        snakeList.add(snakeList.size, "gamma");
        snakeList.remove(snakeList.get(1));
        Assert.assertArrayEquals(new String[]{"omega", "alpha", "gamma"}, snakeList.toExactArray());
    }
}
