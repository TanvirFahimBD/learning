#include <stdio.h>
#include <string.h>

int main()
{
    //* J. Count Letters
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/J
    // int count[26] = {0};
    // char str[10000001];
    // scanf("%s", str);

    // for (int i = 0; str[i] != '\0'; i++)
    // {
    //     count[str[i] - 'a']++;
    // }

    // for (int i = 0; i < 26; i++)
    // {
    //     if (count[i] > 0)
    //     {
    //         printf("%c : %d\n", i + 'a', count[i]);
    //     }
    // }

    // return 0;

    //* S. Search In Matrix
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/S
    // int n, m, x, flag = 0;
    // scanf("%d%d", &n, &m);
    // int ar[n + 5][m + 5];

    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         scanf("%d", &ar[i][j]);
    //     }
    // }

    // scanf("%d", &x);

    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         if (ar[i][j] == x)
    //         {
    //             flag = 1;
    //         }
    //     }
    // }

    // if (flag == 1)
    // {
    //     printf("will not take number\n");
    // }
    // else
    // {
    //     printf("will take number\n");
    // }

    // return 0;

    //* Practice Problem 5
    //* https://docs.google.com/document/d/1OJyO7DmkSyRSqT97pwkpMeIYdHAgUsZWOdUdZVUqa0w/edit?tab=t.0
    // int n;
    // scanf("%d", &n);
    // char str[n + 1];
    // scanf("%s", str);
    // int arr[26] = {0};

    // for (int i = 0; str[i] != '\0'; i++)
    // {
    //     arr[str[i] - 'a']++;
    // }

    // for (int i = 0; i < 26; i++)
    // {

    //     if (arr[i] > 0)
    //     {
    //         printf("%c", i + 'a');
    //     }
    // }

    // return 0;

    //* Practice Problem 6
    //* https://docs.google.com/document/d/1OJyO7DmkSyRSqT97pwkpMeIYdHAgUsZWOdUdZVUqa0w/edit?tab=t.0
    int n, count = 0;
    scanf("%d", &n);
    int arr[n + 5];
    int dig[n + 1];

    for (int i = 0; i <= n; i++)
    {
        arr[i] = 0;
    }

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &dig[i]);
    }

    for (int i = 0; i < n; i++)
    {
        arr[dig[i]]++;
    }

    for (int i = 0; i <= n; i++)
    {

        if (arr[i] > 0)
        {
            count++;
        }
    }

    printf("%d\n", count);

    return 0;
}