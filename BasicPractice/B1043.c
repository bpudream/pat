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
* ����һ�����Ȳ�����10000�ġ�����Ӣ����ĸ���ɵ��ַ������뽫�ַ����µ���˳�򣬰���PATestPATest....��
* ������˳������������������ַ�����Ȼ�������ַ��ĸ�����һ����һ����ģ���ĳ���ַ��Ѿ�����꣬
* �����µ��ַ��԰�PATest��˳���ӡ��ֱ�������ַ����������

�����ʽ��

������һ���и���һ�����Ȳ�����10000�ġ�����Ӣ����ĸ���ɵķǿ��ַ�����

�����ʽ��

��һ���а���ĿҪ������������ַ�������Ŀ��֤����ǿա�

����������
redlesPayBestPATTopTeePHPereatitAPPT
���������
PATestPATestPTetPTePePee*/ 
