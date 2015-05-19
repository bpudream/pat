////
////  c11.1.c
////  data structure
////
////  Created by Xuchao Ding on 2015-05-18.
////  Copyright (c) 2015 Xuchao Ding. All rights reserved.
////
//#include <stdio.h>
//
//typedef struct {
//    char name[12];
//    char birth[12];
//    char sex[2];
//    char telephone[18];
//    char cellphone[18];
//} Contact;
//
//int main() {
//    int n, k;
//    scanf("%d", &n);
//    
//    Contact contact[n];
//    for(int i = 0; i < n; i++) {
//        scanf("%s", contact[i].name);
//        scanf("%s", contact[i].birth);
//        scanf("%s", contact[i].sex);
//        scanf("%s", contact[i].telephone);
//        scanf("%s", contact[i].cellphone);
//    }
//    
//    scanf("%d", &k);
//    for(int i = 0; i < k; i++) {
//        int index;
//        scanf("%d", &index);
//        if(!(index < n && index >= 0)) {
//            printf("Not Found\n");
//        }
//        else {
//            printf("%s", contact[index].name);
//            printf(" %s", contact[index].telephone);
//            printf(" %s", contact[index].cellphone);
//            printf(" %s", contact[index].sex);
//            printf(" %s\n", contact[index].birth);
//        }
//    }
//    
//    return 0;
//}
//
///*
// 11-1. 通讯录的录入与显示(10)
// 
// 通讯录中的一条记录包含下述基本信息：朋友的姓名、出生日期、性别、固定电话号码、移动电话号码。 本题要求编写程序，录入N条记录，并且根据要求显示任意某条记录。
// 
// 输入格式：
// 
// 输入在第1行给出正整数N（<=10）；随后N行，每行按照格式“姓名 生日 性别 固话 手机”给出一条记录。其中“姓名”是不超过10个字符、不包含空格的非空字符串；生日按“yyyy/mm/dd”的格式给出年月日；性别用“M”表示“男”、“F”表示“女”；“固话”和“手机”均为不超过15位的连续数字，前面有可能出现“+”。
// 
// 在通讯录记录输入完成后，最后一行给出正整数K，并且随后给出K个整数，表示要查询的记录编号（从0到N-1顺序编号）。数字间以空格分隔。
// 
// 输出格式：
// 
// 对每一条要查询的记录编号，在一行中按照“姓名 固话 手机 性别 生日”的格式输出该记录。若要查询的记录不存在，则输出“Not Found”。
// 
// 输入样例：
// 3
// Chris 1984/03/10 F +86181779452 13707010007
// LaoLao 1967/11/30 F 057187951100 +8618618623333
// QiaoLin 1980/01/01 M 84172333 10086
// 2 1 7
// 输出样例：
// LaoLao 057187951100 +8618618623333 F 1967/11/30
// Not Found
// 
// 
// 3
// Chris 1984/03/10 F +86181779452 13707010007
// LaoLao 1967/11/30 F 057187951100 +8618618623333
// QiaoLin 1980/01/01 M 84172333 10086
// 4 1 7 3 2
//*/