//
//  0.2.c
//  data structure
//
//  Created by Xuchao Ding on 2015-05-06.
//  Copyright (c) 2015 Xuchao Ding. All rights reserved.
//

#include <stdio.h>
#include <math.h>

int main() {
    int n;
    scanf("%d", &n);
    int upperlimit = sqrt(n) + 1;
    
    int length = (n+1)/2 - 1;
    int arr[length];
    for(int i = 0; i < length; i++) {
        arr[i] = (i + 1) * 2 + 1;
    }
    
    int div = 0;
    int newcounter;
    int incounter = 1;
    
    while(arr[div] <= upperlimit) {
        newcounter = 0;
        for(int i = div + 1; i < length; i++) {
            if(arr[i] % arr[div] != 0)
                arr[incounter + (newcounter++)] = arr[i];
        }
        length = newcounter + incounter;
        incounter++;
        div++;
    }
    
    int current = 0;
    int next = current;
    int counter = 0;
    for(int i = 0; i < length; i++) {
        if(arr[i] > 0) {
//            printf("%d ", arr[i]);
            next = i;
            if(arr[next] - arr[current] == 2)
                counter++;
            current = next;
        }
    }
    
    printf("%d\n", counter);
    
    return 0;
}


/*
让我们定义 dn 为：dn = pn+1 - pn，其中 pi 是第i个素数。显然有 d1=1 且对于n>1有 dn 是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。

现给定任意正整数N (< 105)，请计算不超过N的满足猜想的素数对的个数。

输入格式：每个测试输入包含1个测试用例，给出正整数N。

输出格式：每个测试用例的输出占一行，不超过N的满足猜想的素数对的个数。

输入样例：
20
输出样例：
4
*/