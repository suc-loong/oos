package com.hctel.oos.common.utils;

public class PrettyJSON {

    public static String pretty(String jsonStr) {
        StringBuffer sb = new StringBuffer();
        char[] charArray = jsonStr.toCharArray();
        char[] stack = new char[1024]; // 存放括号，如 "{","}","[","]"
        int top = -1;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if ('{' == c || '[' == c) {
                stack[++top] = c; // 将括号添加到数组中，这个可以简单理解为栈的入栈
                sb.append(charArray[i] + "\n");
                for (int j = 0; j <= top; j++) {
                    sb.append("\t");
                }
                continue;
            }
            if ((i + 1) <= (charArray.length - 1)) {
                char d = charArray[i + 1];
                if ('}' == d || ']' == d) {
                    top--; // 将数组的最后一个有效内容位置下标减 1，可以简单的理解为将栈顶数据弹出
                    sb.append(charArray[i] + "\n");
                    for (int j = 0; j <= top; j++) {
                        sb.append("\t");
                    }
                    continue;
                }
            }
            if (',' == c) {
                sb.append(charArray[i] + "\n");
                for (int j = 0; j <= top; j++) {
                    sb.append("\t");
                }
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

}