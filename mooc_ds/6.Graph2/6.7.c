//
//  6.7.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-13.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _list {
    int value;
    int weight;
    struct _list* next;
} List;

List* createNode(int value, int weight) {
    List* t = (List*)malloc(sizeof(List));
    t->value = value;
    t->weight = weight;
    t->next = NULL;
    return t;
}

void addNode(List* list, int value, int weight) {
    List* t = createNode(value, weight);
    t->next = list->next;
    list->next = t;
}

void enqueue(List* queue, int value) {
    List* t = queue;
    while(t->next)
        t = t->next;
    t->next = createNode(value, 0);
}

int dequeue(List* queue) {
    int res = -1;
    List* t = queue->next;
    if(t) {
        res = t->value;
        queue->next = t->next;
        free(t);
    }
    return res;
}

void updateChildren(List** graph, int head, int* dist, int n, int bound, int* flag) {
    List* queue = createNode(-1, 0);
    enqueue(queue, head);
    
    while(queue->next) {
        int parent = dequeue(queue);
        List* links = graph[parent];
        while(links->next) {
            int next = links->next->value;
            if(dist[parent] + links->next->weight > dist[next])
                dist[next] = dist[parent] + links->next->weight;
            if(dist[next] > bound) {
                *flag = 0;
                return;
            }
            enqueue(queue, next);
            links = links->next;
        }
    }
}

int main() {
    int n, m;
    scanf("%d", &n);
    scanf("%d", &m);
    
    List* graph[n];
    int dist[n];
    for(int i = 0; i < n; i++) {
        graph[i] = createNode(i, 0);
        dist[i] = 0;
    }
    
    int bound = 1;
    int flag = 1;
    
    for(int i = 0; i < m && flag; i++) {
        int start, end;
        int length;
        scanf("%d", &start);
        scanf("%d", &end);
        scanf("%d", &length);
        
        bound += length;
        addNode(graph[start], end, length);
        
        if(dist[start] + length > dist[end]) {
            dist[end] = dist[start] + length;
            updateChildren(graph, end, dist, n, bound, &flag);
        }
    }
    
    if(flag) {
        int max = -1;
        for(int i = 0; i < n; i++) {
            if(max < dist[i])
                max = dist[i];
        }
        printf("%d\n", max);
    }
    else
        printf("Impossible\n");
    
    return 0;
}

/*
 Given the relations of all the activities of a project, you are supposed to find the earliest completion time of the project.
 
 Input Specification:
 
 Each input file contains one test case. Each case starts with a line containing two positive integers N (<=100), the number of activity check points (hence it is assumed that the check points are numbered from 0 to N-1), and M, the number of activities. Then M lines follow, each gives the description of an activity. For the i-th activity, three non-negative numbers are given: S[i], E[i], and L[i], where S[i] is the index of the starting check point, E[i] of the ending check point, and L[i] the lasting time of the activity. The numbers in a line are separated by a space.
 
 Output Specification:
 
 For each test case, if the scheduling is possible, print in a line its earliest completion time; or simply output "Impossible".
 
 Sample Input 1:
 9 12
 0 1 6
 0 2 4
 0 3 5
 1 4 1
 2 4 1
 3 5 2
 5 4 0
 4 6 9
 4 7 7
 5 7 4
 6 8 2
 7 8 4
 Sample Output 1:
 18
 Sample Input 2:
 4 5
 0 1 1
 0 2 2
 2 1 3
 1 3 4
 3 2 5
 Sample Output 2:
 Impossible
*/