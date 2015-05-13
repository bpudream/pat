//
//  6.5.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-12.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

#define INFINITE 262128

typedef struct _list {
    int value;
    struct _list* next;
} List;

List* createNode(int value) {
    List* temp = (List*)malloc(sizeof(List));
    temp->value = value;
    temp->next = NULL;
    return temp;
}

void addNode(List* list, int value) {
    List* t = createNode(value);
    t->next = list->next;
    list->next = t;
}

void buildPath(int s, int d, List** graph) {
    addNode(graph[s], d);
    addNode(graph[d], s);
}

int getIndex(int i, int j, int n) {
    int res;
    int row, col;
    if(i < j) {
        row = i;
        col = j;
    }
    else {
        col = i;
        row = j;
    }
    res = row * (n - 1 + n - row) / 2 + (col - row - 1);
    return res;
}

void update(List* links, int* collected, int* distance, int* cost, int* length, int* price, int n) {
    List* t = links;
    int source = links->value;
    int target;
    while(t->next) {
        target = t->next->value;
        if(!collected[target]) {
            int i = getIndex(source, target, n);
            if(distance[source] + length[i] < distance[target]) {
                distance[target] = distance[source] + length[i];
                cost[target] = cost[source] + price[i];
            }
            if(distance[source] + length[i] == distance[target]) {
                if(cost[source] + price[i] < cost[target])
                    cost[target] = cost[source] + price[i];
            }
        }
        t = t->next;
    }
}

int findMin(int* distance, int n, int* collected) {
    int minIndex = -1;
    int minValue = INFINITE + 1;
    for(int i = 0; i < n; i++) {
        if(!collected[i])
            if(distance[i] < minValue) {
                minIndex = i;
                minValue = distance[i];
            }
    }
    return minIndex;
}

int main() {
    int n, m, src, dest;
    scanf("%d", &n);
    scanf("%d", &m);
    scanf("%d", &src);
    scanf("%d", &dest);
    
    List* graph[n];
    int arrlength = (n - 1) * n / 2;
    int length[arrlength];
    int price[arrlength];
    int distance[n];
    int cost[n];
    int collected[n];
    int path[n];
    
    for(int i = 0; i < n; i++) {
        graph[i] = createNode(i);
        distance[i] = INFINITE;
        cost[i] = INFINITE;
        collected[i] = 0;
        path[i] = -1;
    }
    
    for(int i = 0; i < arrlength; i++) {
        length[i] = INFINITE;
        price[i] = INFINITE;
    }
    
    for(int i = 0; i < m; i++) {
        int s, d;
        scanf("%d", &s);
        scanf("%d", &d);
        buildPath(s, d, graph);
        
        int index = getIndex(s, d, n);
        int len, pri;
        scanf("%d", &length[index]);
        scanf("%d", &price[index]);
//        if(len < length[index]) {
//            length[index] = len;
//            price[index] = pri;
//        }
//        else if(len == length[index] && pri < price[index])
//            price[index] = pri;
    }
    
    distance[src] = 0;
    cost[src] = 0;
    collected[src] = 1;
    
    update(graph[src], collected, distance, cost, length, price, n); // O(|V|)
    
    while(1) {
        int minIndex = findMin(distance, n, collected); // O(|V*V|)
        if(minIndex == -1)
            break;
        collected[minIndex] = 1;
        update(graph[minIndex], collected, distance, cost, length, price, n);
    }

    printf("%d %d\n", distance[dest], cost[dest]);
    
    return 0;
}
/*
 有了一张自驾旅游路线图，你会知道城市间的高速公路长度、以及该公路要收取的过路费。现在需要你写一个程序，帮助前来咨询的游客找一条出发地和目的地之间的最短路径。如果有若干条路径都是最短的，那么需要输出最便宜的一条路径。
 
 输入格式说明：
 
 输入说明：输入数据的第1行给出4个正整数N、M、S、D，其中N（2<=N<=500）是城市的个数，顺便假设城市的编号为0~(N-1)；M是高速公路的条数；S是出发地的城市编号；D是目的地的城市编号。随后的M行中，每行给出一条高速公路的信息，分别是：城市1、城市2、高速公路长度、收费额，中间用空格分开，数字均为整数且不超过500。输入保证解的存在。
 
 输出格式说明：
 
 在一行里输出路径的长度和收费总额，数字间以空格分隔，输出结尾不能有多余空格。
 
 样例输入与输出：
 
 
 4 5 0 3
 0 1 1 20
 1 3 2 30
 0 3 4 10
 0 2 2 20
 2 3 1 20
 输入	输出
 3 40
 
 2 1 0 1
 1 0 2 3
 
 2 3
 */