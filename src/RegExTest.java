import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest{

    public static void main(String[] args){
        //1
        String input = "aa";
        String regex = "";

        //2
        input = "aa";
        regex = "a";

        //3
        input = "ab";
        regex = "ab";

        //4
        input = "ab";
        regex = "a|b";

        //5
        input = "aa";
        regex = "a*";

        //6
        input = "aa";
        regex = "a+";

        //7
        input = "aa";
        regex = "aa*"; //6 с помощью 1-5

        //8
        input = ""; //?
        regex = "\\**";

        //9
        input = "ab"; //?
        regex = "a*b*";

        //10
        input = ""; //?
        regex = "aa*bb*";

        //11
        input = ""; //?
        regex = "a*|b*";

        //12
        input = "aaaaaaaaaaaaaaaaaaaa"; //?
        regex = "(a|b)*";

        //13
        input = ""; //?
        regex = "a|b*";

        //14
        input = ""; //?
        regex = "(aab|ab)*";

        //15
        input = "101"; //натуральное число
        regex = "(1*|2*|3*|4*|5*|6*|7*|8*|9*)(1*|2*|3*|4*|5*|6*|7*|8*|9*|0*)*"; //?

        //16
        input = "-0.06"; //действительное число
        regex = "\\-*(0|[1-9]+[0-9]*)\\.[0-9]+"; //?

        //17
        //nput = ""; //e-mail
        regex = "\\w+[-.]*\\w+\\@[a-zA-z]+\\.[a-zA-z]+"; //?

        boolean result = input.matches(regex); //проверка строки на соответсвие регулярному выражению
        System.out.println(result);

        //https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

        //18
        /*
        input = "AbbbaaAbbbaaAbbb";
        Pattern pattern = Pattern.compile("A.+a"); //жадный поиск (+) - максимум строк, соответствующих выражению "."
        //Pattern pattern = Pattern.compile("A.+?a"); //ленивый поиск (+?) - минимум число строк, соответствующих выражению "."
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) //поиск в строке подстрок соответсвующих регулярному выражению
            System.out.println(matcher.group());

        */
    }
}
