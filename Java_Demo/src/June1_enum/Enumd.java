package June1_enum;

/**
 * Created by Snoopy on 2017/6/1.
 */
enum Season {
    spring, summer, autumn, winter;
}

public class Enumd {
    public static void main(String[] args) {
        Season season = Season.spring;
        switch (season) {
            case spring:
                break;
            case summer:
                break;
            case autumn:
                break;
            case winter:
                break;
            default:
                break;
        }
    }
}
