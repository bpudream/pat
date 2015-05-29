//
//  8.6.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-28.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//  http://www.patest.cn/submissions/1292621

#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, k, m;
    scanf("%d %d %d", &n, &k, &m);
    
    int score[k+1][n+1];
    int perfecto[n+1];
    
    for(int i = 0; i <= k; i++)
        for(int j = 0; j <= n; j++)
            score[i][j] = -255;
    
    for(int i = 0; i <= n; i++) {
        perfecto[i] = 0;
    }
    
    int perfect[k + 1];
    int indextable[n + 1];
    int validNumber = 0;
    
    for(int i = 1; i <= k ;i++)
        scanf("%d", &perfect[i]);
    
    for(int i = 0; i < m; i++) {
        int id, qn, mark;
        scanf("%d %d %d", &id, &qn, &mark);
        
        if(mark > score[qn][id]) {
            if(mark != -1) {
                int diff;
                if(score[qn][id] < 0)
                    diff = mark;
                else
                    diff = mark - score[qn][id];
                
                if(score[0][id] < 0)
                    score[0][id] = diff;
                else
                    score[0][id] += diff;
            }
            score[qn][id] = mark;
            if(mark == perfect[qn]) {
                perfecto[id]++;
            }
        }
    }
    
    // bucket sort on perfecto
    int bucket[k + 1][n + 1];
    int bucketLength[k + 1];
    for(int i = 0; i <= k; i++) {
        bucketLength[i] = 0;
    }
    for(int i = 0; i <= n; i++) {
        if(score[0][i] >= 0)
            bucket[perfecto[i]][bucketLength[perfecto[i]]++] = i;
    }
    
    for(int i = k; i >=0; i--) {
        for(int j = 0; j < bucketLength[i]; j++) {
            indextable[validNumber++] = bucket[i][j];
        }
    }
    
    // bucket sort on score, assume score <= 9999
    int radix[10][n + 1];
    int radixLength[10];
    
    int divisor = 1;
    int index, value;
    
    while(divisor <= 1000000000) {
        for(int i = 0; i < 10; i++) {
            radixLength[i] = 0;
        }
        for(int i = 0; i < validNumber; i++) {
            index = indextable[i];
            value = score[0][index];
            value = value / divisor % 10;
            radix[value][radixLength[value]++] = index;
        }
        
        int counter = 0;
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < radixLength[i]; j++) {
                indextable[counter++] = radix[i][j];
            }
        }
        if(divisor >= 1000000000)
            break;
        divisor *= 10;
    }
    
    int rank = 0;
    int nextrank = 1;
    int previous = -127;
    
    for(int i = 0; i < validNumber; i++) {
        int index = indextable[i];
        int total = score[0][index];
        if(total == previous) {
            nextrank++;
        }
        else {
            previous = total;
            rank = nextrank++;
        }
        printf("%d %05d %d", rank, index, total);
        
        for(int j = 1; j <= k; j++) {
            int val = score[j][index];
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
