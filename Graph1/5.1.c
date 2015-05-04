//
//  5.1.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-04.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _list {
    int v;
    struct _list* next;
} Graph;

Graph* createNode(int v, Graph* next) {
    Graph* n = (Graph*)malloc(sizeof(Graph));
    n->v = v;
    n->next = next;
    return n;
}

void addNode(Graph* g, Graph* node) {
    if(!g->next) {
        g->next = node;
    }
    else {
        if(g->next->v < node->v) {
            addNode(g->next, node);
        }
        else {
            node->next = g->next;
            g->next = node;
        }
    }
}

void enqueue(Graph* q, Graph* node) {
    Graph* t = q;
    while(t->next) {
        t = t->next;
    }
    t->next = node;
}

Graph* dequeue(Graph* q) {
    Graph* temp = q->next;
    if(temp)
        q->next = temp->next;
    return temp;
}

void DFS(Graph** g, int vertex, int* isConnected) {
    if(!isConnected[vertex]) {
        isConnected[vertex] = 1;
        printf("%d ", vertex);
        
        Graph* temp = g[vertex];
        while(temp->next) {
            DFS(g, temp->next->v, isConnected);
            temp = temp->next;
        }
    }
}

void BFS(Graph** g, int vertex, int* isConnected, Graph* queue) {
    enqueue(queue, createNode(vertex, NULL));
    while(queue->next) {
        Graph* head = dequeue(queue);
        int v = head->v;
        if(!isConnected[v]) {
            isConnected[v] = 1;
            printf("%d ", v);
            Graph* temp = g[v];
            while(temp->next) {
                enqueue(queue, createNode(temp->next->v, NULL));
                temp = temp->next;
            }
        }
        free(head);
    }
}

int main() {
    int N, E;
    scanf("%d", &N);
    scanf("%d", &E);
    
    Graph* g[N];
    for(int i = 0; i < N; i++) {
        g[i] = createNode(0, NULL);
    }
    
    int isConnected[N];
    for(int i = 0; i < N; i++) {
        isConnected[i] = 0;
    }
    
    for(int i = 0; i < E; i++) {
        int a, b;
        scanf("%d", &a);
        scanf("%d", &b);
        Graph* na = createNode(a, NULL);
        Graph* nb = createNode(b, NULL);
        addNode(g[a], nb);
        addNode(g[b], na);
    }
    
    for(int i = 0; i < N; i++) {
        if(!isConnected[i]) {
            printf("{ ");
            DFS(g, i, isConnected);
            printf("}\n");
        }
    }
    
    Graph* queue = createNode(0, NULL);
    for(int i = 0; i < N; i++) {
        isConnected[i] = 0;
    }
    for(int i = 0; i < N; i++) {
        if(!isConnected[i]) {
            printf("{ ");
            BFS(g, i, isConnected, queue);
            printf("}\n");
        }
    }
    return 0;
}


/*
 For a given undirected graph with N vertices and E edges, please list all the connected components by both DFS and BFS. Assume that all the vertices are numbered from 0 to N-1. While searching, assume that we always start from the vertex with the smallest index, and visit its adjacent vertices in ascending order of their indices.
 
 Input Specification:
 
 Each input file contains one test case. For each case, the first line gives two integers N (0<N<=10) and E, which are the number of vertices and the number of edges, respectively. Then E lines follow, each described an edge by giving the two ends. All the numbers in a line are separated by a space.
 
 Output Specification:
 
 For each test case, print in each line a connected component in the format "{ v1 v2 ... vk }". First print the result obtained by DFS, then by BFS.
 
 Sample Input:
 8 6
 0 7
 0 1
 2 0
 4 1
 2 4
 3 5
 Sample Output:
 { 0 1 4 2 7 }
 { 3 5 }
 { 6 }
 { 0 1 2 7 4 }
 { 3 5 }
 { 6 }
*/