//
//  8.5.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-28.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    
    int sum = 0;
    int counter = 0;
    int next = 0;
    int root = 0;
    int a[n];
    int visited[n];

    int temp;
    for(int i = 0; i < n; i++) {
        scanf("%d", &temp);
        a[temp] = i;
        visited[i] = 0;
    }
    
    int start = 0;
    
    while(1) {
        int i;
        for(i = start; i < n; i++) {
            if(visited[i] == 0) {
                root = i;
                visited[i] = 1;
                start = i + 1;
                break;
            }
        }
        if(i == n) {
            break;
        }
        
        next = a[root];
        counter = 1;
        visited[next] = 1;
        
        while(root != next) {
            next = a[next];
            visited[next] = 1;
            counter++;
        }
        
        if(root == 0) {
            sum += (counter - 1);
        }
        else if(counter != 1) {
            sum += (counter + 1);
        }
        
  //      printf("root = %d, sum = %d\n", root,sum);
    }
    
    printf("%d\n", sum);
    
    return 0;
}


/*
 Given any permutation of the numbers {0, 1, 2,..., N-1}, it is easy to sort them in increasing order. But what if Swap(0, *) is the ONLY operation that is allowed to use? For example, to sort {4, 0, 2, 1, 3} we may apply the swap operations in the following way:
 
 Swap(0, 1) => {4, 1, 2, 0, 3}
 Swap(0, 3) => {4, 1, 2, 3, 0}
 Swap(0, 4) => {0, 1, 2, 3, 4}
 
 Now you are asked to find the minimum number of swaps need to sort the given permutation of the first N nonnegative integers.
 
 Input Specification:
 
 Each input file contains one test case, which gives a positive N (<=105) followed by a permutation sequence of {0, 1, ..., N-1}. All the numbers in a line are separated by a space.
 
 Output Specification:
 
 For each case, simply print in a line the minimum number of swaps need to sort the given permutation.
 
 Sample Input:
 10 3 5 7 2 6 4 9 0 8 1
 Sample Output:
 9
 */