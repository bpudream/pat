//
//  6.4.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-07.
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

float squareFast(float x, float y) {
    return x*x + y*y;
}

void addNode(List* graph, List* node, float* x, float* y) {
    int i = graph->value;
    int j = node->value;
    List* temp = graph;
    while(temp->next) {
        int k = temp->next->value;
        if(squareFast(x[i] - x[j], y[i] - y[j]) < squareFast(x[i] - x[k], y[i] - y[k]))
            break;
        temp = temp->next;
    }
    node->next = temp->next;
    temp->next = node;
    
    //    if(!graph->next) {
//        graph->next = node;
//    }
//    else {
//        node->next = graph->next;
//        graph->next = node;
//    }
}

void enqueue(List* queue, int value) {
    List* node = createNode(value, NULL);
    List* temp = queue;
    while(temp->next) {
        temp = temp->next;
    }
    temp->next = node;
}

int dequeue(List* queue) {
    List* temp = queue->next;
    int res = -1;
    if(temp) {
        res = temp->value;
        queue->next = temp->next;
        free(temp);
    }
    return res;
}

void push(List* stack, int value) {
    List* node = createNode(value, NULL);
    List* temp = stack->next;
    stack->next = node;
    node->next = temp;
}

int pop(List* stack) {
    int res = -255;
    if(stack->next) {
        List* temp = stack->next;
        res = temp->value;
        stack->next = temp->next;
        free(temp);
    }
    return res;
}

void buildEdge(int a, int b, List** g, float* x, float* y) {
    addNode(g[a], createNode(b, NULL), x, y);
    addNode(g[b], createNode(a, NULL), x, y);
}

void BFS(int init, List** graph, int n, int* prePath, int* flag, float* x, float* y) {
    List* queue = createNode(255, NULL);
    enqueue(queue, init);
    
    while(!(*flag) && queue->next) {
        int value = dequeue(queue);
//        printf("de: %d,%d\n", (int)x[value], (int)y[value]);
        List* link = graph[value];
        while(link->next) {
            int v = link->next->value;
            if(prePath[v] < 0) {
//                level[v] = level[value] + 1;
                prePath[v] = value;
                if(v == n + 1) {
                    *flag = 1;
                    break;
                }
                enqueue(queue, v);
//                printf("enqueue: %d,%d\n", (int)x[v], (int)y[v]);
            }
            link = link->next;
        }
    }
}

int main() {
    int n, step;
    scanf("%d", &n);
    scanf("%d", &step);
    
    List* graph[n + 2];
    graph[0] = createNode(0, NULL);
    graph[n + 1] = createNode(n + 1, NULL);
    
    float x[n + 2];
    float y[n + 2];
    
    x[0] = 0;
    y[0] = 0;
    x[n + 1] = LAKE_SIZE;
    y[n + 1] = LAKE_SIZE;
    
    for(int i = 1; i <= n; i++) {
        scanf("%f", &x[i]);
        scanf("%f", &y[i]);
        graph[i] = createNode(i, NULL);
        
        // connect to vertex[0]
        if(squareFast(x[i], y[i]) <= (LAND_RADIUS + step) * (LAND_RADIUS + step)) { // jump please!
            buildEdge(0, i, graph, x, y);
        }
        // connect to other vertices
        for(int j = 1; j < i; j++) {
            if(squareFast(x[i] - x[j], y[i] - y[j]) <= step * step) { // jump! Be quick!
                buildEdge(i, j, graph, x, y);
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
            buildEdge(i, n + 1, graph, x, y);
        }
    }
    
    int prePath[n + 2];
    int level[n + 2];
    prePath[0] = 0;
    level[0] = 0;
    for(int i = 1; i < n + 2; i++) {
        prePath[i] = -1;
        level[i] = -1;
    }
    
    int flag = 0;
    BFS(0, graph, n, prePath, &flag, x, y);
    
    if(flag) {
        List* stack = createNode(-1, NULL);
        int counter = 0;
        int value = n + 1;
        while(value != 0) {
            counter++;
            push(stack, value);
            value = prePath[value];
        }
        
        printf("%d\n", counter);
        while(1) {
            value = pop(stack);
            if(value != n + 1) {
                printf("%d %d\n", (int)x[value], (int)y[value]);
            }
            else
                break;
        }
    }
    else {
        printf("0\n");
    }
    
//    for(int i = 0; i < n + 2; i++) {
//        printf("%d ", prePath[i]);
//    }
    
//    for(int i = 0; i < n + 2; i++) {
//    List* glast = graph[i];
//    while(glast->next) {
//        int val = glast->next->value;
//        printf("%d %d\n", (int)x[val], (int)y[val]);
//        glast = glast->next;
//    }
//        printf("\n");
//    }
    
    return 0;
}

/*
 This time let us consider the situation in the movie "Live and Let Die" in which James Bond, the world's most famous spy, was captured by a group of drug dealers. He was sent to a small piece of land at the center of a lake filled with crocodiles. There he performed the most daring action to escape -- he jumped onto the head of the nearest crocodile! Before the animal realized what was happening, James jumped again onto the next big head... Finally he reached the bank before the last crocodile could bite him (actually the stunt man was caught by the big mouth and barely escaped with his extra thick boot).
 
 Assume that the lake is a 100 by 100 square one. Assume that the center of the lake is at (0,0) and the northeast corner at (50,50). The central island is a disk centered at (0,0) with the diameter of 15. A number of crocodiles are in the lake at various positions. Given the coordinates of each crocodile and the distance that James could jump, you must tell him a shortest path to reach one of the banks. The length of a path is the number of jumps that James has to make.
 
 Input Specification:
 
 Each input file contains one test case. Each case starts with a line containing two positive integers N (<=100), the number of crocodiles, and D, the maximum distance that James could jump. Then N lines follow, each containing the (x, y) location of a crocodile. Note that no two crocodiles are staying at the same position.
 
 Output Specification:
 
 For each test case, if James can escape, output in one line the minimum number of jumps he must make. Then starting from the next line, output the position (x, y) of each crocodile on the path, each pair in one line, from the island to the bank. If it is impossible for James to escape that way, simply give him 0 as the number of jumps. If there are many shortest paths, just output the one with the minimum first jump, which is guaranteed to be unique.
 
 Sample Input 1:
 17 15
 10 -21
 10 21
 -40 10
 30 -50
 20 40
 35 10
 0 -10
 -25 22
 40 -40
 -30 30
 -10 22
 0 11
 25 21
 25 10
 10 10
 10 35
 -30 10
 Sample Output 1:
 4
 0 11
 10 21
 10 35
 Sample Input 2:
 4 13
 -12 12
 12 12
 -12 -12
 12 -12
 Sample Output 2:
 0
 */