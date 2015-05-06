//
//  4.tree.8.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-05.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct _stack {
    int value;
    struct _stack* next;
} Stack;

Stack* createNode(int value) {
    Stack* res = (Stack*)malloc(sizeof(Stack));
    res->value = value;
    res->next = NULL;
    return res;
}

int isEmpty(Stack* s) {
    int res = 0;
    if(!s->next)
        res = 1;
    return res;
}

void push(Stack* s, int value) {
    Stack* n = createNode(value);
    n->next = s->next;
    s->next = n;
}

int pop(Stack* s) {
    int res = 0;
    Stack* temp;
    if(s->next) {
        temp = s->next;
        s->next = temp->next;
        res = temp->value;
        free(temp);
    }
    return res;
}

void siftdown(int* heap, int n, int index) {
    while(index * 2 + 1 < n) {
        int next = index * 2 + 1;
        if(next + 1 < n && heap[next + 1] > heap[next]) {
            next = next + 1;
        }
        if(heap[index] < heap[next]) {
            int temp = heap[index];
            heap[index] = heap[next];
            heap[next] = temp;
            index = next;
        }
        else {
            return;
        }
    }
}

void delete(int* heap, int n) {
    int temp = heap[0];
    heap[0] = heap[n - 1];
    heap[n - 1] = temp;
    siftdown(heap, n - 1, 0);
}

void siftup(int* heap, int index) {
    while(index > 0) {
        int parent = (index - 1) / 2;
        if(heap[parent] < heap[index]) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
        }
        else {
            return;
        }
    }
}

void insert(int* heap, int n, int value) {
    heap[n] = value;
    siftup(heap, n);
}

void heapsort1(int* a, int n) {
    for(int i = 0; i < n - 1; i++) {
        delete(a, n - i);
    }
}

/*
 Given a complete binary search tree, get the root of this tree.
 */
//int getRoot(int n) {
//    if(n == 1) {
//        return 0;
//    }
//    int x;
//    if(x == sqrt(n + 1)) {
//        x = sqrt(n + 1) - 1;
//    }
//    else {
//        x = sqrt(n + 1);
//    }
//    int fullLeaves = pow(2, x);
//    int leaves = n - (fullLeaves - 1);
//    int diff;
//    if (leaves <= fullLeaves / 2) {
//        diff = leaves;
//    }
//    else {
//        diff = fullLeaves - leaves;
//    }
//    
//    int right = (n - 1 - diff) / 2;
//    int left = right + diff;
//    
//    return left;
//}

int getLeft(int x, int n) {
    int res = x * 2 + 1;
    if(!(res < n))
        res = 0;
    return res;
}

int getRight(int x, int n) {
    int res = x * 2 + 2;
    if(!(res < n))
        res = 0;
    return res;
}

int main() {
    int n;
    scanf("%d", &n);
    
    int a[n];
    scanf("%d", &a[0]);
    for(int i = 1; i < n; i++) {
        scanf("%d", &a[i]);
        siftup(a, i);
    }
    
    heapsort1(a, n);
  
    int cbst[n];
    for(int i = 0; i < n; i++) {
        cbst[i] = -1;
    }
    
    Stack* stack = createNode(-1);
    int index = 0;
    
    /*
     * This is mid-order traversal on complete binary
     * search tree with values ranging from 0 to n-1.
     * The stack size is no larger than log(n)
     */
    push(stack, 0);
    
    while(!isEmpty(stack)) {
        int self = stack->next->value;
        int left = getLeft(self, n);
        if(left && cbst[left] < 0) {
            push(stack, left);
        }
        else {
            pop(stack);
            cbst[self] = index++;
            int right = getRight(self, n);
            if(right)
                push(stack, right);
        }
    }
    
    for(int i = 0; i < n; i++) {
        cbst[i] = a[cbst[i]];
    }
    
    for(int i = 0; i < n; i++) {
        if(i == 0)
            printf("%d", cbst[i]);
        else
            printf(" %d", cbst[i]);
    }
    
    return 0;
}

/*
A Binary Search Tree (BST) is recursively defined as a binary tree which has the following properties:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
A Complete Binary Tree (CBT) is a tree that is completely filled, with the possible exception of the bottom level, which is filled from left to right.

Now given a sequence of distinct non-negative integer keys, a unique BST can be constructed if it is required that the tree must also be a CBT. You are supposed to output the level order traversal sequence of this BST.

Input Specification:

Each input file contains one test case. For each case, the first line contains a positive integer N (<=1000). Then N distinct non-negative integer keys are given in the next line. All the numbers in a line are separated by a space and are no greater than 2000.

Output Specification:

For each test case, print in one line the level order traversal sequence of the corresponding complete binary search tree. All the numbers in a line must be separated by a space, and there must be no extra space at the end of the line.

Sample Input:
10
1 2 3 4 5 6 7 8 9 0
Sample Output:
6 3 8 1 5 7 9 0 2 4
*/