#include <stdio.h>

void reverse(char* str) {
	char* t = str;
	int length = 0;
	while(t != NULL) {
		length++;
		t++;
	}
	char res[length];
	for(int i = 0; i < length; i++) {
		res[length - 1 - i] = str[i];
	}

	return res;
}

int main() {

	return 0;
}

//Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated
//  string.