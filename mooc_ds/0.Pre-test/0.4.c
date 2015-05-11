//
//  0.4.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-06.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

void sort(int* a, int n) {
    for(int i = 0; i < n - 1; i++) {
        for(int j = i + 1; j < n; j++) {
            if(a[j] < a[i]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}

int main() {
    char c;
//    int digit;
    int num[24];
    int res[24];
    int output[24];
    
    int counter = 0;
    while((c = getchar()) != '\n') {
        num[counter++] = c - '0';
    }
    
    res[0] = num[0] * 2;
    for(int i = 1; i < counter; i++) {
        if(num[i] > 4) {
            res[i] = 2 * num[i] - 10;
            res[i - 1] += 1;
        }
        else
            res[i] = num[i] * 2;
    }
    
    for(int i = 0; i < counter; i++) {
        output[i] = res[i];
    }
    
    if(res[0] > 9) {
        printf("No\n");
    }
    else {
        int flag = 1;
        sort(num, counter);
        sort(res, counter);
        for(int j = 0; j < counter && flag; j++) {
            if(num[j] != res[j])
                flag = 0;
        }
        if(flag)
            printf("Yes\n");
        else
            printf("No\n");
    }
    
    
    for(int i = 0; i < counter; i++) {
        printf("%d", output[i]);
    }
    
    return 0;
}

/*
 Notice that the number 123456789 is a 9-digit number consisting exactly the numbers from 1 to 9, with no duplication. Double it we will obtain 246913578, which happens to be another 9-digit number consisting exactly the numbers from 1 to 9, only in a different permutation. Check to see the result if we double it again!
 
 Now you are suppose to check if there are more numbers with this property. That is, double a given number with k digits, you are to tell if the resulting number consists of only a permutation of the digits in the original number.
 
 Input Specification:
 
 Each input file contains one test case. Each case contains one positive integer with no more than 20 digits.
 
 Output Specification:
 
 For each test case, first print in a line "Yes" if doubling the input number gives a number that consists of only a permutation of the digits in the original number, or "No" if not. Then in the next line, print the doubled number.
 
 Sample Input:
 1234567899
 Sample Output:
 Yes
 2469135798
 */