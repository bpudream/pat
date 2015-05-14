//
//  6.8(AOE).c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-14.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

#define INFINITE 9000001

typedef struct _list {
    int value;
    int length;
    struct _list* next;
} List;

List* createNode(int value, int length) {
    List* t = (List*)malloc(sizeof(List));
    t->value = value;
    t->length = length;
    t->next = NULL;
    return t;
}

void addNode(List* list, int value, int length) {
    List* node = createNode(value, length);
    node->next = list->next;
    list->next = node;
}

void enqueue(List* list, int value) {
    List* node = createNode(value, 0);
    List* t = list;
    while(t->next) {
        t = t->next;
    }
    t->next = node;
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

int main() {
    int n, m;
    scanf("%d", &n);
    scanf("%d", &m);
    n++;
    
    List* graph[n];
    List* reverseGraph[n];
    int inDegree[n];
    int earliest[n];
    int latest[n];
    
    for(int i = 1; i < n; i++) {
        graph[i] = createNode(i, 0);
        reverseGraph[i] = createNode(i, 0);
        inDegree[i] = 0;
        earliest[i] = 0;
        latest[i] = INFINITE;
    }
    
    for(int i = 0; i < m; i++) {
        int src, dest, length;
        scanf("%d", &src);
        scanf("%d", &dest);
        scanf("%d", &length);
        
        addNode(graph[src], dest, length);
        addNode(reverseGraph[dest], src, length);
        inDegree[dest]++;
    }
    
    int max = 0;
    int maxIndex = -1;
    List* queue = createNode(-255, 0);
    for(int i = 1; i < n; i++) {
        if(inDegree[i] == 0)
            enqueue(queue, i);
    }
    int index;
    for(index = 1; index < n; index++) {
        int src = dequeue(queue);
        if(src < 0)
            break;
        List* links = graph[src];
        while(links->next) {
            int dest = links->next->value;
            if((--inDegree[dest]) == 0) {
                enqueue(queue, dest);
            }
            if(earliest[dest] < earliest[src] + links->next->length) {
                earliest[dest] = earliest[src] + links->next->length;
                if(earliest[dest] > max) {
                    max = earliest[dest];
                    maxIndex = dest;
                }
            }
            links = links->next;
        }
    }
    
    if(index < n) {
        printf("0\n");
    }
    else {
        printf("%d\n", max);
        
        latest[maxIndex] = max;
        List* queue = createNode(-511, 0);
        enqueue(queue, maxIndex);
        
        while(queue->next) {
            int dest = dequeue(queue);
            if(dest < 0)
                break;
            List* links = reverseGraph[dest];
            while(links->next) {
                int src = links->next->value;
                if(latest[src] > latest[dest] - links->next->length) {
                    latest[src] = latest[dest] - links->next->length;
                }
                enqueue(queue, src);
                links = links->next;
            }
        }
        
//        printf("Earliest: \n");
//        for(int i = 1; i < n; i++) {
//            printf("%d ", earliest[i]);
//        }
//        printf("\n");
//        
//        printf("Latest: \n");
//        for(int i = 1; i < n; i++) {
//            printf("%d ", latest[i]);
//        }
//        printf("\n");
        
        List* res[m];
        int counter = 0;
        
        // traversal all V
        for(int i = 1; i < n; i++) {
            List* links = graph[i];
            //int src = i;
            int dest;
            while(links->next) {
                dest = links->next->value;
                if(latest[dest] == earliest[i] + links->next->length)
                    res[counter++] = createNode(i, dest);
                links = links->next;
            }
        }
        for(int i = 0; i < counter; i++) {
            printf("%d->%d\n", res[i]->value, res[i]->length);
        }
    }
    
    return 0;
}

/*
 本实验项目是实验项目6-06的深化。任务调度问题中，如果还给出了完成每个子任务需要的时间，则我们可以算出完成整个工程需要的最短时间。在这些子任务中，有些任务即使推迟几天完成，也不会影响全局的工期；但是有些任务必须准时完成，否则整个项目的工期就要因此延误，这种任务就叫“关键活动”。
 
 请编写程序判定一个给定的工程项目的任务调度是否可行；如果该调度方案可行，则计算完成整个工程项目需要的最短时间，并输出所有的关键活动。
 
 输入格式说明：
 
 输入第1行给出两个正整数N(<=100)和M，其中N是任务交接点（即衔接相互依赖的两个子任务的节点，例如：若任务2要在任务1完成后才开始，则两任务之间必有一个交接点）的数量，交接点按1~N编号，M是子任务的数量，依次编号为1~M。随后M行，每行给出了3个正整数，分别是该任务开始和完成涉及的交接点编号以及该任务所需的时间，整数间用空格分隔。
 
 输出格式说明：
 
 如果任务调度不可行，则输出0；否则第1行输出完成整个工程项目需要的时间，第2行开始输出所有关键活动，每个关键活动占一行，按格式“V->W”输出，其中V和W为该任务开始和完成涉及的交接点编号。关键活动输出的顺序规则是：任务开始的交接点编号小者优先，起点编号相同时，与输入时任务的顺序相反。如下面测试用例2中，任务<5,7>先于任务<5,8>输入，而作为关键活动输出时则次序相反。
 
 样例输入与输出：
 
 序号	输入	输出
 
 7 8
 1 2 4
 1 3 3
 2 4 5
 3 4 3
 4 5 1
 4 6 6
 5 7 5
 6 7 2
 
 17
 1->2
 2->4
 4->6
 6->7
 
 
 9 11
 1 2 6
 1 3 4
 1 4 5
 2 5 1
 3 5 1
 4 6 2
 5 7 9
 5 8 7
 6 8 4
 7 9 2
 8 9 4
 
 18
 1->2
 2->5
 5->8
 5->7
 7->9
 8->9
 
 
 
 11 14
 1 2 4
 1 3 3
 2 4 5
 3 4 3
 4 5 1
 4 6 6
 5 7 5
 6 7 2
 8 3 7
 9 3 7
 9 10 6
 4 10 2
 10 6 5
 6 11 4
 
 21
 3->4
 4->10
 6->11
 8->3
 9->3
 10->6
 
	
 
 4 5
 1 2 4
 2 3 5
 3 4 6
 4 2 3
 4 1 2
 
 0
*/