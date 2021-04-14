package com.ymt.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 *
 * @author yumingtao
 * @date 4/14/21 11:02 AM
 */
public class MyRegex {
    public static void main(String[] args) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        String text = "lklkl 2021-04-14 2021-04-13 jkljlajfl";

        System.out.println(Pattern.matches(regex, text));
        System.out.println(text.matches(regex));

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        //System.out.println(matcher.find());
        System.out.println(matcher);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }


        pattern = Pattern.compile("\\A" + regex + "\\Z");
        matcher = pattern.matcher(text);
        System.out.println(matcher.find());
        System.out.println(pattern.matcher(text));
    }
}
