//
//  8.6.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-28.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _list {
    int id;
    int* score;
    int perfecto;
//    struct _list* next;
} List;

List* createNode(int id, int k) {
    List* node = (List*)malloc(sizeof(List));
//    node->next = NULL;
    node->id = id;
    node->perfecto = 0;
    node->score = (int*)malloc(sizeof(int) * (k + 1));
    for(int i = 0; i <= k; i++) {
        node->score[i] = -255;
    }
    return node;
}

int compare(int father, int child, List** users) {
    int res = -1;
    List* a = users[father];
    List* b = users[child];
    if(a->score[0] > b->score[0])
        res = 1;
    else if(a->score[0] == b->score[0]) {
        if(a->perfecto > b->perfecto)
            res = 1;
        else if(a->perfecto == b->perfecto)
            res = b->id - a->id;
    }
    return res;
}

void siftup(int* indextable, List** users, int n) {
    int parent;
    while(n > 0) {
        parent = (n - 1) / 2;
        
        if(compare(indextable[parent], indextable[n], users) < 0)
            return;
        else {
            int temp = indextable[parent];
            indextable[parent] = indextable[n];
            indextable[n] = temp;
        }
        
        n = parent;
    }
}

void siftdown(int* indextable, List** users, int current, int length) {
    int next = current * 2 + 1;
    while(next < length) {
        if(next + 1 < length && compare(indextable[next + 1], indextable[next], users) < 0)
            next = next + 1;
        if(compare(indextable[next], indextable[current], users) < 0) {
            int temp = indextable[current];
            indextable[current] = indextable[next];
            indextable[next] = temp;
        }
        else {
            return;
        }
        current = next;
    }
}

void HeapSort(int* indextable, List** users, int n) {
    while (n > 1) {
        int temp = indextable[0];
        indextable[0] = indextable[n - 1];
        indextable[n - 1] = temp;
        n--;
        siftdown(indextable, users, 0, n);
    }
}

int main() {
    int n, k, m;
    scanf("%d %d %d", &n, &k, &m);
    
    List* users[n + 1];
    
    for(int i = 0; i <= n; i++)
        users[i] = NULL;
    
    int perfect[k + 1];
    int indextable[n];
    int validNumber = 0;
    
    for(int i = 1; i <= k ;i++)
        scanf("%d", &perfect[i]);
    
    for(int i = 0; i < m; i++) {
        int id, qn, mark;
        scanf("%d %d %d", &id, &qn, &mark);
        
        if(!users[id]) {
            users[id] = createNode(id, k);
            users[id]->score[qn] = mark;
            users[id]->score[0] = mark;
        }
        else {
            if(users[id]->score[qn] < mark) {
                if(mark >= 0) {
                    if(users[id]->score[0] < 0)
                        users[id]->score[0] = mark;
                    else {
                        if(users[id]->score[qn] < 0)
                            users[id]->score[0] += mark;
                        else
                            users[id]->score[0] += (mark - users[id]->score[qn]);
                    }
                }
                users[id]->score[qn] = mark;
            }
        }
        if(mark == perfect[qn]) {
            users[id]->perfecto = users[id]->perfecto + 1;
        }
        
    }
    
    for(int i = 0; i <= n; i++) {
        if(!users[i] || users[i]->score[0] < 0)
            continue;
        else {
            indextable[validNumber] = i;
            siftup(indextable, users, validNumber);
            validNumber++;
        }
    }
    
    HeapSort(indextable, users, validNumber);
    
    int rank = 0;
    int nextrank = 1;
    int previous = -127;
    
    for(int i = 0; i < validNumber; i++) {
        List* user = users[indextable[i]];
        int total = user->score[0];
        if(total == previous) {
            nextrank++;
        }
        else {
            previous = total;
            rank = nextrank++;
        }
        printf("%d %05d %d", rank, user->id, total);
        
        for(int j = 1; j <= k; j++) {
            int val = user->score[j];
            if(val == -255) {
                printf(" -");
            }
            else if(val == -1) {
                printf(" 0");
            }
            else {
                printf(" %d", val);
            }
        }
        
        printf("\n");
    }
    
    return 0;
}

/*
 The ranklist of PAT is generated from the status list, which shows the scores of the submittions. This time you are supposed to generate the ranklist for PAT.
 
 Input Specification:
 
 Each input file contains one test case. For each case, the first line contains 3 positive integers, N (<=104), the total number of users, K (<=5), the total number of problems, and M (<=105), the total number of submittions. It is then assumed that the user id's are 5-digit numbers from 00001 to N, and the problem id's are from 1 to K. The next line contains K positive integers p[i] (i=1, ..., K), where p[i] corresponds to the full mark of the i-th problem. Then M lines follow, each gives the information of a submittion in the following format:
 
 user_id problem_id partial_score_obtained
 
 where partial_score_obtained is either -1 if the submittion cannot even pass the compiler, or is an integer in the range [0, p[problem_id]]. All the numbers in a line are separated by a space.
 
 Output Specification:
 
 For each test case, you are supposed to output the ranklist in the following format:
 
 rank user_id total_score s[1] ... s[K]
 
 where rank is calculated according to the total_score, and all the users with the same total_score obtain the same rank; and s[i] is the partial score obtained for the i-th problem. If a user has never submitted a solution for a problem, then "-" must be printed at the corresponding position. If a user has submitted several solutions to solve one problem, then the highest score will be counted.
 
 The ranklist must be printed in non-decreasing order of the ranks. For those who have the same rank, users must be sorted in nonincreasing order according to the number of perfectly solved problems. And if there is still a tie, then they must be printed in increasing order of their id's. For those who has never submitted any solution that can pass the compiler, or has never submitted any solution, they must NOT be shown on the ranklist. It is guaranteed that at least one user can be shown on the ranklist.
 
 Sample Input:
 7 4 20
 20 25 25 30
 00002 2 12
 00007 4 17
 00005 1 19
 00007 2 25
 00005 1 20
 00002 2 2
 00005 1 15
 00001 1 18
 00004 3 25
 00002 2 25
 00005 3 22
 00006 4 -1
 00001 2 18
 00002 1 20
 00004 1 15
 00002 4 18
 00001 3 4
 00001 4 2
 00005 2 -1
 00004 2 0
 Sample Output:
 1 00002 63 20 25 - 18
 2 00005 42 20 0 22 -
 2 00007 42 - 25 - 17
 2 00001 42 18 18 4 2
 5 00004 40 15 0 25 -
 */
