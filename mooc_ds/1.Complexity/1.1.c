//
//  1.1.c
//  data structure
//
//  Created by Xuchao Ding on 2015-01-05.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

/*
 给定K个整数组成的序列{ N1, N2, ..., NK }，“连续子列”被定义为{ Ni, Ni+1, ..., Nj }，其中 1 <= i <= j <= K。“最大子列和”则被定义为所有连续子列元素的和中最大者。例如给定序列{ -2, 11, -4, 13, -5, -2 }，其连续子列{ 11, -4, 13 }有最大的和20。现要求你编写程序，计算给定整数序列的最大子列和。
 */

#include <stdio.h>

int maxSubSeries(int n, int* a) {
    int sum = a[0];
    int max = 0;
    int i = 1;
    while(i < n) {
        if(sum >= 0) {
            sum += a[i];
        }
        else {
            sum = a[i];
        }
        if(sum > max) {
            max = sum;
        }
        i++;
    }
    return max;
}

int main() {
    int n = 0;
    scanf("%d", &n);
    int a[n];
    
    int i = 0;
    while(i < n) {
        scanf("%d", &a[i]);
        i++;
    }
    
    int max = maxSubSeries(n, a);
    printf("%d", max);
    
    return 0;
}