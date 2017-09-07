import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Snoopy on 2017/5/14.
 */
public class Candle {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuffer str=new StringBuffer();
        int n=in.nextInt();
        int array[]=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=in.nextInt();
            str.append(array[i]);
        }
        Arrays.sort(array);
        getScores(str);
    }

    public static int  getScores( StringBuffer str) {
        int i;
        int score=0;
        int len = str.length();
        while (len!=0){
            findMinScore(str);
        }
//      findMinScore(array);
        return score;
    }

    private static int  findMinScore(StringBuffer str) {
        int index=0;

        for (int i = 0; i <str.length() ; i++) {

        }
        return index;
    }
}
