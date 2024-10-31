#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    //* A. Add
    //* https://codeforces.com/group/MWSDmqGsZm/contest/223205/problem/A
    // int x, y;
    // scanf("%d %d", &x, &y);
    // int *a = &x;
    // int *b = &y;
    // printf("%d\n", *a + *b);

    // return 0;

    //* E. Swap
    //* https://codeforces.com/group/MWSDmqGsZm/contest/223205/problem/E
    int x, y;
    scanf("%d %d", &x, &y);
    int *a = &x;
    int *b = &y;
    int temp = *a;
    *a = *b;
    *b = temp;
    printf("%d %d\n", *a, *b);

    return 0;
}