package com.mockproject.freetutsproject.util;

import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.regex.Pattern;

@Component
public class StringUtil {
    public String replaceWhitespaceWithMinus(String s){
        return s.replaceAll(" ", "-");
    }

    public String removeAccent(String s) {
        s = replaceWhitespaceWithMinus(s);
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("")
                                    .replaceAll("Đ","D")
                                    .replaceAll("đ","d");
        }
}
