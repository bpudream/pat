
//
//  4.2.c
//  data structure
//
//  Created by Xuchao Ding on 2015-04-25.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>

int findRoot(int arr[], int x) {
//    int root = -1;
    if(arr[x] > 0) {
        return arr[x];
    }
    return x;
}

int main() {
    int n;
    scanf("%d", &n);
    
    int arr[n + 1];
    for(int i = 0; i <= n; i++) {
        arr[i] = -1;
    }
    
    char c;
    while((c = getchar()) != 'S') {
        if(c == 'C') {
            int a, b;
            int ra, rb;
            scanf("%d", &a);
            scanf("%d", &b);
            ra = findRoot(arr, a);
            rb = findRoot(arr, b);
            
            if (ra == rb && ra > 0) {
                printf("yes\n");
            }
            else {
                printf("no\n");
            }
        }
        else if(c == 'I') {
            int a, b;
            int ra, rb;
            int root, connect;
            scanf("%d", &a);
            scanf("%d", &b);
            ra = findRoot(arr, a);
            rb = findRoot(arr, b);
            
            if(arr[ra] < arr[rb]) { // connect b to a
                root = ra;
                connect = rb;
            }
            else {
                root = rb;
                connect = ra;
            }
            for(int i = 1; i <= n; i++) {
                if(findRoot(arr, i) == connect) {
                    arr[i] = root;
                    arr[root]--;
                }
            }
        }
    }
    
    // end
    int counter = 0;
    for(int i = 1; i <= n; i++) {
        if(arr[i] < 0) {
            counter++;
        }
    }
    if(counter == 1) {
        printf("The network is connected.\n");
    }
    else {
        printf("There are %d components.\n", counter);
    }
    return 0;
}



/*
 We have a network of computers and a list of bi-directional connections. Each of these connections allows a file transfer from one computer to another. Is it possible to send a file from any computer on the network to any other?
 
 Input Specification:
 
 Each input file contains one test case. For each test case, the first line contains N (2<=N<=104), the total number of computers in a network. Each computer in the network is then represented by a positive integer between 1 and N. Then in the following lines, the input is given in the format:
 
 I c1 c2
 where I stands for inputting a connection between c1 and c2; or
 
 C c1 c2
 where C stands for checking if it is possible to transfer files between c1 and c2; or
 
 S
 where S stands for stopping this case.
 
 Output Specification:
 
 For each C case, print in one line the word "yes" or "no" if it is possible or impossible to transfer files between c1 and c2, respectively. At the end of each case, print in one line "The network is connected." if there is a path between any pair of computers; or "There are k components." where k is the number of connected components in this network.
 
 Sample Input 1:
 5
 C 3 2
 I 3 2
 C 1 5
 I 4 5
 I 2 4
 C 3 5
 S
 Sample Output 1:
 no
 no
 yes
 There are 2 components.
 Sample Input 2:
 5
 C 3 2
 I 3 2
 C 1 5
 I 4 5
 I 2 4
 C 3 5
 I 1 3
 C 1 5
 S
 Sample Output 2:
 no
 no
 yes
 yes
 The network is connected.
*/