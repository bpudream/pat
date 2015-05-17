////
////  7.2.c
////  data structure
////
////  Created by Xuchao Ding on 2015-05-16.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//
//#include <stdio.h>
//
//void insertionSortStep(int* arr, int index) {
//    int newValue = arr[index + 1];
//    int i;
//    for(i = index; i >= 0; i--) {
//        if(arr[i] > newValue) {
//            arr[i + 1] = arr[i];
//        }
//        else {
//            break;
//        }
//    }
//    arr[i + 1] = newValue;
//}
//
//void merge(int* arr, int n, int left, int length) {
//    int start = left;
//    int temp[length];
//    int leftend = left + length / 2 - 1;
//    if(leftend >= n)
//        return;
//    int right = leftend + 1;
//    int rightend = left + length - 1;
//    if(rightend >= n)
//        rightend = n - 1;
//    int tindex = 0;
//    while(left <= leftend && right <= rightend) {
//        if(arr[left] < arr[right])
//            temp[tindex++] = arr[left++];
//        else
//            temp[tindex++] = arr[right++];
//    }
//    while(left <= leftend) {
//        temp[tindex++] = arr[left++];
//    }
//    while(right <= rightend) {
//        temp[tindex++] = arr[right++];
//    }
//    
//    for(int i = 0; i < length; i++) {
//        arr[start + i] = temp[i];
//    }
//}
//
//void mergeSortStep(int* arr, int n) {
//    int length = n;
//    int counter = 1;
//    for(int i = 1; i < n; i++) {
//        if(arr[i] > arr[i - 1])
//            counter++;
//        else {
//            if(counter < length)
//                length = counter;
//            counter = 1;
//        }
//    }
////    printf("%d\n", length);
//    length *= 2;
//    for(int i = 0; i < n; i += length) {
//        merge(arr, n, i, length);
//    }
//}
//
//int main() {
//    int n;
//    scanf("%d", &n);
//    
//    int origin[n], partial[n];
//    for(int i = 0; i < n; i++) {
//        scanf("%d", &origin[i]);
//    }
//    int numOfSorted = 1;
//    int i = 0;
//    scanf("%d", &partial[i++]);
//    for(i; i < n; i++) {
//        scanf("%d", &partial[i]);
//        if(partial[i] < partial[i - 1]) {
//            numOfSorted = i - 1;
//            i++;
//            break;
//        }
//    }
//    int isInsertion = 1;
//    for(i; i < n; i++) {
//        scanf("%d", &partial[i]);
//        if(partial[i] != origin[i])
//            isInsertion = 0;
//    }
//    
//    if(isInsertion) {
//        printf("Insertion Sort\n");
//        insertionSortStep(partial, numOfSorted);
//    }
//    else {
//        printf("Merge Sort\n");
//        mergeSortStep(partial, n);
//    }
//    
//    printf("%d", partial[0]);
//    for(int i = 1; i < n; i++) {
//        printf(" %d", partial[i]);
//    }
//    
//    return 0;
//}
//
///*
// According to Wikipedia:
// 
// Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list. Each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there. It repeats until no input elements remain.
// 
// Merge sort works as follows: Divide the unsorted list into N sublists, each containing 1 element (a list of 1 element is considered sorted). Then repeatedly merge two adjacent sublists to produce new sorted sublists until there is only 1 sublist remaining.
// 
// Now given the initial sequence of integers, together with a sequence which is a result of several iterations of some sorting method, can you tell which sorting method we are using?
// 
// Input Specification:
// 
// Each input file contains one test case. For each case, the first line gives a positive integer N (<=100). Then in the next line, N integers are given as the initial sequence. The last line contains the partially sorted sequence of the N numbers. It is assumed that the target sequence is always ascending. All the numbers in a line are separated by a space.
// 
// Output Specification:
// 
// For each test case, print in the first line either "Insertion Sort" or "Merge Sort" to indicate the method used to obtain the partial result. Then run this method for one more iteration and output in the second line the resulting sequence. It is guaranteed that the answer is unique for each test case. All the numbers in a line must be separated by a space, and there must be no extra space at the end of the line.
// 
// Sample Input 1:
// 10
// 3 1 2 8 7 5 9 4 6 0
// 1 2 3 7 8 5 9 4 6 0
// Sample Output 1:
// Insertion Sort
// 1 2 3 5 7 8 9 4 6 0
// Sample Input 2:
// 10
// 3 1 2 8 7 5 9 4 0 6
// 1 3 2 8 5 7 4 9 0 6
// Sample Output 2:
// Merge Sort
// 1 2 3 8 4 5 7 9 0 6
// */