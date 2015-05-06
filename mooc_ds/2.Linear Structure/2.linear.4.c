
  2.linear.4.c
  data structure

  Created by Xuchao Ding on 2015-05-06.
  Copyright (c) 2015 Xuchao Ding. All rights reserved.


#include <stdio.h>
#include <stdlib.h>

typedef struct _stack {
    int value;
    struct _stack* next;
} Stack;

Stack* createNode(int n) {
    Stack* res = (Stack*)malloc(sizeof(Stack));
    res->value = n;
    res->next = NULL;
    return res;
}

void push(Stack* s, int value) {
    Stack* node = createNode(value);
    node->next = s->next;
    s->next = node;
}

int pop(Stack* s) {
    int res = -255;
    if(s->next) {
        Stack* temp = s->next;
        res = temp->value;
        s->next = temp->next;
        free(temp);
    }
    return res;
}

int main() {
    int n, m;
    int maxsize;
    scanf("%d", &maxsize);
    scanf("%d", &n);
    scanf("%d", &m);
    
    for(int i = 0; i < m; i++) {
        int value = 1;
        int input;
        int size = 0;
        int res = 1;
        Stack* stack = createNode(-255);
        
        for(int j = 0; j < n; j++) {
            scanf("%d", &input);
            if(res) {
                if(input > value) {
                    while(input >= value) {
                        if(size >= maxsize)
                            res = 0;
                        push(stack, value++);
                        size++;
                    }
                    pop(stack);
                    size--;
                }
                else if(input == value) {
                    if(size >= maxsize)
                        res = 0;
                    value++;
                }
                else {
                    int x = pop(stack);
                    size--;
                    if(x != input)
                        res = 0;
                }
            }
        }
        
        if(res)
            printf("YES\n");
        else
            printf("NO\n");
        
        free(stack);
    }
    return 0;
}


/*
Given a stack which can keep M numbers at most. Push N numbers in the order of 1, 2, 3, ..., N and pop randomly. You are supposed to tell if a given sequence of numbers is a possible pop sequence of the stack. For example, if M is 5 and N is 7, we can obtain 1, 2, 3, 4, 5, 6, 7 from the stack, but not 3, 2, 1, 7, 5, 6, 4.

Input Specification:

Each input file contains one test case. For each case, the first line contains 3 numbers (all no more than 1000): M (the maximum capacity of the stack), N (the length of push sequence), and K (the number of pop sequences to be checked). Then K lines follow, each contains a pop sequence of N numbers. All the numbers in a line are separated by a space.

Output Specification:

For each pop sequence, print in one line "YES" if it is indeed a possible pop sequence of the stack, or "NO" if not.

Sample Input:
5 7 5
1 2 3 4 5 6 7
3 2 1 7 5 6 4
7 6 5 4 3 2 1
5 6 4 3 7 2 1
1 7 6 5 4 3 2
Sample Output:
YES
NO
NO
YES
NO
*/