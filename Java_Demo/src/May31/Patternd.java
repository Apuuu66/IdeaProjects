package May31;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Snoopy on 2017/5/31.
 */
public class Patternd {
    public static void main(String[] args) {
        String input = "add q w wwq qw r edw q wdwdsdq qdwdqwqad aq wq qwwe";
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]{3}\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
