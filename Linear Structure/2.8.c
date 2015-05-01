//
//  2.8.c
//  data structure
//
//  Created by Xuchao Ding on 2015-04-30.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _stack {
    int type;
    int num;
    char op;
    struct _stack* next;
} Stack;

Stack* createStack(int type, int num, char op) {
    Stack* s = (Stack*)malloc(sizeof(Stack));
    s->type = type;
    s->next = NULL;
    if(type) {
        s->num = num;
    }
    else {
        s->op = op;
    }
    return s;
}

Stack* pop(Stack* s) {
    Stack* temp = NULL;
    if(s) {
        temp = s;
        s = s->next;
    }
    return temp;
}

void push(Stack* s, Stack* node) {
//    if(!s ) {
//        s = (Stack*)malloc(sizeof(Stack));
//        s->next = node->next;
//    }
    node->next = s;
    s = node;
}

void printStack(Stack* s) {
    if(s->type) {
        printf("%d ", s->num);
    }
    else {
        printf("%c ", s->op);
    }
}

int calculate(int a, int b, char op) {
	int res = 0;
	switch(op) {
	case '+':
		res = a + b;
		break;
	case '-':
		res = a - b;
		break;
	case '*':
		res = a * b;
		break;
	case '/':
		if(b != 0) {
			res = a / b;
		}
		else {
			res = -32768;
		}
		break;
	}
	return res;
}

int found24 = 0;
char op[4];
int num[4];
Stack* s[7];
int x[3], y[4];

void loop() {
	for(x[0] = 0; x[0] < 4; x[0]++) {
		for(x[1] = 0; x[1] < 4; x[1]++) {
			for(x[2] = 0; x[2] < 4; x[2]++) {
				for(y[0] = 0; y[0] < 4; y[0]++) {
					for(y[1] = 0; y[1] < 4 && y[1] != y[0]; y[1]++){
						for(y[2] = 0; y[2] < 4 && y[2] != y[0] && y[2] != y[1]; y[2]++) {
							for(y[3] = 0; y[3] < 4 && y[3] != y[0] && y[3] != y[1] && y[3] != y[2]; y[3]++) {
								int indexop = 0;
								int indexnum = 0;
								Stack* expr = NULL;
								for(int i = 0; i < 7; i++) {
									if(s[i]->type) {
										s[i]->num = num[y[indexnum++]];
										push(expr, s[i]);
									}
									else {
										s[i]->op = op[x[indexop++]];
										Stack* ta = pop(expr);
										Stack* tb = pop(expr);
										int result = calculate(ta->num, tb->num, s[i]->op);
										Stack* temp = createStack(2, result, ' ');
										push(expr, temp);
										if(ta->type == 2) {
											free(ta);
										}
										if(tb->type == 2) {
											free(tb);
										}
									}
								}
								Stack* res = pop(expr);
								if(res->num == 24) {
									found24 = 1;
									for(int i = 0; i < 7; i++) {
										if(s[i]->type)
											printf("%d ", s[i]->num);
										else
											printf("%c ", s[i]->op);
									}
									printf("\n");
									free(res);
									goto BINGO;
								}
								free(res);
							}
						}
					}
				}
			}
		}
	}
	BINGO:
	return;
}

void case1() {
    s[2]->type = 1;
    s[3]->type = 1;
    s[4]->type = 0;
    s[5]->type = 0;
    loop();
}

void case2() {
    s[2]->type = 1;
    s[3]->type = 0;
    s[4]->type = 1;
    s[5]->type = 0;
}

void case3() {
    s[2]->type = 1;
    s[3]->type = 0;
    s[4]->type = 0;
    s[5]->type = 1;
}

void case4() {
    s[2]->type = 0;
    s[3]->type = 1;
    s[4]->type = 0;
    s[5]->type = 1;
}

void case5() {
    s[2]->type = 0;
    s[3]->type = 1;
    s[4]->type = 1;
    s[5]->type = 0;
}

int main() {

    op[0] = '+';
    op[1] = '-';
    op[2] = '*';
    op[3] = '/';

    for(int i = 0; i < 4; i++) {
        scanf("%d", &num[i]);
    }


    for(int i = 0; i < 7; i++) {
        s[i] = (Stack*)malloc(sizeof(Stack));
    }
    s[0]->type = 1;
    s[1]->type = 1;
    s[6]->type = 0;

    case1();
    if(found24)
    	goto exit;
    case2();
    if(found24)
        	goto exit;
    case3();
    if(found24)
        	goto exit;
    case4();
    if(found24)
        	goto exit;
    case5();
    if(found24)
        	goto exit;

    if(!found24) {
    	printf("-1\n");
    }
exit:
    return 0;
}

/*
一副扑克牌的每张牌表示一个数（J、Q、K分别表示11、12、13，两个司令都表示6）。任取4张牌，即得到4个1~13的数，
请添加运算符（规定为加+ 减- 乘* 除/ 四种）使之成为一个运算式。每个数只能参与一次运算，4个数顺序可以任意组合，
4个运算符任意取3个且可以重复取。运算遵从一定优先级别，可加括号控制，最终使运算结果为24。
请输出一种解决方案的表达式，用括号表示运算优先。如果没有一种解决方案，则输出-1表示无解。

输入格式说明：

输入在一行中给出4个整数，每个整数取值在[1, 13]。

输出格式说明：

输出一种解决方案的表达式，用括号表示运算优先。如果没有解决方案，请输出-1。

样例输入与输出：
 1
 2 3 12 12
 ((3-2)*12)+12
 2
 5 5 5 5
 (5*5)-(5/5)
 3
 1 3 5 6
 (1+(3*6))+5
 4
 8 13 9 4
 8+((13-9)*4)
 5
 2 13 7 7
 2*(13-(7/7))
 6
 5 5 5 2
 -1
*/
