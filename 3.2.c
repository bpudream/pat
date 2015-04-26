////
////  3.2.c
////  data structure
////
////  Created by Xuchao Ding on 2015-01-09.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//
//#include <stdio.h>
//
//typedef struct _btree {
//    int value;
//    //int level;
//    int left;
//    int right;
////    struct _btree* left;
////    struct _btree* right;
//} BT;
//
//typedef struct _queue{
//    struct _queue* next;
//    struct _queue* tail;
//    BT* value;
//} Queue;
//
//int isEmptyQueue(Queue q) {
//    int res = 0;
//    
//    if(q.next == NULL) {
//        res = 1;
//    }
//    
//    return res;
//}
//
//Queue* pop(Queue* q) {
//    if(!isEmptyQueue(*q)) {
//        Queue* head = q->next;
//        if(head == q->tail) {
//            q->tail = q;
//        }
//        q->next = head->next;
//        return head;
//    }
//    else
//        return NULL;
//}
//
//void push(Queue* q, BT* t) {
//    Queue* nq = (Queue*)malloc(sizeof(Queue));
//    nq->value = t;
//    nq->next = NULL;
//    q->tail->next = nq;
//    q->tail = nq;
//}
//
//int isLeaf(BT t) {
//    int res = 0;
//    if(t.left == -1 && t.right == -1) {
//        res = 1;
//    }
//    return res;
//}
//
//int max(int a, int b) {
//    return (a > b) ? a : b;
//}
//
//int getLevel(BT* tree, int i) {
//    int res = -1;
//    if(i < 0) {
//        res = 0;
//    }
//    else {
//        res = 1 + max(getLevel(tree, tree[i].left), getLevel(tree, tree[i].right));
//    }
//    return res;
//}
//
//int main() {
//    int n;
//    scanf("%d", &n);
//    char c = getchar();
//    BT tree[n];
//    BT* top = NULL;
//    int maxLevel = 0;
//    int printed = 0;
//    
//    for(int i = 0; i < n; i++) {
//        tree[i].value = i;
//        char a, b;
//        int valueA = -1;
//        int valueB = -1;
//        scanf("%c %c", &a, &b);
//        char c = getchar();
////        printf("a = %c, b = %c\n", a, b);
//        if(a != '-') {
//            valueA = a - '0';
//        }
//        if(b != '-') {
//            valueB = b - '0';
//        }
//        tree[i].left = valueA;
//        tree[i].right = valueB;
//    }
//    
//    for(int i = 0; i < n; i++) {
//        int l = getLevel(tree, i);
//        //tree[i].level = l;
//        if(l > maxLevel) {
//            maxLevel = l;
//            top = &tree[i];
//        }
//    }
//    
//    //printf("top is tree[%d] with level %d\n", top->value, maxLevel);
//    Queue* queue = (Queue*)malloc(sizeof(Queue));
//    queue->tail = queue;
//    push(queue, top);
//    
//    while(!isEmptyQueue(*queue)) {
//        Queue* head = pop(queue);
//        if(isLeaf(*head->value)) {
//            if(printed){
//                printf(" %d", head->value->value);
//            }
//            else {
//                printf("%d", head->value->value);
//                printed = 1;
//            }
//        }
//        else {
//            if(head->value->left != -1) {
//                push(queue, &tree[head->value->left]);
//            }
//            if(head->value->right != -1) {
//                push(queue, &tree[head->value->right]);
//            }
//        }
//    }
//    
//    return 0;
//}