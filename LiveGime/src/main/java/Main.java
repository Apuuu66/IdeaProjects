import java.util.Scanner;

/**
 * Created by Snoopy on 2017/6/3.
 */
public class Main {
    public static void main(String[] args) {
        int[][] initArray = init();
        boolean state = true;
        int i = 0;

        while (state) {
            int[][] result = execute(initArray);
            initArray = result;
            System.out.println();
            i++;
            if (i > 5) {
                state = false;
            }
        }
    }

    public static int[][] execute(int initArray[][]) {
        int[][] result = handle(initArray);
        print(result);
        return result;
    }

    public static void print(int result[][]) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j]==1)
                    System.out.print("*");
                else System.out.print("-");
            }
        }
        System.out.println();

    }

    public static int[][] init() {
//        int array[][] = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
//        int array[][] = {{0, 0, 0}, {1, 1, 1}, {0, 0, 0}};
//        int array[][] = {{0, 0, 0}, {1, 0, 1}, {1, 0, 0}};
//        int array[][] = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};

        Scanner in = new Scanner(System.in);
        System.out.print("请输入行列数:");
        int m = in.nextInt();
        int n=in.nextInt();
        System.out.println("输入各细胞状态，0表示生,1表示死");
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = in.nextInt();
            }
        }
        return array;
    }

    public static int[][] handle(int array[][]) {
        int coverArr[][] = new int[array.length][array[0].length];
        int newCellState = 0;
        int state = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                state = count(array, i, j);
                newCellState = cellState(array, state, array[i][j]);
                coverArr[i][j] = newCellState;
            }
        }
        return coverArr;
    }

    public static int count(int[][] array, int m, int n) {
        int sum = 0;
        //左上
        for (int i = m - 1; i <= m + 1; i++) {
            for (int j = n - 1; j <= n + 1; j++) {
                if (i == m && j == n)
                    continue;
                if (i == -1 || j == -1 || i == array.length || j == array[0].length)
                    continue;
                if (array[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int cellState(int[][] array, int state, int oldState) {
        if (state == 3) {
            return 1;
        } else if (state == 2)
            return oldState;
        else
            return 0;
    }
}
