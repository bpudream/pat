//
//  6.6.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-13.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

// prim()

#include <stdio.h>
#include <stdlib.h>

#define INFINITE 9000001

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

void update(List* links, int* dist, int* path) {
    List* t = links;
    int src = links->value;
    int target;
    while(t->next) {
        target = t->next->value;
        int weight = t->next->weight;
        if(weight < dist[target]) {
            dist[target] = weight;
            path[target] = src;
        }
        t = t->next;
    }
}

int findMin(int* dist, int n) {
    int index = -1;
    int min = INFINITE;
    for(int i = 1; i < n; i++)
        if(dist[i] != 0 && dist[i] < min) {
            index = i;
            min = dist[i];
        }
    return index;
}

int main() {
    int n, m;
    scanf("%d", &n);
    scanf("%d", &m);
    n++;
    
    List* graph[n];
    int dist[n];
    int path[n];
    int sum = 0;
    
    for(int i = 1; i < n; i++) {
        graph[i] = createNode(i, 0);
        dist[i] = INFINITE;
        path[i] = -1;
    }
    
    for(int i = 0; i < m; i++) {
        int src, dest, weight;
        scanf("%d", &src);
        scanf("%d", &dest);
        scanf("%d", &weight);
        addNode(graph[src], dest, weight);
        addNode(graph[dest], src, weight);
    }
    
    dist[1] = 0;
    update(graph[1], dist, path);
    
    while(1) {
        int minIndex = findMin(dist, n);
        if(minIndex == -1)
            break;
        sum += dist[minIndex];
        dist[minIndex] = 0;
        update(graph[minIndex], dist, path);
    }

    int counter = 1;
    for(int i = 1; i < n; i++) {
        if(path[i] > 0)
            counter++;
    }
    if(counter < n - 1 - 1) {
        printf("-1\n");
    }
    else {
        printf("%d\n", sum);
    }
    
    return 0;
}

/*
 现有村落间道路的统计数据表中，列出了有可能建设成标准公路的若干条道路的成本，求使每个村落都有公路连通所需要的最低成本。
 
 输入格式说明：
 
 输入数据包括城镇数目正整数N（<=1000）和候选道路数目M（<=3N）；
 随后的M行对应M条道路，每行给出3个正整数，分别是该条道路直接连通的两个城镇的编号以及该道路改建的预算成本。
 为简单起见，城镇从1到N编号。
 
 输出格式说明：
 
 输出村村通需要的最低成本。如果输入数据不足以保证畅通，则输出-1，表示需要建设更多公路。
 
 样例输入与输出：
 
 序号	输入	输出
 6 15
 1 2 5
 1 3 3
 1 4 7
 1 5 4
 1 6 2
 2 3 4
 2 4 6
 2 5 2
 2 6 6
 3 4 6
 3 5 1
 3 6 1
 4 5 10
 4 6 8
 5 6 3
 
 12
 
 
 3 1
 2 3 2
 
 -1
 

 5 4
 1 2 1
 2 3 2
 3 1 3
 4 5 4
 
 -1
 */