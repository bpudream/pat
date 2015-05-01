//
//  2.8.c
//  data structure
//
//  Created by Xuchao Ding on 2015-04-30.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _set {
    int elements[4];
    int size;
} Set;

void removeSet(Set* s, int value) {
    for(int i = 0; i < 4; i++) {
        if(s->elements[i] == value) {
            s->elements[i] = -1;
            s->size--;
            break;
        }
    }
}

int inSet(Set* set, int value) {
    int res = 0;
    if(set->size == 0) {
        return res;
    }
    for(int i = 0; i < 4; i++) {
        if(set->elements[i] == value){
            res = 1;
            break;
        }
    }
    return res;
}

int getFromSet(Set*s) {
    int res;
    for(int i = 0; i < 4; i++) {
        if(s->elements[i] != -1) {
            res = s->elements[i];
            s->size--;
            break;
        }
    }
    return res;
}

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

Set* set;
char op[4];
int num[4];
Stack* s[7];

void setOp() {
    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 7; j++) {
            
        }
    }
}

void case1() {
    s[2]->type = 1;
    s[3]->type = 1;
    s[4]->type = 0;
    s[5]->type = 0;
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
    
    set = (Set*)malloc(sizeof(Set));
    set->size = 4;
    
    for(int i = 0; i < 4; i++) {
        scanf("%d", &num[i]);
        set->elements[i] = num[i];
    }
    
   
    for(int i = 0; i < 7; i++) {
        s[i] = (Stack*)malloc(sizeof(Stack));
    }
    s[0]->type = 1;
    s[1]->type = 1;
    s[6]->type = 0;
    
    case1();
    case2();
    case3();
    case4();
    case5();
    
    return 0;
}

/*一副扑克牌的每张牌表示一个数（J、Q、K分别表示11、12、13，两个司令都表示6）。任取4张牌，即得到4个1~13的数，请添加运算符（规定为加+ 减- 乘* 除/ 四种）使之成为一个运算式。每个数只能参与一次运算，4个数顺序可以任意组合，4个运算符任意取3个且可以重复取。运算遵从一定优先级别，可加括号控制，最终使运算结果为24。请输出一种解决方案的表达式，用括号表示运算优先。如果没有一种解决方案，则输出-1表示无解。
 
 输入格式说明：
 
 输入在一行中给出4个整数，每个整数取值在[1, 13]。
 
 输出格式说明：
 
 输出一种解决方案的表达式，用括号表示运算优先。如果没有解决方案，请输出-1。
 
 样例输入与输出：
 
 序号	输入	输出
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



//    for(int a = 0; a < 4; a++) {
//        s[0] = createStack(1, num[a], ' ');
//        removeSet(set, num[a]);
//
//        for(int b = 0; b < 4; b++) {
//            if(a == b) {
//                continue;
//            }
//            s[1] = createStack(1, num[b], ' ');
//            removeSet(set, num[b]);
//
//            for(int c = 0; c < 8; c++) {
//                if(c > 3) { // number
//                    if(c - 4 == a || c - 4 == b) {
//                        continue;
//                    }
//                    s[2] = createStack(1, num[c - 4], ' ');
//                    removeSet(set, num[c-4]);
//                }
//                else { // operator
//                    s[2] = createStack(0, 0, op[c]);
//                    numOfOp++;
//                }
//
//                for(int d = 0; d < 8; d++) {
//                    if(d > 3) { // number
//                        if(inSet(set, num[d-4])) {
//                            s[3] = createStack(1, num[d - 4], ' ');
//                            removeSet(set, num[d-4]);
//                        }
//                        else {
//                            continue;
//                        }
//                    }
//                    else { // operator
//                        if(numOfOp > 1) {
//                            continue;
//                        }
//                        s[3] = createStack(0, 0, op[d]);
//                        numOfOp++;
//                    }
//
//                    for(int e = 0; e < 8; e++) {
//                        if(e > 3) { // number
//                            if(inSet(set, num[e-4])) {
//                                s[4] = createStack(1, num[e - 4], ' ');
//                                removeSet(set, num[e-4]);
//                            }
//                            else {
//                                continue;
//                            }
//                        }
//                        else { // operator
//                            s[4] = createStack(0, 0, op[e]);
//                        }
//
//                        for(int f = 0; f < 8; f++) {
//                            if(f > 3) { // number
//                                if(inSet(set, num[f-4])) {
//                                    s[5] = createStack(1, num[f - 4], ' ');
//                                    removeSet(set, num[f-4]);
//                                }
//                                else {
//                                    continue;
//                                }
//                            }
//                            else { // operator
//                                s[5] = createStack(0, 0, op[f]);
//                            }
//
//                            for(int g = 0; g < 4; g++) {
//                                s[6] = createStack(0, 0, op[g]);
//                                for(int i = 0; i < 7; i++) {
//                                    printStack(s[i]);
//                                }
//                                printf("\n");
//                            }
//                        }
//                    } // end of e
//                } // end of d
//            } // end of c
//        } // end of b
//    } // end of a
