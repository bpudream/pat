//
//  heap.c
//  data structure
//
//  Created by Xuchao Ding on 2015-04-25.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef struct {
    int* elements;
    int size;
    int maxSize;
} Heap;

void siftDown(Heap* h, int init);

Heap* create(int maxSize) {
    Heap* h = (Heap*)malloc(sizeof(Heap));
    h->elements = (int*)malloc(sizeof(int) * maxSize);
    h->size = 0;
    h->maxSize = maxSize;
    return h;
}

void heapify(Heap* h) {
    int init = (h->size - 1 - 1) / 2;
    for(int i = init; i >= 0; i--) {
        siftDown(h, i);
    }
}

void siftDown(Heap* h, int init) {
    int child;
    for(int i = init; i * 2 + 1 < h->size; i = child) {
        child = i * 2 + 1;
        if(child + 1 < h->size && h->elements[child + 1] > h->elements[child]) {
            child = child + 1;
        }
        
        if(h->elements[i] < h->elements[child]) {
            int temp = h->elements[i];
            h->elements[i] = h->elements[child];
            h->elements[child] = temp;
        }
        else {
            break;
        }
    }
}

void insert(Heap* h, int value){
    if(h->size < h->maxSize) {
        int i = h->size++;
        h->elements[i] = value;
        /* Maintain Heapified */
        do {
            if(h->elements[i] > h->elements[(i-1)/2]) {
                int temp = h->elements[i];
                h->elements[i] = h->elements[(i-1)/2];
                h->elements[(i-1)/2] = temp;
                i = (i - 1) / 2;
            }
            else {
                return;
            }
        } while(i > 0);
    }
    else {
        printf("Heap full. Insertion failed.\n");
    }
}

int deleteMax(Heap* h) {
    if(h->size < 1) {
        printf("Heap empty. Deletion failed.\n");
        return -1;
    }
    
    int res = h->elements[0];
    h->elements[0] = h->elements[--h->size];
    
    siftDown(h, 0);
    
    return res;
}

void printHeap(Heap* h) {
    for(int i = 0; i < h->size; i++) {
        printf("%d ", h->elements[i]);
    }
    printf("\n");
}

int main() {
    Heap* h = create(100);
    
    insert(h, 4);
    insert(h, 2);
    insert(h, 3);
    insert(h, 1);
    insert(h, 5);
    
    printHeap(h);
    
    deleteMax(h);
    printHeap(h);
    
    deleteMax(h);
    printHeap(h);
    
    return 0;
}