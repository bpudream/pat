//
//  4.tree.7.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-05.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

int isMax(int* arr, int n) {
    int res = 1;
    int max = arr[0];
    for(int i = 1; i < n; i++)
        if(arr[i] > max) {
            res = 0;
            break;
        }
    return res;
}

int isMin(int* arr, int n) {
    int res = 1;
    int min = arr[0];
    for(int i = 1; i < n; i++)
        if(arr[i] < min) {
            res = 0;
            break;
        }
    return res;
}

int main() {
    int iter, n;
    scanf("%d", &iter);
    scanf("%d", &n);
    int arr[n];
    for(int k = 0; k < iter; k++) {
        for(int i = 0; i < n; i++) {
            scanf("%d", &arr[i]);
        }
        int valid = 1;
        for(int i = 0; i < n - 2; i++) {
            int test;
            if(arr[i] > arr[i + 1])
                test = isMax(arr + i, n - i);
            else
                test = isMin(arr + i, n - i);
            if(!test) {
                valid = 0;
                break;
            }
        }
        
        if(valid)
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}

/*
To search a key in a binary search tree, we start from the root and move all the way down, choosing branches according to the comparison results of the keys. The searching path corresponds to a sequence of keys. For example, following {1, 4, 2, 3} we can find 3 from a binary search tree with 1 as its root. But {2, 4, 1, 3} is not such a path since 1 is in the right subtree of the root 2, which breaks the rule for a binary search tree. Now given a sequence of keys, you are supposed to tell whether or not it indeed correspnds to a searching path in a binary search tree.

Input Specification:

Each input file contains one test case. For each case, the first line gives two positive integers N and M (<=100) which are the total number of sequences, and the size of each sequence, respectively. Then N lines follow, each gives a sequence of keys. It is assumed that the keys are numbered from 1 to M.

Output Specification:

For each sequence, print in a line "YES" if the sequence does correspnd to a searching path in a binary search tree, or "NO" if not.

Sample Input:
3 4
1 4 2 3
2 4 1 3
3 2 4 1
Sample Output:
YES
NO
NO
*/