//
//  7.1.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-17.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

void insertionSort(long* arr, int index) {
    long value = arr[index];
    int i;
    for(i = index - 1; i >= 0; i--) {
        if(arr[i] > value)
            arr[i + 1] = arr[i];
        else
            break;
    }
    arr[i + 1] = value;
}

void siftup(long* arr, int index) {
    int parent = (index - 1) / 2;
    long temp;
    while(parent >= 0) {
        if(arr[parent] < arr[index]) {
            temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
        }
        else {
            return;
        }
        index = parent;
        parent = (index - 1) / 2;
    }
}

void siftdown(long* arr, int n, int index) {
    int next = index * 2 + 1;
    while(next < n) {
        if(next + 1 < n && arr[next + 1] > arr[next])
            next++;
        if(arr[next] > arr[index]) {
            long temp = arr[next];
            arr[next] = arr[index];
            arr[index] = temp;
            index = next;
            next = index * 2 + 1;
        }
        else
            return;
    }
}

void delete(long* arr, int n) {
    long temp = arr[n - 1];
    arr[n - 1] = arr[0];
    arr[0] = temp;
}

void heapSort(long* arr, int n) {
    for(int i = n; i > 0; i--) {
        delete(arr, i);
        siftdown(arr, i - 1, 0);
    }
}

int main() {
    int n;
    scanf("%d", &n);
    
    long arr[n];
    
    for(int i = 0; i < n; i++) {
        scanf("%ld", &arr[i]);
        siftup(arr, i);
    }
    
    heapSort(arr, n);
    
    printf("%ld", arr[0]);
    for(int i = 1; i < n; i++)
        printf(" %ld", arr[i]);
    
    return 0;
}

/*
 给定N个（长整型范围内的）整数，要求输出从小到大排序后的结果。
 
 本题旨在测试各种不同的排序算法在各种数据情况下的表现。各组测试数据特点如下：
 
 数据0：只有1个元素；
 数据1：11个不相同的整数，测试基本正确性；
 数据2：10^3个随机整数；
 数据3：10^4个随机整数；
 数据4：10^5个随机整数；
 数据5：10^5个顺序整数；
 数据6：10^5个逆序整数；
 数据7：10^5个基本有序的整数；
 数据8：10^5个随机正整数，每个数字不超过1000。
 输入格式：
 
 输入第一行给出正整数N（<= 10^5），随后一行给出N个（长整型范围内的）整数，其间以空格分隔。
 
 输出格式：
 
 在一行中输出从小到大排序后的结果，数字间以1个空格分隔，行末不得有多余空格。
 
 输入样例：
 11
 4 981 10 -17 0 -20 29 50 8 43 -5
 输出样例：
 -20 -17 -5 0 4 8 10 29 43 50 981
 */