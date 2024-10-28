#include <stdio.h>
#include <string.h>
#include <math.h>

int main()
{
    //* 14-3. Declaration, Initialization & access
    // int arr[3][5] = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};

    // for (int i = 0; i < 3; i++)
    // {
    //     for (int j = 0; j < 5; j++)
    //     {
    //         printf("i = %d, j = %d, Address = %d\n", i, j, &arr[i][j]);
    //     }
    //     printf("\n");
    // }

    // return 0;

    //* 14-4 Input Output of 2D Matrix
    // int n, m;
    // scanf("%d %d", &n, &m);
    // int arr[n + 5][m + 5];

    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         scanf("%d", &arr[i][j]);
    //     }
    // }

    // arr[1][1] = 100;

    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         printf("i = %d, j = %d, Value = %d\n", i, j, arr[i][j]);
    //     }
    //     printf("\n");
    // }

    // return 0;

    //* 14-6 Checking a Scaler Matrix
    // int n;
    // scanf("%d", &n);
    // int m[n][n];

    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < n; j++)
    //     {
    //         scanf("%d", &m[i][j]);
    //     }
    // }

    // int element = m[0][0];
    // int flag = 1;

    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < n; j++)
    //     {
    //         if (i == j)
    //         {
    //             if (m[i][j] != element)
    //             {
    //                 flag = 0;
    //                 break;
    //             }
    //         }
    //         else
    //         {
    //             if (m[i][j] != 0)
    //             {
    //                 flag = 0;
    //                 break;
    //             }
    //         }
    //         if (flag == 0)
    //         {
    //             break;
    //         }
    //     }
    // }

    // if (flag == 1)
    // {
    //     printf("Scaler");
    // }
    // else
    // {
    //     printf("Not Scaler");
    // }
    // return 0;

    //* T. Matrix
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/T
    int n;
    scanf("%d", &n);
    int m[n][n];

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &m[i][j]);
        }
    }

    int element = m[0][0];
    int pri_sum = 0, sec_sum = 0, diff = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (i == j)
            {
                pri_sum += m[i][j];
            }

            if (i + j == (n - 1))
            {
                sec_sum += m[i][j];
            }
        }
    }

    diff = abs(pri_sum - sec_sum);

    printf("%d\n", diff);
    return 0;
}