#include <stdio.h>
#include <stdlib.h>

    int main() {
        char c;
        int counter[6];
        int len = 0;
        for(int i = 0; i < 6; i++) {
            counter[i] = 0;        
        }
        char ch[6] = {'P','A','T','e','s','t'};
        while((c = getchar()) != '\n') {
            int index = -1;
            switch(c) {
                case 'P':
                    index = 0;
                    break;
                case 'A':
                    index = 1;
                    break;
                case 'T':
                    index = 2;
                    break;
                case 'e':
                    index = 3;
                    break;
                case 's':
                    index = 4;
                    break;
                case 't':
                    index = 5;
                    break;
            }
            if(index >= 0) {
                counter[index]++;
                len++;
            }
        }
        
        while(len > 0) {
            for(int i = 0; i < 6; i++) {
                if(counter[i] > 0) {
                    printf("%c", ch[i]);
                    counter[i]--;          
                    len--;
                }
            }
        }

// system("pause");
        return 0;
    }

/*
* 给定一个长度不超过10000的、仅由英文字母构成的字符串。请将字符重新调整顺序，按“PATestPATest....”
* 这样的顺序输出，并忽略其它字符。当然，六种字符的个数不一定是一样多的，若某种字符已经输出完，
* 则余下的字符仍按PATest的顺序打印，直到所有字符都被输出。

输入格式：

输入在一行中给出一个长度不超过10000的、仅由英文字母构成的非空字符串。

输出格式：

在一行中按题目要求输出排序后的字符串。题目保证输出非空。

输入样例：
redlesPayBestPATTopTeePHPereatitAPPT
输出样例：
PATestPATestPTetPTePePee*/ 
