////
////  c11.0.c
////  data structure
////
////  Created by Xuchao Ding on 2015-05-17.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//
//#include <stdio.h>
//
//int main() {
//    double x1, y1, x2, y2;
//    scanf("%lf", &x1);
//    scanf("%lf", &y1);
//    scanf("%lf", &x2);
//    scanf("%lf", &y2);
//    
//    double x = (x1 + x2) * 10;
//    int xi = (int)x;
//    if(x - xi >= 0.5) {
//        xi++;
//    }
//    else if(x - xi <= -0.5) {
//        xi--;
//    }
//    x = xi / 10.0;
//    
//    double y = (y1 + y2) * 10;
//    int yi = (int)y;
//    if(y - yi >= 0.5) {
//        yi++;
//    }
//    else if(y - yi <= -0.5) {
//        yi--;
//    }
//    y = yi / 10.0;
//    
//    printf("(%.1f, %.1f)", x, y);
//    return 0;
//}
//
///*
// 本题要求编写程序，计算两个二维平面向量的和向量。
// 
// 输入格式：
// 
// 输入在一行中按照“x1 y1 x2 y2”的格式给出两个二维平面向量V1=(x1, y1)和V2=(x2, y2)的分量。
// 
// 输出格式：
// 
// 在一行中按照“(x, y)”的格式输出和向量，坐标输出小数点后1位（注意不能输出-0.0）。
// 
// 输入样例：
// 3.5 -2.7 -13.9 8.7
// 输出样例：
// (-10.4, 6.0)
// */