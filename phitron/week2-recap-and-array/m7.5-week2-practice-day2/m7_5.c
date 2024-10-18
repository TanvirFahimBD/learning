#include <stdio.h>

int main()
{
    // A.Summation
    // https: // codeforces.com/group/MWSDmqGsZm/contest/219774/problem/A
    // int n;
    // long long int sum = 0;
    // scanf("%d", &n);
    // int arr[n];
    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &arr[i]);
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     sum = sum + arr[i];
    // }

    // if (sum < 0)
    // {
    //     printf("%lld\n", (sum * (-1)));
    // }
    // else
    // {
    //     printf("%lld\n", sum);
    // }

    // B.Searching
    // https: // codeforces.com/group/MWSDmqGsZm/contest/219774/problem/B
    // int n, res, pos, flag;
    // scanf("%d", &n);
    // int arr[n];
    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &arr[i]);
    // }

    // scanf("%d", &res);

    // for (int i = 0; i < n; i++)
    // {
    //     if (res == arr[i])
    //     {
    //         pos = i;
    //         flag = 1;
    //         break;
    //     }
    //     else
    //     {
    //         flag = 0;
    //         pos = -1;
    //     }
    // }

    // if (flag)
    // {
    //     printf("%d", pos);
    // }
    // else
    // {
    //     printf("%d", pos);
    // }

    // C. Replacement
    // https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/C
    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    for (int i = 0; i < n; i++)
    {
        if (arr[i] < 0)
        {
            arr[i] = 2;
        }
        else if (arr[i] > 0)
        {
            arr[i] = 1;
        }
    }

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }

    return 0;
}