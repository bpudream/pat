//
//  4.3.c
//  data structure
//
//  Created by Xuchao Ding on 2015-04-26.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

/*
 In 1953, David A. Huffman published his paper "A Method for the Construction of Minimum-Redundancy Codes", and hence printed his name in the history of computer science. As a professor who gives the final exam problem on Huffman codes, I am encountering a big problem: the Huffman codes are NOT unique. For example, given a string "aaaxuaxz", we can observe that the frequencies of the characters 'a', 'x', 'u' and 'z' are 4, 2, 1 and 1, respectively. We may either encode the symbols as {'a'=0, 'x'=10, 'u'=110, 'z'=111}, or in another way as {'a'=1, 'x'=01, 'u'=001, 'z'=000}, both compress the string into 14 bits. Another set of code can be given as {'a'=0, 'x'=11, 'u'=100, 'z'=101}, but {'a'=0, 'x'=01, 'u'=011, 'z'=001} is NOT correct since "aaaxuaxz" and "aazuaxax" can both be decoded from the code 00001011001001. The students are submitting all kinds of codes, and I need a computer program to help me determine which ones are correct and which ones are not.
 
 Input Specification:
 
 Each input file contains one test case. For each case, the first line gives an integer N (2 <= N <= 63), then followed by a line that contains all the N distinct characters and their frequencies in the following format:
 
 c[1] f[1] c[2] f[2] ... c[N] f[N]
 where c[i] is a character chosen from {'0' - '9', 'a' - 'z', 'A' - 'Z', '_'}, and f[i] is the frequency of c[i] and is an integer no more than 1000. The next line gives a positive integer M (<=1000), then followed by M student submissions. Each student submission consists of N lines, each in the format:
 
 c[i] code[i]
 where c[i] is the i-th character and code[i] is a string of '0's and '1's.
 
 Output Specification:
 
 For each test case, print in each line either “Yes” if the student’s submission is correct, or “No” if not.
 
 Sample Input:
 7
 A 1 B 1 C 1 D 3 E 3 F 6 G 6
 4
 A 00000
 B 00001
 C 0001
 D 001
 E 01
 F 10
 G 11
 A 01010
 B 01011
 C 0100
 D 011
 E 10
 F 11
 G 00
 A 000
 B 001
 C 010
 D 011
 E 100
 F 101
 G 110
 A 00000
 B 00001
 C 0001
 D 001
 E 00
 F 10
 G 11
 Sample Output:
 Yes
 Yes
 No
 No
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct _tree {
    char key;
    int weight;
    int level;
//    char code[16];
    struct _tree* left;
    struct _tree* right;
} Tree;

Tree* insertBT(Tree* root, Tree* node) {
    if(!root) {
        return node;
    }
    if (node->key < root->key) {
        root->left = insertBT(root->left, node);
    }
    else {
        root->right = insertBT(root->right, node);
    }
    return root;
}

Tree* findBT(Tree* root, char key) {
    if(root) {
        return NULL;
    }
    if(key < root->key) {
        return findBT(root->left, key);
    }
    else if(key > root->key) {
        return findBT(root->right, key);
    }
    else {
        return root;
    }
}

Tree* createHuffmanNode() {
    Tree* t = (Tree*)malloc(sizeof(Tree));
    t->key = '*';
    t->weight = 0;
    t->level = 0;
    t->left = NULL;
    t->right = NULL;
    return t;
}

void copy(Tree* from, Tree* to) {
    to->key = from->key;
    to->weight = from->weight;
    to->left = from->left;
    to->right = from->right;
}

void traversal(Tree* t) {
    if(!t) {
        return;
    }
    printf("%c ", t->key);
    traversal(t->left);
    traversal(t->right);
}

int getHeight(Tree* t) {
    if(!t) {
        return 0;
    }
    else {
        int max = t->left->level > t->right->level ? t->left->level : t->right->level;
        t->level = max + 1;
    }
    return t->level;
}

void setLevels(Tree* t, int height) {
    if(!t) {
        return;
    }
    else {
        t->level = height;
        setLevels(t->left, height + 1);
        setLevels(t->right, height + 1);
    }
}

int getSum(Tree* t) {
    if(!t) {
        return 0;
    }
    if(t->key == '*') {
        return getSum(t->left) + getSum(t->right);
    }
    else {
        return t->weight * t->level + getSum(t->left) + getSum(t->right);
    }
}

int weighting(Tree* huffman) {
    if(!huffman) {
        return 0;
    }
    setLevels(huffman, 0);
    return getSum(huffman);
}

void siftdown(Tree** heap, int n, int i) {
    while(i * 2 + 1 < n) {
        int next = i * 2 + 1;
        int right = i * 2 + 2;
        if(right < n && heap[right]->weight < heap[next]->weight) {
            next = right;
        }
        
        if(heap[next]->weight < heap[i]->weight) {
            Tree* temp = heap[i];
            heap[i] = heap[next];
            heap[next] = temp;
            i = next;
        }
        else {
            break;
        }
    }
}

void heapify(Tree** heap, int n) {
    for(int i = (n - 2) / 2; i >= 0; i--) {
        siftdown(heap, n, i);
    }
//    printf("After Heapify: ");
//    for(int i = 0; i<n; i++) {
//        printf("%c ", heap[i]->key);
//    }
//    printf("\n");
}

Tree* heapDelete(Tree** heap, int n) {
    Tree* temp = heap[0];
    heap[0] = heap[n-1];
    heap[n-1] = temp;
    siftdown(heap, n-1, 0);
//        printf("After Delete: ");
//        for(int i = 0; i<n; i++) {
//            printf("%c ", heap[i]->key);
//        }
//        printf("\n");
    return heap[n-1];
}

void siftup(Tree** heap, int n) {
    while (n > 0) {
        int parent = (n - 1) / 2;
        if(heap[n]->weight > heap[parent]->weight) {
            return;
        }
        else {
            Tree* tmp = heap[n];
            heap[n] = heap[parent];
            heap[parent] = tmp;
            
            n = parent;
        }
    }
}

void heapAdd(Tree** heap, int n, Tree* node) {
    heap[n] = node;
    siftup(heap, n);
}

int huffmanWeight(Tree** heap, int n) {
    heapify(heap, n);
    while(n > 1) {
        Tree* huff =createHuffmanNode();
        huff->left = heapDelete(heap, n--);
        huff->right = heapDelete(heap, n--);
        huff->weight = huff->left->weight + huff->right->weight;
        heapAdd(heap, n++, huff);
    }
    
    return weighting(heap[0]);
}

int main() {
    int n;
    scanf("%d", &n);
    
    Tree* charset[n];
    
    for(int i = 0; i < n; i++) {
        charset[i] = (Tree*)malloc(sizeof(Tree));
        char str[2];
        scanf("%s", str);
        scanf("%d", &charset[i]->weight);
        charset[i]->key = str[0];
        charset[i]->left = NULL;
        charset[i]->right = NULL;
    }
    
    Tree* tempset[n];
    for(int i = 0; i < n; i++) {
        tempset[i] = (Tree*)malloc(sizeof(Tree));
        copy(charset[i], tempset[i]);
    }
    int rw = huffmanWeight(tempset, n);
    for(int i = 0; i < n; i++) {
        free(tempset[i]);
    }
    
    int m;
    scanf("%d", &m);
    for(int i = 0; i < m; i++) { // for each submission
        Tree* huffman = createHuffmanNode();
        int valid = 1;
        int j;
        for(j = 0; j < n && valid; j++) { // for each char
            char notcare[2];
            scanf("%s", notcare);
            char code[8];
            scanf("%s", code);
            Tree* temp = huffman;
            
            for(int k = 0; code[k] != '\0'; k++) {
                if(code[k] == '0') {
                    if(!temp->left) {
                        temp->left = createHuffmanNode();
                    }
                    else {
                        if(temp->left->key != '*') {
                            valid = 0;
                            //printf("node duplicate.\n");
                            break;
                        }
                    }
                    temp = temp->left;
                }
                else {
                    if(!temp->right) {
                        temp->right = createHuffmanNode();
                    }
                    else {
                        if(temp->right->key != '*') {
                            valid = 0;
                            break;
                        }
                    }
                    temp = temp->right;
                }
            } // end of k
            
            if(temp->left || temp->right) {
                valid = 0;
                j++;
                break;
            }
            copy(charset[j], temp);
        } // end of j
        
        if(j < n) {
            for(j; j < n; j++) {
                char notcare[2];
                scanf("%s", notcare);
                char code[8];
                scanf("%s", code);
            }
        } // read unused inputs
        
        if(valid) { // what's valid? All chars are Huffman's leaves.
//            traversal(huffman);
            int aw = weighting(huffman);
           
            if(aw == rw) {
                printf("Yes\n");
            }
            else {
                printf("No\n");
            }
        }
        else {
            printf("No\n");
        }
    } // end of i

    return 0;
}

//    char str[8];
//    scanf("%s", str);
//    int i;
//    for(i = 0; str[i] != '\0'; i++) {
//        printf("%c\n", str[i]);
//    }
//    printf("%d\n", i);

