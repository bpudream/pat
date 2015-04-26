////
////  2.3.c
////  data structure
////
////  Created by Xuchao Ding on 2015-01-07.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//
//#include <stdio.h>
//
//typedef struct _stack {
//    int flag;
//    int value;
//    char op;
//    struct _stack* next;
//} Stack;
//
//int isEmpty(Stack head) {
//    int res = 0;
//    if(head.next) {
//        res = 1;
//    }
//    return res;
//}
//
//Stack* pop(Stack* head) {
//    if(!isEmpty(*head)) {
//        Stack* temp = head;
//        
//    }
//}
//
///*
// 算术表达式有前缀表示法、中缀表示法和后缀表示法等形式。前缀表达式指二元运算符位于两个运算数之前，例如2+3*(7-4)+8/4的前缀表达式是：+ + 2 * 3 - 7 4 / 8 4。请设计程序计算前缀表达式的结果值。
// 
// 输入格式说明：
// 
// 输入在一行内给出不超过30个字符的前缀表达式，只包含+、-、*、\以及运算数，不同对象（运算数、运算符号）之间以空格分隔。
// 
// 输出格式说明：
// 
// 输出前缀表达式的运算结果，精确到小数点后1位，或错误信息“ERROR”。
// 
//*/