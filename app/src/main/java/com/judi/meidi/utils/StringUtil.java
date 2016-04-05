package com.judi.meidi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {


    public static boolean isPhoneNumber(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^(13|15|18|17|14|00)[0-9]{9}$");
    }

    public static boolean isNumberLetter(String str){
        if (str == null){
            return false;
        }
        return str.matches("^[a-zA-Z\\d]+$");
    }

    public static boolean isBlank(String str) {
        if (str == null || str.equals("") || str.trim().equals("")||trimAll(str).equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    public static String insteadChangeLine(String src) {
        if (isEmpty(src)) {
            return null;
        } else {
            return src.replace("\r\n", "\n");
        }
    }

    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private static boolean isNotEmojiCharacter(char codePoint)
    {
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
    public static String filterEmoji(String source)
    {
        int len = source.length();
        StringBuilder buf = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            char codePoint = source.charAt(i);
            if (isNotEmojiCharacter(codePoint))
            {
                buf.append(codePoint);
            }
        }
        return buf.toString();
    }

    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) {
                return true;
            }
        }
        return false;

    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    public static String trimAll(String str){
        return filterEmoji(str.replaceAll("\\s*", ""));
    }
}

