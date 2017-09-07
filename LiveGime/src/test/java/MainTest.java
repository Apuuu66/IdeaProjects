import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Snoopy on 2017/6/3.
 */
public class MainTest {
    //       int array[][] = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
    //       int array[][] = {{0, 0, 0}, {1, 1, 1}, {0, 0, 0}};
    //       int array[][] = {{0, 0, 0}, {1, 0, 1}, {1, 0, 0}};
    //       int array[][] = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};

    @Test
    public void test_one() throws Exception {
        int array[][] = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        int[][] expireResult = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        int[][] reslutArray = Main.execute(array);
        assertArrayEquals(reslutArray, expireResult);

    }

    @Test
    public void test_two() throws Exception {

        int array[][] = {{0, 0, 0}, {1, 1, 1}, {0, 0, 0}};
        int[][] expireResult = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] reslutArray = Main.execute(array);
        assertArrayEquals(reslutArray, expireResult);

    }

    @Test
    public void test_three() throws Exception {
        int array[][] = {{0, 0, 0}, {1, 0, 1}, {1, 0, 0}};
        int[][] expireResult = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] reslutArray = Main.execute(array);
        assertArrayEquals(reslutArray, expireResult);
    }

    @Test
    public void test_four() throws Exception {
        int array[][] = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int[][] expireResult = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] reslutArray = Main.execute(array);
        assertArrayEquals(reslutArray, expireResult);
    }

    @Test
    public void test_five() throws Exception {
        int array[][] = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        Main.execute(array);
    }

}