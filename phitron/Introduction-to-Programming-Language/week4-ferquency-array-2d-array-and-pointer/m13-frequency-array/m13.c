#include <stdio.h>
#include <string.h>

int main()
{
    //* V. Frequency Array
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/V
    // int n, m;
    // scanf("%d%d", &n, &m);
    // int a[n + 1];
    // int a2[m + 1];

    // for (int i = 1; i <= m; i++)
    // {
    //     a2[i] = 0;
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     int value;
    //     scanf("%d", &value);
    //     a2[value]++;
    // }

    // for (int i = 1; i <= m; i++)
    // {
    //     printf("%d\n", a2[i]);
    // }

    // return 0;

    //* 13-4 Implementing Frequency array
    // int n;
    // scanf("%d", &n);
    // int a[n + 5];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // int f[100000] = {0};

    // for (int i = 0; i < n; i++)
    // {
    //     f[a[i]] = 1;
    // }

    // for (int i = 0; i < 10; i++)
    // {
    //     printf("%d %d\n", i, f[i]);
    // }

    // int m;
    // scanf("%d", &m);

    // for (int i = 0; i < m; i++)
    // {
    //     int x;
    //     scanf("%d", &x);
    //     printf("%d ", x);

    //     if (f[x] == 1)
    //     {
    //         printf("Achec\n");
    //     }
    //     else
    //     {
    //         printf("Nei\n");
    //     }
    // }

    // return 0;

    //* 13-5. Unique Characters in A Stiring
    char str[10] = "abbccc";
    int f[26] = {0};

    int len = strlen(str);
    for (int i = 0; i < len; i++)
    {
        char ch = str[i];
        int index = ch - 97;
        f[index] = 1;
    }

    int count = 0;
    for (int i = 0; i < 26; i++)
    {
        count += f[i];
        if (f[i] == 1)
        {
            printf("%c %d\n", i + 'a', f[i]);
        }
    }
    printf("%d", count);

    return 0;
}