package com.quincy.leetcode;


import java.util.*;

/**
 * <a href='https://leetcode-cn.com/problems/reorder-log-files/'>reorder-log-files</a>
 *
 * @author quinc
 * @date 2018/11/15 星期四
 */
public class ReorderLogFiles {

    // 80ms
    public static String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        // 选择字母开头的->排序->转为数组
        Object[] letters = Arrays.stream(logs)
                .filter(s -> 0 == startWithLetterOrDigit(s))
                .sorted(Comparator.comparing(x -> x.split(" ", 2)[1]))
                .toArray();
        // 选择数字开头的->转为数组
        Object[] digits = Arrays.stream(logs)
                .filter(s -> 1 == startWithLetterOrDigit(s))
                .toArray();
        for (int i = 0; i < letters.length; i++) {
            result[i] = (String) letters[i];
        }
        for (int i = 0; i < digits.length; i++) {
            result[letters.length + i] = (String) digits[i];
        }
        return result;
    }

    private static int startWithLetterOrDigit(String log) {
        int letter = 0;
        int digit = 1;
        if (Character.isDigit(log.split(" ", 2)[1].charAt(0))) {
            return digit;
        } else {
            return letter;
        }
    }

    // 5ms
    public String[] reorderLogFiles2(String[] logs) {
        String[] res = new String[logs.length];
        int j = logs.length - 1;
        // k为需要排序的日志内容，v为原内容
        Map<String, String> map = new HashMap<>();
        // 排序的日志内容
        List<String> logBodies = new ArrayList<>();
        // 倒序可以保证数字在后面
        for (int i = logs.length - 1; i >= 0; i--) {
            String logBody = getBody(logs[i]);
            if ("0".equals(logBody)) {
                res[j] = logs[i];
                j--;
            } else {
                map.put(logBody, logs[i]);
                logBodies.add(logBody);
            }
        }

        Collections.sort(logBodies);
        j = 0;
        for (String logBody : logBodies) {
            res[j] = map.get(logBody);
            j++;
        }
        return res;
    }

    private String getBody(String str) {
        String body = str.split(" ", 2)[1];
        char first = body.charAt(0);
        if (Character.isDigit(first)) {
            return "0";
        }
        return body;
    }


    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        String[] log2 = {"j mo", "5 m w", "g 07", "o 2 0", "t q h"};
        System.out.println(reorderLogFiles(logs));
        // expect : ["5 m w","j mo","t q h","g 07","o 2 0"]
        //my : ["j mo","5 m w","t q h","g 07","o 2 0"]
        System.out.println(reorderLogFiles(log2));
    }
}
