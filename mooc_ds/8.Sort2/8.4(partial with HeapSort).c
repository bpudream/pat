//
//  8.4.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-19.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

#define STRING_LENGTH 10

typedef struct {
    char name[STRING_LENGTH];
    int age;
    int wealth;
} Rich;

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int strCmp(char* a, char* b) {
    int res = 0;
    for(int i = 0; i < STRING_LENGTH; i++) {
        if(a[i] == '\0' || b[i] == '\0') {
            return a[i] - b[i];
        }
        res = a[i] - b[i];
        if(res == 0)
            continue;
        else
            break;
    }
    return res;
}

int compare(Rich a, Rich b) {
    if(a.wealth != b.wealth)
        return a.wealth - b.wealth;
    else if(a.age != b.age)
        return b.age - a.age;
    else
        return strCmp(b.name, a.name);
}

void siftup(Rich* arr, int* indices, int n) {
    int parent;
    while(n > 0) {
        parent = (n - 1) / 2;
        if(compare(arr[indices[parent]], arr[indices[n]]) > 0) {
            swap(&indices[parent], &indices[n]);
            n = parent;
        }
        else {
            break;
        }
    }
}

void siftdown(Rich* arr, int* indices, int current, int n) {
    int next = current * 2 + 1;
    while(next < n) {
        if(next + 1 < n && (compare(arr[indices[next + 1]], arr[indices[next]]) < 0))
            next = next + 1;
        if(compare(arr[indices[next]], arr[indices[current]]) < 0) {
            swap(&indices[next], &indices[current]);
            current = next;
            next = 2 * current + 1;
        }
        else
            break;
    }
}

void HeapSort(Rich* arr, int* indices, int n) {
    while(n > 0) {
        swap(&indices[0], &indices[--n]);
        siftdown(arr, indices, 0, n);
    }
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    Rich array[n];
    int indices[n];
    
    for(int i = 0; i < n; i++) {
        indices[i] = i;
        scanf("%s", array[i].name);
        scanf("%d", &array[i].age);
        scanf("%d", &array[i].wealth);
        siftup(array, indices, i);
    }
    
    HeapSort(array, indices, n);
    
    for(int i = 1; i <= k; i++) {
        int num, min, max;
        scanf("%d %d %d", &num, &min, &max);
        printf("Case #%d:\n", i);
        int counter = 0;
        int iter = 0;
        int notFound = 1;
        while(counter < num) {
            if(iter >= n)
                break;
            Rich david = array[indices[iter]];
            if(david.age >= min && david.age <= max) {
                notFound = 0;
                printf("%s %d %d\n", david.name, david.age, david.wealth);
                counter++;
            }
            iter++;
        }
        if(notFound)
            printf("None\n");
    }
    
    return 0;
}

/*
 08-排序4. The World's Richest (25)
 
 Forbes magazine publishes every year its list of billionaires based on the annual ranking of the world's wealthiest people. Now you are supposed to simulate this job, but concentrate only on the people in a certain range of ages. That is, given the net worths of N people, you must find the M richest people in a given range of their ages.
 
 Input Specification:
 
 Each input file contains one test case. For each case, the first line contains 2 positive integers: N (<=105) - the total number of people, and K (<=103) - the number of queries. Then N lines follow, each contains the name (string of no more than 8 characters without space), age (integer in (0, 200]), and the net worth (integer in [-106, 106]) of a person. Finally there are K lines of queries, each contains three positive integers: M (<= 100) - the maximum number of outputs, and [Amin, Amax] which are the range of ages. All the numbers in a line are separated by a space.
 
 Output Specification:
 
 For each query, first print in a line "Case #X:" where X is the query number starting from 1. Then output the M richest people with their ages in the range [Amin, Amax]. Each person's information occupies a line, in the format
 
 Name Age Net_Worth
 The outputs must be in non-increasing order of the net worths. In case there are equal worths, it must be in non-decreasing order of the ages. If both worths and ages are the same, then the output must be in non-decreasing alphabetical order of the names. It is guaranteed that there is no two persons share all the same of the three pieces of information. In case no one is found, output "None".
 Sample Input:
 12 4
 Zoe_Bill 35 2333
 Bob_Volk 24 5888
 Anny_Cin 95 999999
 Williams 30 -22
 Cindy 76 76000
 Alice 18 88888
 Joe_Mike 32 3222
 Michael 5 300000
 Rosemary 40 5888
 Dobby 24 5888
 Billy 24 5888
 Nobody 5 0
 4 15 45
 4 30 35
 4 5 95
 1 45 50
 Sample Output:
 Case #1:
 Alice 18 88888
 Billy 24 5888
 Bob_Volk 24 5888
 Dobby 24 5888
 Case #2:
 Joe_Mike 32 3222
 Zoe_Bill 35 2333
 Williams 30 -22
 Case #3:
 Anny_Cin 95 999999
 Michael 5 300000
 Alice 18 88888
 Cindy 76 76000
 Case #4:
 None
 */