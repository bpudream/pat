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
* ���д�����ҳ�һ�θ��������г�����Ƶ�����Ǹ�Ӣ����ĸ��

�����ʽ��

������һ���и���һ�����Ȳ�����1000���ַ������ַ�����ASCII���������ɼ��ַ����ո���ɣ����ٰ���1��Ӣ����ĸ���Իس��������س��������ڣ���

�����ʽ��

��һ�����������Ƶ����ߵ��Ǹ�Ӣ����ĸ������ִ���������Կո�ָ�������в��У����������ĸ����С���Ǹ���ĸ��ͳ��ʱ�����ִ�Сд�����Сд��ĸ��

����������
This is a simple TEST.  There ARE numbers and other symbols 1&2&3...........
���������
e 7*/