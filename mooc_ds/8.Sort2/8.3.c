//
//  8.3.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-19.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

typedef struct {
    int id;
    int virtue;
    int talent;
} Human;

typedef struct _list {
    int value;
    struct _list* next;
} List;

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int compare(Human a, Human b) {
    int res = 0;
    
    int psum = a.virtue + a.talent;
    int nsum = b.virtue + b.talent;
    if(psum > nsum) {
        res = 1;
    }
    else if(psum == nsum) {
        if(a.virtue > b.virtue) {
            res = 1;
        }
        else if(a.virtue == b.virtue && a.id < b.id) {
            res = 1;
        }
        else {
            res = -1;
        }
    }
    else {
        res = -1;
    }
    
    return res;
}

void siftup(Human* arr, int* indices, int n) {
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

void siftdown(Human* arr, int* indices, int current, int n) {
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

void HeapSort(Human* arr, int* indices, int n) {
    while(n > 0) {
        swap(&indices[0], &indices[--n]);
        siftdown(arr, indices, 0, n);
    }
}

int main() {
    int n, low, high;
    scanf("%d %d %d", &n, &low, &high);
    Human array[n];
    int indices[n];
    int counter = 0;
    
    for(int i = 0; i < n; i++) {
        int id, v, t;
        scanf("%d", &id);
        scanf("%d", &v);
        scanf("%d", &t);
        if(v >= low && t >= low) {
            array[counter].id = id;
            array[counter].virtue = v;
            array[counter].talent = t;
            indices[counter] = counter;
            siftup(array, indices, counter);
            counter++;
        }
    }
    
    HeapSort(array, indices, counter);
    
    int sage[counter];
    int noble[counter];
    int fool[counter];
    int villian[counter];
    int si = 0;
    int ni = 0;
    int fi = 0;
    int vi = 0;
    
    for(int i = 0; i < counter; i++) {
        Human david = array[indices[i]];
        if(david.virtue >= high) {
            if(david.talent >= high)
                sage[si++] = indices[i];
            else
                noble[ni++] = indices[i];
        }
        else {
            if(david.virtue < david.talent)
                villian[vi++] = indices[i];
            else
                fool[fi++] = indices[i];
        }
    }
    
    printf("%d\n", counter);
    
    for(int i = 0; i < si; i++) {
        Human david = array[sage[i]];
        printf("%d %d %d\n", david.id, david.virtue, david.talent);
    }
    for(int i = 0; i < ni; i++) {
        Human david = array[noble[i]];
        printf("%d %d %d\n", david.id, david.virtue, david.talent);
    }
    for(int i = 0; i < fi; i++) {
        Human david = array[fool[i]];
        printf("%d %d %d\n", david.id, david.virtue, david.talent);
    }
    for(int i = 0; i < vi; i++) {
        Human david = array[villian[i]];
        printf("%d %d %d\n", david.id, david.virtue, david.talent);
    }
    
    return 0;
}
/*
 08-排序3. Talent and Virtue (25)
 
 About 900 years ago, a Chinese philosopher Sima Guang wrote a history book in which he talked about people's talent and virtue. According to his theory, a man being outstanding in both talent and virtue must be a "sage（圣人）"; being less excellent but with one's virtue outweighs talent can be called a "nobleman（君子）"; being good in neither is a "fool man（愚人）"; yet a fool man is better than a "small man（小人）" who prefers talent than virtue.
 
 Now given the grades of talent and virtue of a group of people, you are supposed to rank them according to Sima Guang's theory.
 
 Input Specification:
 
 Each input file contains one test case. Each case first gives 3 positive integers in a line: N (<=105), the total number of people to be ranked; L (>=60), the lower bound of the qualified grades -- that is, only the ones whose grades of talent and virtue are both not below this line will be ranked; and H (<100), the higher line of qualification -- that is, those with both grades not below this line are considered as the "sages", and will be ranked in non-increasing order according to their total grades. Those with talent grades below H but virtue grades not are cosidered as the "noblemen", and are also ranked in non-increasing order according to their total grades, but they are listed after the "sages". Those with both grades below H, but with virtue not lower than talent are considered as the "fool men". They are ranked in the same way but after the "noblemen". The rest of people whose grades both pass the L line are ranked after the "fool men".
 
 Then N lines follow, each gives the information of a person in the format:
 
 ID_Number Virtue_Grade Talent_Grade
 where ID_Number is an 8-digit number, and both grades are integers in [0, 100]. All the numbers are separated by a space.
 Output Specification:
 
 The first line of output must give M (<=N), the total number of people that are actually ranked. Then M lines follow, each gives the information of a person in the same format as the input, according to the ranking rules. If there is a tie of the total grade, they must be ranked with respect to their virtue grades in non-increasing order. If there is still a tie, then output in increasing order of their ID's.
 
 Sample Input:
 14 60 80
 10000001 64 90
 10000002 90 60
 10000011 85 80
 10000003 85 80
 10000004 80 85
 10000005 82 77
 10000006 83 76
 10000007 90 78
 10000008 75 79
 10000009 59 90
 10000010 88 45
 10000012 80 100
 10000013 90 99
 10000014 66 60
 Sample Output:
 12
 10000013 90 99
 10000012 80 100
 10000003 85 80
 10000011 85 80
 10000004 80 85
 10000007 90 78
 10000006 83 76
 10000005 82 77
 10000002 90 60
 10000014 66 60
 10000008 75 79
 10000001 64 90
*/