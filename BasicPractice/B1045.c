#include <stdio.h>
#include <stdlib.h>
    int main() {
        int n;
        scanf("%d", &n);
        int arr[n];
        int res[n];
        int counter = 0;

        int leftMax[n];
        res[0] = 0;
        leftMax[0] = 0;
        scanf("%d", &arr[0]);
        for(int i = 1; i < n; i++) {
            scanf("%d", &arr[i]);
            leftMax[i] = leftMax[i - 1] > arr[i - 1] ? leftMax[i - 1] : arr[i - 1];
            res[i] = 0;
        }

        int rightMin[n];
        rightMin[n - 1] = arr[n - 1] + 1;
        if(arr[n - 1] > leftMax[n - 1]) {
            res[n -1] = 1;
            counter++;
        }
        for(int i = n - 2; i >= 0; i--) {
            rightMin[i] = rightMin[i + 1] < arr[i + 1] ? rightMin[i + 1] : arr[i + 1];
            if(arr[i] > leftMax[i] && arr[i] < rightMin[i]) {
                res[i] = 1;
                counter++;
            }
        }

        char space = '\n';
        printf("%d", counter);
        for(int i = 0; i < n; i++) {
            if(res[i]) {
                printf("%c%d", space, arr[i]);
                space = ' ';
            }
        }
        system("pause"); 
        return 0;
    }

