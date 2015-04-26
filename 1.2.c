////
////  1.2.c
////  data structure
////
////  Created by Xuchao Ding on 2015-01-05.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//
///*
// Given a sequence of K integers { N1, N2, ..., NK }. A continuous subsequence is defined to be { Ni, Ni+1, ..., Nj } where 1 <= i <= j <= K. The Maximum Subsequence is the continuous subsequence which has the largest sum of its elements. For example, given sequence { -2, 11, -4, 13, -5, -2 }, its maximum subsequence is { 11, -4, 13 } with the largest sum being 20.
// 
// Now you are supposed to find the largest sum, together with the first and the last numbers of the maximum subsequence.
// 
// Input Specification:
// 
// Each input file contains one test case. Each case occupies two lines. The first line contains a positive integer K (<= 10000). The second line contains K numbers, separated by a space.
// 
// Output Specification:
// 
// For each test case, output in one line the largest sum, together with the first and the last numbers of the maximum subsequence. The numbers must be separated by one space, but there must be no extra space at the end of a line. In case that the maximum subsequence is not unique, output the one with the smallest indices i and j (as shown by the sample case). If all the K numbers are negative, then its maximum sum is defined to be 0, and you are supposed to output the first and the last numbers of the whole sequence.
// 
// Sample Input:
// 10
// -10 1 2 3 4 -5 -23 3 7 -21
// Sample Output:
// 10 1 4
// */
//
//
//#include <stdio.h>
//
//void maxSubSeries(int n, int* a, int* res) {
//    int sum = 0;
//    int max = -1;
//    int currentfirst = 0;
//    int first = 0;
//    int last = n - 1;
//    int i = 0;
//    while(i < n) {
//        if(sum >= 0) {
//            sum += a[i];
//        }
//        else {
//            sum = a[i];
//            currentfirst = i;
//        }
//        if(sum > max) {
//            max = sum;
//            first = currentfirst;
//            last = i;
//        }
//        i++;
//    }
//    
//    if(max < 0) {
//        max = 0;
//        first = 0;
//        last = n - 1;
//    }
//
//    res[0] = max;
//    res[1] = first;
//    res[2] = last;
//}
//
//int main() {
//    int res[3];
//    int n = 0;
//    scanf("%d", &n);
//    int a[n];
//    
//    int i = 0;
//    while(i < n) {
//        scanf("%d", &a[i]);
//        i++;
//    }
//    
//    maxSubSeries(n, a, res);
//    printf("%d %d %d", res[0], a[res[1]], a[res[2]]);
//    
//    return 0;
//}