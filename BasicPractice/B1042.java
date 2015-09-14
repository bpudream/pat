package PAT;

import java.util.Scanner;

/**
 * Created by David on 2015/9/13.
 */
public class B1042 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] arr = new int[26];
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'a' && c <= 'z') {
                arr[c - 'a']++;
            }
            else if(c >= 'A' && c <= 'Z') {
                arr[c - 'A']++;
            }
        }
        int maxIndex = 0;
        for(int i = 1; i < 26; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        char res = (char)('a' + maxIndex);
        System.out.println(res + " " + arr[maxIndex]);
    }
}
/*
* 请编写程序，找出一段给定文字中出现最频繁的那个英文字母。

输入格式：

输入在一行中给出一个长度不超过1000的字符串。字符串由ASCII码表中任意可见字符及空格组成，至少包含1个英文字母，以回车结束（回车不算在内）。

输出格式：

在一行中输出出现频率最高的那个英文字母及其出现次数，其间以空格分隔。如果有并列，则输出按字母序最小的那个字母。统计时不区分大小写，输出小写字母。

输入样例：
This is a simple TEST.  There ARE numbers and other symbols 1&2&3...........
输出样例：
e 7*/