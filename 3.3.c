////
////  3.3.c
////  data structure
////
////  Created by Xuchao Ding on 2015-01-16.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//
//#include <stdio.h>
//
//char* PUSH = "Push";
//char* POP = "Pop";
//int printed = 0;
//
//typedef struct _tree{
//    struct _tree* left;
//    struct _tree* right;
//    int value;
//    int visited;
//} Tree;
//
//typedef struct _stack{
//    struct _stack* next;
//    Tree* tree;
//} Stack;
//
//int emptyStack(Stack* head) {
//    int res = 0;
//    if(head->next == NULL) {
//        res = 1;
//    }
//    return res;
//}
//
//void push(Stack* head, Tree* t) {
//    Stack* newStack = (Stack*)malloc(sizeof(Stack));
//    newStack->tree = t;
//    newStack->next = head->next;
//    head->next = newStack;
//}
//
//Tree* pop(Stack* head) {
//    Tree* res = NULL;
//    if(head->next) {
//        res = head->next->tree;
//        Stack* temp = head->next->next;
//        head->next = temp;
//    }
//    return res;
//}
//
//int strEqual(char* a, char* b) {
//    int i = 0;
//    int res = 1;
//    while(a[i] != '\0' && b[i] != '\0') {
//        if(a[i] != b[i]) {
//            res = 0;
//            break;
//        }
//        i++;
//    }
//    if(a[i] != b[i]) {
//        res = 0;
//    }
//    return res;
//}
//
//void postTraversal(Tree* root) {
//    if(root) {
//        
//        
//        postTraversal(root->left);
//        
//        postTraversal(root->right);
//        
//        if(!printed) {
//            printf("%d", root->value);
//            printed = 1;
//        }
//        else {
//            printf(" %d", root->value);
//        }
//
//    }
//}
//
//void postTraversalByStack(Tree* root) {
//    Stack* head = (Stack*)malloc(sizeof(Stack));
//    push(head, root);
//    while(!emptyStack(head)) {
//        Tree* t = pop(head);
//        if(t->visited == 2) {
//            if(printed) {
//                printf(" %d", t->value);
//            }
//            else {
//                printf("%d", t->value);
//                printed++;
//            }
//        }
//        else if(t->visited == 0){
//            t->visited++;
//            push(head, t);
//            if(t->left != NULL) {
//                push(head, t->left);
//            }
//        }
//        else if(t->visited == 1) {
//            t->visited++;
//            push(head, t);
//            if(t->right != NULL) {
//                push(head, t->right);
//            }
//        }
//    }
//}
//
//void reset(Tree** t, int n) {
//    for(int i = 1; i <= n; i++) {
//        t[i]->visited = 0;
//    }
//}
//
//int main() {
//    
//    int n;
//    scanf("%d", &n);
//    
//    Tree* tree[n + 1];
//    for(int i = 1; i <= n; i++) {
//        tree[i] = (Tree*)malloc(sizeof(Tree));
//        tree[i]->left = NULL;
//        tree[i]->right = NULL;
//        tree[i]->value = i;
//        tree[i]->visited = 0;
//    }
//    
//    char s[5];
//    int counter = 0;
//    
//    Stack* head = (Stack*)malloc(sizeof(Stack));
//    head->next = NULL;
//    head->tree = NULL;
//    
//    Tree* root = NULL;
//    Tree* currentNode = NULL;
//    
//    while(counter < n) {
//        scanf("%s", s);
//        if(strEqual(s, PUSH)) {
//            counter++;
//            int i;
//            scanf("%d", &i);
//            if(currentNode) {
//                if(!currentNode->visited) {
//                    currentNode->left = tree[i];
//                    currentNode->visited = 1;
//                }
//                else {
//                    currentNode->right = tree[i];
//                }
//            }
//            else {
//                root = tree[i];
//            }
//            
//            currentNode = tree[i];
//            push(head, tree[i]);
//        }
//        else if(strEqual(s, POP)) {
//            Tree* poped = pop(head);
//            currentNode = poped;
//            
////            printf("** %d is poped **\n", poped->value);
//            
//            poped->visited = 1;
//        }
//    }
//
////    for(int i = 1; i <= n; i++) {
////        printf("this node is %d.", tree[i]->value);
////        if(tree[i]->left)
////            printf("left child is %d.", tree[i]->left->value);
////        if(tree[i]->right)
////            printf("right child is %d.", tree[i]->right->value);
////        printf("\n");
////    }
//    
////    postTraversal(root);
//    reset(tree, n);
//    postTraversalByStack(root);
//    
//    return 0;
//}
//
///*
// 6
// Push 1
// Push 2
// Push 3
// Pop
// Pop
// Push 4
// Pop
// Pop
// Push 5
// Push 6
// Pop
// Pop
//*/