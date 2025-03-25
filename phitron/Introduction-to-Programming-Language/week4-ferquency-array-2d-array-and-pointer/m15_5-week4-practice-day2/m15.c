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
    // int x, y;
    // scanf("%d %d", &x, &y);
    // int *a = &x;
    // int *b = &y;
    // int temp = *a;
    // *a = *b;
    // *b = temp;
    // printf("%d %d\n", *a, *b);

    // return 0;

    //* K. Max and Min
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/K
    // int x, y, z;
    // scanf("%d %d %d", &x, &y, &z);
    // int *a = &x;
    // int *b = &y;
    // int *c = &z;

    // if (*a <= *b && *a <= *c)
    // {
    //     printf("%d ", *a);
    // }
    // else if (*b <= *a && *b <= *c)
    // {
    //     printf("%d ", *b);
    // }
    // else
    // {
    //     printf("%d ", *c);
    // }

    // if (*a >= *b && *a >= *c)
    // {
    //     printf("%d", *a);
    // }
    // else if (*b >= *a && *b >= *c)
    // {
    //     printf("%d", *b);
    // }
    // else
    // {
    //     printf("%d", *c);
    // }

    // return 0;

    //* A. Summation
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/A
    // int n;
    // long long int sum = 0;
    // scanf("%d", &n);
    // int ar[n];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &ar[i]);
    // }
    // int *ptr = ar;

    // while (ptr < ar + n)
    // {
    //     sum += *ptr;
    //     ptr++;
    // }

    // if (sum < 0)
    // {
    //     printf("%lld", sum * (-1));
    // }
    // else
    // {
    //     printf("%lld", sum);
    // }

    // return 0;

    //* C. Replacement
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/C
    int n;
    long long int sum = 0;
    scanf("%d", &n);
    int ar[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &ar[i]);
    }
    int *ptr = ar;

    while (ptr < ar + n)
    {

        if (*ptr < 0)
        {
            *ptr = 2;
        }
        else if (*ptr == 0)
        {
            *ptr = 0;
        }
        else
        {
            *ptr = 1;
        }
        ptr++;
    }

    for (int i = 0; i < n; i++)
    {
        printf("%d ", ar[i]);
    }

    return 0;
}