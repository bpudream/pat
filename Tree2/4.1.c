//
//  4.1.c
//  data structure
//
//  Created by Xuchao Ding on 2015-04-24.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _tree {
    int value;
    //int balance;
    struct _tree* left;
    struct _tree* right;
} Tree;

typedef struct _queue {
    Tree* head;
    struct _queue* next;
} Queue;

Tree* traversal(Tree* t);

void enqueue(Queue* q, Tree* value) {
    Queue *temp = q;
    while(temp->next) {
        temp = temp->next;
    }
    temp->next = (Queue*)malloc(sizeof(Queue));
    temp->next->head = value;
    temp->next->next = NULL;
}

Tree* dequeue(Queue* q) {
    Tree* value;
    if(!q->next) {
        value = NULL;
    }
    else {
        value = q->next->head;
        q->next = q->next->next;
    }
    return value;
}

Tree* find(Tree* root, int value) {
    if(root == NULL) {
        return root;
    }
    else if(value == root->value) {
        return root;
    }
    else if(value < root->value) {
        return find(root->left, value);
    }
    else {
        return find(root->right, value);
    }
}

Tree* min(Tree* t) {
    if(!t) {
        return NULL;
    }
    else {
        Tree* root = t;
        
        while(root->left) {
            root = root->left;
        }
        return root;
    }
}

Tree* max(Tree* t) {
    if(!t) {
        return NULL;
    }
    else {
        Tree* root = t;
        while(root->right) {
            root = root->right;
        }
        return root;
    }
}

int getLevel(Tree* t, int* flag) {
    if(!t) {
        return 0;
    }
    else {
        int l = getLevel(t->left, flag);
        int r = getLevel(t->right, flag);
        if(abs(l - r) > 1) {
            if(!(*flag < 0)) {
                *flag = -t->value;
            }
        }
        return (l > r ? l : r) + 1;
    }
}

Tree* insert(Tree* root, int value) {
    if(!root) {
        root = (Tree*)malloc(sizeof(Tree));
        root->value = value;
        // root->balance = 0;
        root->left = NULL;
        root->right = NULL;
    }
    else {
        if(value < root->value) {
            root->left = insert(root->left, value);
        }
        else if(value > root->value) {
            root->right = insert(root->right, value);
        }
    }
    return root;
}

void balance(Tree* root, int value) {
    int flag = 0;
    getLevel(root, &flag);
    if(flag < 0) {
        Tree* broken = find(root, -flag);
        
        traversal(root);
      //  printf("broken: %d.\n", broken->value);
        
        if(value < broken->value) { // L
            if(value < broken->left->value) { // LL
                // printf("LL\n");
                Tree* three = broken;
                Tree* threeR = broken->right;
                Tree* two = broken->left;
                Tree* one = two->left;
                Tree* twoR = two->right;
                
                int temp = three->value;
                three->value = two->value;
                two->value = temp;
                
                three->left = one;
                three->right = two;
                two->left = twoR;
                two->right = threeR;
            }
            else { //if(value > broken->left->value  LR
                // printf("LR\n");
                Tree* A = broken;
                Tree* AR = A->right;
                Tree* B = A->left;
                Tree* C = B->right;
                Tree* CL = C->left;
                Tree* CR = C->right;
                
                int temp = A->value;
                A->value = C->value;
                C->value = temp;
                
                A->right = C;
                B->right = CL;
                C->left = CR;
                C->right = AR;
            }
        }
        else { //if(value > broken->value)  R
            if(value > broken->right->value) { // RR
                //printf("RR\n");
                Tree* A = broken;
                Tree* AL = A->left;
                Tree* B = A->right;
                Tree* BL = B->left;
                Tree* C = B->right;
                
                int temp = A->value;
                A->value = B->value;
                B->value = temp;
                
                A->left = B;
                A->right = C;
                B->left = AL;
                B->right = BL;
            }
            else { //if(value < broken->right->value) RL
                //printf("RL\n");
                Tree* A = broken;
                Tree* AL = A->left;
                Tree* B = A->right;
                Tree* C = B->left;
                Tree* CL = C->left;
                Tree* CR = C->right;
                
                int temp = A->value;
                A->value = C->value;
                C->value = temp;
                
                A->left = C;
                B->left = CR;
                C->left = AL;
                C->right = CL;
            }
        }
        traversal(root);
        //printf("\n");
    }
}

Tree* insertBalanced(Tree* root, int value) {
    insert(root, value);
    balance(root, value);
    return root;
}

Tree* delete(Tree* t, int value) {
    if(!t) {
        return NULL;
    }
    else {
        if(value < t->value) {
            t->left = delete(t->left, value);
        }
        else if(value > t->value) {
            t->right = delete(t->right, value);
        }
        else {
            if(t->left && t->right) {
                Tree* temp = max(t->left);
                t->value= temp->value;
                t->left = delete(t->left, temp->value);
            }
            else {
                Tree* temp = t;
                if(t->left) {
                    t = t->left;
                }
                else {
                    t = t->right;
                }
                free(temp);
            }
        }
    }
    return t;
}

Tree* deleteBalanced(Tree* t, int value) {
    delete(t, value);
    Tree* leaf = traversal(t);
    //printf("\n");
    if(leaf) {
        value = leaf->value;
        balance(t, value);
    }
    //printf("deleted\n");
    return t;
}

Tree* traversal(Tree* t) {
    
    Tree* temp = NULL;
    
    if(!t) {
        return temp;
    }
    else {
        Queue* q = (Queue*)malloc(sizeof(Queue));
        q->head = NULL;
        q->next = NULL;
        
        enqueue(q, t);
        
        do {
            temp = dequeue(q);
            //printf("%d ", temp->value);
            if(temp->left) {
                enqueue(q, temp->left);
            }
            if(temp->right) {
                enqueue(q, temp->right);
            }
        } while(q->next);
    }
    
    return temp;
}

int main() {
    
    int n;
    scanf("%d", &n);
    
    Tree* t = (Tree*)malloc(sizeof(Tree));
    t->value = 0;
    t->left = NULL;
    t->right = NULL;
    
    scanf("%d", &t->value);
    
    for(int i = 1; i < n; i++) {
        int val;
        scanf("%d", &val);
        insertBalanced(t, val);
    }
    
 //   traversal(t);
    printf("%d\n", t->value);
    
    return 0;
}

//Sample Input 1:
//5
//88 70 61 96 120
//Sample Output 1:
//70
//Sample Input 2:
//7
//Sample Output 2:
//88