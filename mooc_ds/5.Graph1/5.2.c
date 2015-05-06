//
//  5.2.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-04.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

#define LAND_RADIUS 7.5
#define LAKE_SIZE 50

typedef struct _list {
    int value;
    struct _list* next;
} List;

List* createNode(int v, List* next) {
    List* node = (List*)malloc(sizeof(List));
    node->value = v;
    node->next = next;
    return node;
}

void addNode(List* graph, List* node) {
    if(!graph->next) {
        graph->next = node;
    }
    else {
        node->next = graph->next;
        graph->next = node;
    }
}

void buildEdge(int a, int b, List** g) {
    addNode(g[a], createNode(b, NULL));
    addNode(g[b], createNode(a, NULL));
}

void enqueue(List* queue, List* node) {
    List* q = queue;
    while(q->next)
        q = q->next;
    q->next = node;
}

List* dequeue(List* queue) {
    List* res = queue->next;
    if(res) {
        queue->next = res->next;
    }
    return res;
}

float squareFast(float x, float y) {
    return x*x + y*y;
}

void BFS(int init, List** graph, int* isVisited, List* queue, int* escape, int target) {
    enqueue(queue, createNode(init, NULL));
    
    while(queue->next) {
        List* head = dequeue(queue);
        int vertex = head->value;
        if(vertex == target) {
            *escape = 1;
            return;
        }
        
        if(!isVisited[vertex]) {
            isVisited[vertex] = 1;
            List* links = graph[vertex];
            while(links->next) {
                enqueue(queue, createNode(links->next->value, NULL));
                links = links->next;
            }
        }
    }
}

int main() {
    int n, step;
    scanf("%d", &n);
    scanf("%d", &step);
    
    List* graph[n + 2];
    graph[0] = createNode(0, NULL);
    graph[n + 1] = createNode(n+1, NULL);
    
    float x[n + 2];
    float y[n + 2];
    
    x[0] = 0;
    y[0] = 0;
    
    for(int i = 1; i <= n; i++) {
        scanf("%f", &x[i]);
        scanf("%f", &y[i]);
        graph[i] = createNode(i, NULL);
        
        // connect to vertex[0]
        if(squareFast(x[i], y[i]) <= (LAND_RADIUS + step) * (LAND_RADIUS + step)) { // jump please!
            buildEdge(0, i, graph);
        }
        // connect to other vertices
        for(int j = 1; j < i; j++) {
            if(squareFast(x[i] - x[j], y[i] - y[j]) <= step * step) { // jump! Be quick!
                buildEdge(i, j, graph);
            }
        }
    }
    
    // connect to escape location
    for(int i = 0; i <= n; i++) {
        int xx = x[i];
        int yy = y[i];
        if(xx < 0)
            xx = -xx;
        if(yy < 0)
            yy = -yy;
        int larger = xx > yy ? xx : yy;
        
        if(LAKE_SIZE - larger <= step) {
            buildEdge(i, n + 1, graph);
        }
    }
    
    int escape = 0;
    int isVisited[n + 2];
    List* queue = createNode(-255, NULL);
    for(int i = 0; i < n + 2; i++) {
        isVisited[i] = 0;
    }
    
    BFS(0, graph, isVisited, queue, &escape, n + 1);
    
    if(escape)
        printf("Yes\n");
    else
        printf("No\n");
    return 0;
}

/*
 This time let us consider the situation in the movie "Live and Let Die" in which James Bond, the world's most famous spy, was captured by a group of drug dealers. He was sent to a small piece of land at the center of a lake filled with crocodiles. There he performed the most daring action to escape -- he jumped onto the head of the nearest crocodile! Before the animal realized what was happening, James jumped again onto the next big head... Finally he reached the bank before the last crocodile could bite him (actually the stunt man was caught by the big mouth and barely escaped with his extra thick boot).
 
 Assume that the lake is a 100 by 100 square one. Assume that the center of the lake is at (0,0) and the northeast corner at (50,50). The central island is a disk centered at (0,0) with the diameter of 15. A number of crocodiles are in the lake at various positions. Given the coordinates of each crocodile and the distance that James could jump, you must tell him whether or not he can escape.
 
 Input Specification:
 
 Each input file contains one test case. Each case starts with a line containing two positive integers N (<=100), the number of crocodiles, and D, the maximum distance that James could jump. Then N lines follow, each containing the (x, y) location of a crocodile. Note that no two crocodiles are staying at the same position.
 
 Output Specification:
 
 For each test case, print in a line "Yes" if James can escape, or "No" if not.
 
 Sample Input 1:
 14 20
 25 -15
 -25 28
 8 49
 29 15
 -35 -2
 5 28
 27 -29
 -8 -28
 -20 -35
 -25 -20
 -13 29
 -30 15
 -35 40
 12 12
 Sample Output 1:
 Yes
 Sample Input 2:
 4 13
 -12 12
 12 12
 -12 -12
 12 -12
 Sample Output 2:
 No
*/