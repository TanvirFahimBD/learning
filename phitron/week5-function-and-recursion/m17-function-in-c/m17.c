#include <stdio.h>
#include <string.h>

int main()
{
    //* 17-3 Return + Parameter
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/V
    int n, m;
    scanf("%d%d", &n, &m);
    int a[n + 1];
    int a2[m + 1];

    for (int i = 1; i <= m; i++)
    {
        a2[i] = 0;
    }

    for (int i = 0; i < n; i++)
    {
        int value;
        scanf("%d", &value);
        a2[value]++;
    }

    for (int i = 1; i <= m; i++)
    {
        printf("%d\n", a2[i]);
    }

    return 0;
}