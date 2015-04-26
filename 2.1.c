////
////  2.1.c
////  data structure
////
////  Created by Xuchao Ding on 2015-01-05.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//
//// test 6: extra data entries
//
//#include <stdio.h>
//
//typedef struct _node {
//    int addr;
//    int data;
//    int next;
//    struct _node* ptr;
//} Node;
//
//void reverse(Node* head, int length, int sub) {
//    if(length < sub) {
//        return;
//    }
//
//    else {
//        Node* first = head->ptr;
//        Node* current = first;
//        Node* next = current->ptr;
//        for(int i = 0; i < sub - 1; i++) {
//            Node* temp = next->ptr;
//            next->ptr = current;
//            current = next;
//            next = temp;
//        }
//        head->ptr = current;
//        first->ptr = next;
//        reverse(first, length - sub, sub);
//    }
//}
//
//void updateNextValue(Node* head, int length) {
//    Node* iter = head->ptr;
//    for(int i = 0; i < length - 1; i++) {
//        iter->next = iter->ptr->addr;
//        iter = iter->ptr;
//    }
//    iter->next = -1;
//}
//
//int main() {
//    int first;
//    int num;
//    int sub;
//    int length = 0;
//    
//    scanf("%d", &first);
//    scanf("%d", &num);
//    scanf("%d", &sub);
//    
//    Node* head = (Node*)malloc(sizeof(Node));
//    Node* tail = head;
//    
//    Node* target;
//    
//    // read input
//    for(int i = 0; i < num; i++) {
//        Node* node = (Node*)malloc(sizeof(Node));
//        tail->ptr = node;
//        
//        scanf("%d", &(node->addr));
//        scanf("%d", &(node->data));
//        scanf("%d", &(node->next));
//        node->ptr = NULL;
//        
//        tail = node;
//    }
//    
//    // sort to list-like array
//    // -- get head into 1st position
//    Node* prev = head;
//    while(prev->ptr) {
//        if(prev->ptr->addr == first) {
//            target = prev->ptr;
//            length++;
//            break;
//        }
//        prev = prev->ptr;
//    }
//    prev->ptr = target->ptr;
//    target->ptr = head->ptr;
//    head->ptr = target;
//    // --
//    
//    // ---linking the rest
//    Node* currentHead = head->ptr;
//    prev = currentHead;
//    while(target->next != -1 && prev->ptr){
//        if(prev->ptr->addr == target->next) {
//            length++;
//            target = prev->ptr;
//            prev->ptr = target->ptr;
//            target->ptr = currentHead->ptr;
//            currentHead->ptr = target;
//            currentHead = target;
//            prev = currentHead;
//        }
//        else {
//            prev = prev->ptr;
//        }
//    }
//    // ---linked. Initialization finished.
//    
//    // reverse every "sub" elements
//    reverse(head, length, sub);
//    updateNextValue(head, length);
//    
//    // print result
//    Node* printed = head->ptr;
//    for(int i = 0; i < length - 1; i++) {
//        printf("%05d %d %05d\n", printed->addr, printed->data, printed->next);
//        printed = printed->ptr;
//    }
//    printf("%05d %d %d\n", printed->addr, printed->data, printed->next);
//    
//    return 0;
//}
//
//
///*
// Given a constant K and a singly linked list L, you are supposed to reverse the links of every K elements on L. For example, given L being 1→2→3→4→5→6, if K = 3, then you must output 3→2→1→6→5→4; if K = 4, you must output 4→3→2→1→5→6.
// 
// Input Specification:
// 
// Each input file contains one test case. For each case, the first line contains the address of the first node, a positive N (<= 105) which is the total number of nodes, and a positive K (<=N) which is the length of the sublist to be reversed. The address of a node is a 5-digit nonnegative integer, and NULL is represented by -1.
// 
// Then N lines follow, each describes a node in the format:
// 
// Address Data Next
// 
// where Address is the position of the node, Data is an integer, and Next is the position of the next node.
// 
// Output Specification:
// 
// For each case, output the resulting ordered linked list. Each node occupies a line, and is printed in the same format as in the input.
// 
// Sample Input:
// 00100 6 4
// 00000 4 99999
// 00100 1 12309
// 68237 6 -1
// 33218 3 00000
// 99999 5 68237
// 12309 2 33218
// Sample Output:
// 00000 4 33218
// 33218 3 12309
// 12309 2 00100
// 00100 1 99999
// 99999 5 68237
// 68237 6 -1
//*/
//
//
///*
// 00100 7 1
// 12345 9 12121
// 00000 4 99999
// 00100 1 12309
// 68237 6 -1
// 33218 3 00000
// 99999 5 68237
// 12309 2 33218
//*/