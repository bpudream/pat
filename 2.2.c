////
////  2.2.c
////  data structure
////
////  Created by Xuchao Ding on 2015-01-06.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//
//#include <stdio.h>
//
//typedef struct _poly {
//    int coeff;
//    int exponent;
//    struct _poly* next;
//} Poly;
//
//void diff(Poly* head) {
//    Poly* iter = head->next;
//    while(iter) {
//        int a = iter->coeff;
//        int b = iter->exponent;
//        a *= (b--);
//        
//        iter->coeff = a;
//        iter->exponent = b;
//            
//        iter = iter->next;
//    }
//}
//
//void print(Poly* head, int length) {
//    Poly* iter = head->next;
//    int printed = 0;
//    for(int i = 0; i < length - 1; i++) {
//        if(iter->coeff != 0) {
//            if(printed) {
//                printf(" ");
//            }
//            printf("%d %d", iter->coeff, iter->exponent);
//            printed = 1;
//        }
//        iter = iter->next;
//    }
//    if(iter->coeff != 0) {
//        if(printed) {
//            printf(" ");
//        }
//        printf("%d %d", iter->coeff, iter->exponent);
//    }
//}
//
//int main() {
//    char c;
////    char blank[] = "";
//    int length = 0;
//    int a, b;
//    Poly* head = (Poly*)(malloc(sizeof(Poly)));
//    Poly* temp = head;
//    
//    do {
//        scanf("%d %d", &a, &b);
//        length++;
//        
//        Poly* p = (Poly*)(malloc(sizeof(Poly)));
//        p->coeff = a;
//        p->exponent = b;
//        p->next = NULL;
//        temp->next = p;
//        temp = p;
//        
//    } while((c = getchar()) != '\n');
//    
//    if(length == 1 && head->next->exponent == 0) {
//        printf("0 0");
//    }
//    else {
//        diff(head);
//        print(head, length);
//    }
//    
//    return 0;
//}
//
//
///*
// 设计函数求一元多项式的导数。
// 
// 输入格式：以指数递降方式输入多项式非零项系数和指数（绝对值均为不超过1000的整数）。数字间以空格分隔。
// 
// 输出格式：以与输入相同的格式输出导数多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。注意“零多项式”的指数和系数都是0，但是表示为“0 0”。
// 
// 输入样例：
// 3 4 -5 2 6 1 -2 0
// 输出样例：
// 12 3 -10 1 6 0
//*/