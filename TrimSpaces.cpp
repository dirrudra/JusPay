#include <cstring>
void trimSpaces(char input[]) {
int len = strlen(input);
int count = 0;
for (int i = 0; i < len; i++) {
if (input[i] != ' ') {
input[count++] = input[i];
}
}
input[count] = '\0';
}