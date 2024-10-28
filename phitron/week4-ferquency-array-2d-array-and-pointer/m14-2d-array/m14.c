#include <stdio.h>
#include <string.h>

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
    int n, m;
    scanf("%d %d", &n, &m);
    int arr[n + 5][m + 5];

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }

    arr[1][1] = 100;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            printf("i = %d, j = %d, Value = %d\n", i, j, arr[i][j]);
        }
        printf("\n");
    }

    return 0;
}