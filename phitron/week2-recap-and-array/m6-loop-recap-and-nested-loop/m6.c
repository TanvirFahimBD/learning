#include <stdio.h>

int main()
{
    // * 6.2 Loop Recap
    // int cnt = 0;

    // for (int i = 0; i < 3; i++)
    // {
    //     for (int j = 0; j < 10; j++)
    //     {
    //         for (int k = 0; k < 5; k++)
    //         {
    //             cnt++;
    //         }
    //     }
    // }
    // printf("%d\n", cnt);

    // * 6.2 Loop Recap
    // int num;
    // scanf("%d", &num);

    // int evnCnt = 0, odCnt = 0, posCnt = 0, negCnt = 0;

    // for (int i = 1; i <= num; i++)
    // {
    //     int digit;
    //     scanf("%d", &digit);
    //     if (digit % 2 == 0)
    //     {
    //         evnCnt++;
    //     }
    //     else if (digit % 2 != 0)
    //     {
    //         odCnt++;
    //     }

    //     if (digit > 0)
    //     {
    //         posCnt++;
    //     }
    //     else if (digit < 0)
    //     {
    //         negCnt++;
    //     }
    // }

    // printf("Even: %d\n", evnCnt);
    // printf("Odd: %d\n", odCnt);
    // printf("Positive: %d\n", posCnt);
    // printf("Negative: %d\n", negCnt);

    // * 6.5- Break Statement
    // for (int i = 1; i <= 10; i++)
    // {
    //     printf("%d\n", i);

    //     printf("Line 1\n");
    //     printf("Line 2\n");

    //     if (i == 5)
    //     {
    //         break;
    //     }

    //     printf("Line 3\n");
    //     printf("Line 4\n");
    // }

    // * 6.6 - Continue Statement
    // for (int i = 1; i <= 10; i++)
    // {
    //     printf("%d\n", i);

    //     printf("Line 1\n");
    //     printf("Line 2\n");

    //     if (i == 5)
    //     {
    //         continue;
    //     }

    //     printf("Line 3\n");
    //     printf("Line 4\n");
    // }

    // * 6.7 - Digits
    int t;
    scanf("%d", &t);
    for (int i = 0; i < t; i++)
    {
        int n;
        scanf("%d", &n);

        if (n == 0)
        {
            printf("0");
        }

        while (n > 0)
        {
            int digit = n % 10;
            printf("%d ", digit);

            n /= 10;
        }

        printf("\n");
    }

    return 0;
}