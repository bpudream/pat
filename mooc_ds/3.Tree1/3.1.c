//
//  3.1.c
//  data structure
//
//  Created by Xuchao Ding on 2015-01-09.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

#define length 4

double a[length];

double f(double x) {
    double res = a[0];
    for(int i = 1; i < length; i++) {
        res = res * x + a[i];
    }
    return res;
}

int main() {

//    double a[length];
    double m , n;
    
    for(int i = 0; i < 4; i++) {
        scanf("%lf", &a[i]);
    }
    
    scanf("%lf", &m);
    scanf("%lf", &n);
    
    double value = f(m);
    
    while(n - m > 0.001) {
        value = f((m + n) / 2);
        if(value == 0) {
            break;
        }
        else if(f(m) * value < 0) {
            n = (m + n) / 2;
        }
        else {
            m = (m + n) / 2;
        }
    }
    
    printf("%.2f", (m + n) / 2);
    
    return 0;
}
/*
 二分法求函数根的原理为：如果连续函数f(x)在区间[a, b]的两个端点取值异号，即f(a)f(b)<0，则它在这个区间内至少存在1个根r，即f(r)=0。
 
 二分法的步骤为：
 
 检查区间长度，如果小于给定阈值，则停止，输出区间中点(a+b)/2；否则
 如果f(a)f(b)<0，则计算中点的值f((a+b)/2)；
 如果f((a+b)/2)正好为0，则(a+b)/2就是要求的根；否则
 如果f((a+b)/2)与f(a)同号，则说明根在区间[(a+b)/2, b]，令a=(a+b)/2，重复循环；
 如果f((a+b)/2)与f(b)同号，则说明根在区间[a, (a+b)/2]，令b=(a+b)/2，重复循环；
 本题目要求编写程序，计算给定3阶多项式f(x)=a3x3+a2x2+a1x+a0在给定区间[a, b]内的根。
 
 输入格式：
 
 输入在第1行中顺序给出多项式的4个系数a3、a2、a1、a0，在第2行中顺序给出区间端点a和b。题目保证多项式在给定区间内存在唯一单根。
 
 输出格式：
 
 在一行中输出该多项式在该区间内的根，精确到小数点后2位。
 
 输入样例：
 3 -1 -3 1
 -0.5 0.5
 输出样例：
 0.33

 */