import org.omg.CORBA.INTERNAL;

public class BowlingGame {
    public static int getBowlingScore(String bowlingCode) {
        int totalScore = 0;
        int preScores = 0;
        int flag;
        String[] arr = bowlingCode.split("\\|\\|");
        System.out.println(arr[0]);
        String bowStr[] = arr[0].split("\\|");
        //计算前8格
        for (int i = 0; i < bowStr.length - 2; i++) {
            flag = judge(bowStr, i);
            preScores = getScore(bowStr, i, flag);
            totalScore += preScores + calNextScore(bowStr, i + 1, flag);
//            System.out.println(getScore(bowStr, i, flag));
        }
        //计算后两格
        if (bowlingCode.endsWith("||")) {
            for (int i = 8; i < bowStr.length; i++) {
                flag = judge(bowStr, i);
                preScores = getScore(bowStr, i, flag);
                totalScore += preScores + calNextScore(bowStr, i + 1, flag);
            }
        } else {
            if (arr[1].length() == 1) {
                //计算第10格
                flag = judge(arr, 1);
                preScores = getScore(arr, 1, flag);
                totalScore += 10 + preScores;
                //计算第9格
                flag = judge(bowStr, 8);
                preScores = getScore(bowStr, 8, flag);
                totalScore += preScores + calNextScore(bowStr, 9, flag);
            } else {
                //计算第10格
                totalScore += 10;
                for (int i = 0; i < 2; i++) {
                    if (arr[1].charAt(1) == '/') {
                        totalScore += 10;
                        break;
                    }
                    if (arr[1].charAt(i) == 'X')
                        totalScore += 10;
                    else if (arr[1].charAt(i) == '-')
                        totalScore += 0;
                    else
                        totalScore += Integer.parseInt(arr[1].charAt(i) + "");
                }
                //计算第9格
                if (bowStr[8].length() == 1) {
                    int temp = 0;
                    if (arr[1].charAt(0) == 'X')
                        temp += 10;
                    else if (arr[1].charAt(0) == '-')
                        temp += 0;
                    else
                        temp += Integer.parseInt(arr[1].charAt(0) + "");
                    totalScore += 10 + 10 + temp;
                } else {
                    flag = judge(bowStr, 8);
                    preScores = getScore(bowStr, 8, flag);
                    totalScore += preScores + calNextScore(bowStr, 8 + 1, flag);
                }
            }
        }
        return totalScore;
    }
    private static int calNextScore(String[] bowStr, int i, int flag) {
        int count = 0;
        int temp = 0;
        while (count != flag && i < bowStr.length)
            if (flag == 1) {
                if (bowStr[i].charAt(0) == 'X')
                    return 10;
                else if (bowStr[i].charAt(0) == '-')
                    return 0;
                else
                    return Integer.parseInt(bowStr[i].charAt(0) + "");
            } else if (flag == 2) {
                if (bowStr[i].length() == 1) {
                    temp += 10;
                    count++;
                    i++;
                } else {
                    if (bowStr[i].charAt(1) == '/' && count == 0)
                        return 10;
                    else
                        for (int j = 0; j < bowStr[i].length(); j++) {
                            if (bowStr[i].charAt(j) == '-') {
                                count++;
                                temp += 0;
                            } else {
                                count++;
                                temp += Integer.parseInt(bowStr[i].charAt(j) + "");
                            }
                            if (count == 2)
                                break;
                        }
                }
            }
        if (temp != 0)
            return temp;
        return 0;
    }
    private static int getScore(String[] bowStr, int i, int flag) {
        int temp = 0;
        if (flag == 2 || flag == 1) {
            return 10;
        } else {
            for (int j = 0; j < bowStr[i].length(); j++) {
                if (bowStr[i].charAt(j) == '-')
                    temp += 0;
                else
                    temp += Integer.parseInt(bowStr[i].charAt(j) + "");
            }
        }
        return temp;
    }
    public static int judge(String[] bowStr, int i) {
        for (int j = 0; j < bowStr[i].length(); j++) {
            if (bowStr[i].charAt(j) == 'X')
                return 2;
            if (bowStr[i].charAt(j) == '/')
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        String bowlingCode1 = "X|X|X|X|X|X|X|X|X|X||XX";           //300
        String bowlingCode2 = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";  //150
        String bowlingCode3 = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";   //90
        String bowlingCode4 = "X|7/|9-|X|-8|8/|-6|X|X|X||81";      //167
        System.out.println(getBowlingScore(bowlingCode1));
        System.out.println(getBowlingScore(bowlingCode2));
        System.out.println(getBowlingScore(bowlingCode3));
        System.out.println(getBowlingScore(bowlingCode4));
    }
}
