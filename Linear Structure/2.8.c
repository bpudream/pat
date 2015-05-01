#include <stdio.h>
#include <stdlib.h>

typedef struct _stack {
    int type;
    double num;
    char op;
    struct _stack* next;
} Stack;

Stack* createStack(int type, double num, char op) {
    Stack* s = (Stack*)malloc(sizeof(Stack));
    s->type = type;
    s->next = NULL;
    if(type) {
        s->num = num;
    }
    else {
        s->op = op;
    }
    return s;
}

Stack* pop(Stack* s) {
    Stack* temp = NULL;
    if(s->next) {
        temp = s->next;
        s->next = temp->next;
    }
    return temp;
}

void push(Stack* top, Stack* node) {
    node->next = top->next;
    top->next = node;
}

typedef struct _stringstack {
    char str[16];
    struct _stringstack* next;
} StringStack;

StringStack* popString(StringStack* s) {
    StringStack* temp = NULL;
    if(s->next) {
        temp = s->next;
        s->next = temp->next;
    }
    return temp;
}

void pushString(StringStack* top, StringStack* node) {
    node->next = top->next;
    top->next = node;
}

void createStringNum(double num, char* res) {
    int n = (int)num;
    if (num < 10) {
        res[0] = '0' + n;
        res[1] = '\0';
    }
    else {
        res[0] = '1';
        res[1] = '0' + (n - 10);
        res[2] = '\0';
    }
}

void createStringOp(char op, char* res) {
    res[0] = op;
    res[1] = '\0';
}

void createStringStr(char* str1, char* str2, char op, char* res, int tag) {
    int x = 0;
    if(tag)
        res[x++] = '(';
    int i = 0;
    while(str1[i] != '\0') {
        res[x++] = str1[i++];
    }
    res[x++] = op;
    int j = 0;
    while(str2[j] != '\0') {
        res[x++] = str2[j++];
    }
    if(tag)
        res[x++] = ')';
    res[x] = '\0';
}

double calculate(double a, double b, char op) {
    double res = 0;
    switch(op) {
        case '+':
            res = b + a;
            break;
        case '-':
            res = b - a;
            break;
        case '*':
            res = 1.0 * b * a;
            break;
        case '/':
            if(a != 0) {
                res = 1.0 * b / a;
            }
            else {
                res = -32768;
            }
            break;
    }
    return res;
}

int found24 = 0;
char op[4];
double num[4];
Stack* s[7];
int x[3], y[4];
StringStack* resultString;

void loop() {
    for(x[0] = 0; x[0] < 4; x[0]++) {
        for(x[1] = 0; x[1] < 4; x[1]++) {
            for(x[2] = 0; x[2] < 4; x[2]++) {
                for(y[0] = 0; y[0] < 4; y[0]++) {
                    for(y[1] = 0; y[1] < 4; y[1]++){
                        if(y[1] == y[0])
                            continue;
                        for(y[2] = 0; y[2] < 4; y[2]++) {
                            if(y[2] == y[0] || y[2] == y[1])
                                continue;
                            for(y[3] = 0; y[3] < 4; y[3]++) {
                                if(y[3] == y[0] || y[3] == y[1] || y[3] == y[2])
                                    continue;
                                int indexop = 0;
                                int indexnum = 0;
                                Stack* expr = (Stack*)malloc(sizeof(Stack));
                                expr->next = NULL;
                                for(int i = 0; i < 7; i++) {
                                    if(s[i]->type) {
                                        s[i]->num = num[y[indexnum++]];
                                        push(expr, s[i]);
                                    }
                                    else {
                                        s[i]->op = op[x[indexop++]];
                                        Stack* ta = pop(expr);
                                        Stack* tb = pop(expr);
                                        double result = calculate(ta->num, tb->num, s[i]->op);
                                        Stack* temp = createStack(2, result, ' ');
                                        push(expr, temp);
                                    }
                                }
                                Stack* res = pop(expr);
                                if(res->num == 24.0) {
                                    found24 = 1;
                                    for(int i = 0; i < 7; i++) {
                                        if(s[i]->type) {
                                            StringStack* st = (StringStack*)malloc(sizeof(StringStack));
                                            createStringNum(s[i]->num, st->str);
                                            pushString(resultString, st);
                                        }
                                        else {
                                            StringStack* st = (StringStack*)malloc(sizeof(StringStack));
                                            StringStack* tb = popString(resultString);
                                            StringStack* ta = popString(resultString);
                                            int tag = 1;
                                            if(i == 6) {
                                                tag = 0;
                                            }
                                            createStringStr(ta->str, tb->str, s[i]->op, st->str, tag);
                                            pushString(resultString, st);
                                        }
                                    }
                                    free(res);
                                    goto BINGO;
                                }
                                free(res);
                            }
                        }
                    }
                }
            }
        }
    }
BINGO:
    return;
}

void case1() {
    s[2]->type = 1;
    s[3]->type = 1;
    s[4]->type = 0;
    s[5]->type = 0;
    loop();
}

void case2() {
    s[2]->type = 1;
    s[3]->type = 0;
    s[4]->type = 1;
    s[5]->type = 0;
    loop();
}

void case3() {
    s[2]->type = 1;
    s[3]->type = 0;
    s[4]->type = 0;
    s[5]->type = 1;
    loop();
}

void case4() {
    s[2]->type = 0;
    s[3]->type = 1;
    s[4]->type = 0;
    s[5]->type = 1;
    loop();
}

void case5() {
    s[2]->type = 0;
    s[3]->type = 1;
    s[4]->type = 1;
    s[5]->type = 0;
    loop();
}

int main() {
    
    op[0] = '+';
    op[1] = '-';
    op[2] = '*';
    op[3] = '/';
    
    for(int i = 0; i < 4; i++) {
        scanf("%lf", &num[i]);
    }
    
    for(int i = 0; i < 7; i++) {
        s[i] = (Stack*)malloc(sizeof(Stack));
    }
    s[0]->type = 1;
    s[1]->type = 1;
    s[6]->type = 0;
    
    resultString = (StringStack*)malloc(sizeof(StringStack));
    resultString->next = NULL;
    
    case1();
    if(!found24)
        case2();
    if(!found24)
        case3();
    if(!found24)
        case4();
    if(!found24)
        case5();
    
    StringStack* temp = resultString;
    while(temp->next) {
        printf("%s\n", temp->next->str);
        temp = temp->next;
    }
    if(!found24) {
        printf("-1\n");
    }
    return 0;
}