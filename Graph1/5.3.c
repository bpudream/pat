//
//  5.3.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-04.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _list {
    int value;
    struct _list* next;
} List;

typedef struct {
    int* elements;
    int head;
    int tail;
    int size;
} Queue;

List* createNode(int v, List* next) {
    List* node = (List*)malloc(sizeof(List));
    node->value = v;
    node->next = next;
    return node;
}

void addNode(List* l, List* node) {
    if(!l->next) {
        l->next = node;
    }
    else {
        node->next = l->next;
        l->next = node;
    }
}

void init(Queue* queue, int size) {
    queue->head = 0;
    queue->tail = 0;
//    size = size * 6;
    queue->size = size;
    queue->elements = (int*)malloc(sizeof(int) * size);
}

int isEmpty(Queue q) {
    return q.head == q.tail;
}

void enqueue(Queue* q, int n) {
    q->elements[q->tail % q->size] = n;
    q->tail++;
}

int dequeue(Queue* q) {
    int res = q->elements[q->head++];
    return res;
}

void buildEdge(int a, int b, List** g) {
    addNode(g[a], createNode(b, NULL));
    addNode(g[b], createNode(a, NULL));
}

int main() {
    int n, e;
    scanf("%d", &n); // num of nodes
    scanf("%d", &e); // num of edges
    
    List* graph[n]; // node-edge list
    for(int i = 0; i < n; i++) {
        graph[i] = createNode(i, NULL);
    }
    
    for(int i = 0; i < e; i++) {
        int na, nb;
        scanf("%d", &na);
        scanf("%d", &nb);
        buildEdge(na - 1, nb - 1, graph);
    }
    
    int level[n];
    int isVisited[n];
    for(int i = 0; i < n; i++) {
        level[i] = 0;
        isVisited[i] = 0;
    }
    for(int i = 0; i < n; i++) {
        // breadth first search
        Queue queue;
        init(&queue, n);
        enqueue(&queue, i);
        level[i] = 1;
        while(!isEmpty(queue)) {
            int value = dequeue(&queue);
            if(level[value] > 6)
                break;
            if(!isVisited[value]) { // A better approach would modify isVisited as soon as the node is Enqueued
                isVisited[value] = 1;
                List* temp = graph[value];
                while(temp->next) {
                    int childv = temp->next->value;
                    if(!isVisited[childv]) {
                        if(level[childv] == 0) { // if level != 0 then this node has been in queue
                            enqueue(&queue, childv);
                            level[childv] = level[value] + 1;
                        }
                    }
                    temp = temp->next;
                }
            }
        } // end of search
        
        int counter = 0;
        for(int i = 0; i < n; i++)
            if(level[i] > 0)
                counter++;
        printf("%d: %.2f%%\n", i + 1, 100.0 * counter / n);
        
        for(int i = 0; i < n; i++) {
            isVisited[i] = 0;
            level[i] = 0;
        }
        free(queue.elements);
    }
    return 0;
}
/*
 “六度空间”理论又称作“六度分隔（Six Degrees of Separation）”理论。这个理论可以通俗地阐述为：“你和任何一个陌生人之间所间隔的人不会超过六个，也就是说，最多通过五个人你就能够认识任何一个陌生人。”如图6.4所示。
 
 
 图6.4 六度空间示意图
 
 “六度空间”理论虽然得到广泛的认同，并且正在得到越来越多的应用。但是数十年来，试图验证这个理论始终是许多社会学家努力追求的目标。然而由于历史的原因，这样的研究具有太大的局限性和困难。随着当代人的联络主要依赖于电话、短信、微信以及因特网上即时通信等工具，能够体现社交网络关系的一手数据已经逐渐使得“六度空间”理论的验证成为可能。
 
 假如给你一个社交网络图，请你对每个节点计算符合“六度空间”理论的结点占结点总数的百分比。
 
 输入格式说明：
 
 输入第1行给出两个正整数，分别表示社交网络图的结点数N （1<N<=104，表示人数）、边数M（<=33*N，表示社交关系数）。随后的M行对应M条边，每行给出一对正整数，分别是该条边直接连通的两个结点的编号（节点从1到N编号）。
 
 输出格式说明：
 
 对每个结点输出与该结点距离不超过6的结点数占结点总数的百分比，精确到小数点后2位。每个结节点输出一行，格式为“结点编号:（空格）百分比%”。
 
 样例输入与输出：
 
 序号	输入	输出
 1
 10 9
 1 2
 2 3
 3 4
 4 5
 5 6
 6 7
 7 8
 8 9
 9 10
 1: 70.00%
 2: 80.00%
 3: 90.00%
 4: 100.00%
 5: 100.00%
 6: 100.00%
 7: 100.00%
 8: 90.00%
 9: 80.00%
 10: 70.00%
 2
 10 8
 1 2
 2 3
 3 4
 4 5
 5 6
 6 7
 7 8
 9 10
 1: 70.00%
 2: 80.00%
 3: 80.00%
 4: 80.00%
 5: 80.00%
 6: 80.00%
 7: 80.00%
 8: 70.00%
 9: 20.00%
 10: 20.00%
 3
 11 10
 1 2
 1 3
 1 4
 4 5
 6 5
 6 7
 6 8
 8 9
 8 10
 10 11
 1: 100.00%
 2: 90.91%
 3: 90.91%
 4: 100.00%
 5: 100.00%
 6: 100.00%
 7: 100.00%
 8: 100.00%
 9: 100.00%
 10: 100.00%
 11: 81.82%
 4	
 2 1
 1 2
 1: 100.00%
 2: 100.00%
*/