#include <stdio.h>

int main()
{
    // C.Next Alphabet
    // https: // codeforces.com/group/MWSDmqGsZm/contest/326175/problem/C
    // char c;
    // scanf("%c", &c);

    // if (c >= 97 && c < 122)
    // {
    //     printf("%c", c + 1);
    // }
    // else if (c == 122)
    // {
    //     printf("a");
    // }

    // ! D.Ali Baba and Puzzles
    // https : // codeforces.com/group/MWSDmqGsZm/contest/326175/problem/D
    // int num1, num2, num3, num4;
    // scanf("%d %d %d %d", &num1, &num2, &num3, &num4);

    // if (((num1 + num2 + num3) == num4) || ((num1 - num2 + num3) == num4) || ((num1 * num2 + num3) == num4))
    // {
    //     printf("YES");
    // }
    // else if (((num1 + num3 + num2) == num4) || ((num1 - num3 + num2) == num4) || ((num1 * num3 + num2) == num4))
    // {
    //     printf("YES");
    // }
    // else if (((num3 + num2 + num1) == num4) || ((num3 - num2 + num1) == num4) || ((num3 * num2 + num1) == num4))
    // {
    //     printf("YES");
    // }
    // else
    // {
    //     printf("NO");
    // }

    // K.Divisors
    // https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/K
    // int num1;
    // scanf("%d", &num1);
    // for (int i = 1; i <= num1; i++)
    // {
    //     if (num1 % i == 0)
    //     {
    //         printf("%d\n", i);
    //     }
    // }

    // B. Even Numbers
    // https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/B
    // int num1, totalEven = 0;
    // scanf("%d", &num1);

    // for (int i = 1; i <= num1; i++)
    // {
    //     if (i % 2 == 0)
    //     {
    //         totalEven++;
    //         printf("%d\n", i);
    //     }
    // }

    // if (totalEven == 0)
    // {
    //     printf("%d\n", -1);
    // }

    // I. Lucky Numbers
    // https://codeforces.com/group/MWSDmqGsZm/contest/326175/problem/I
    // int num, num1, num2;
    // scanf("%d", &num);
    // num1 = num % 10;
    // num2 = num / 10;
    // if (num1 % num2 == 0)
    // {
    //     printf("YES");
    // }
    // else if (num2 % num1 == 0)
    // {
    //     printf("YES");
    // }
    // else
    // {
    //     printf("NO");
    // }

    // pattern 1
    // int num;
    // scanf("%d", &num);
    // for (int i = 1; i <= num; i++)
    // {
    //     for (int j = 1; j <= i; j++)
    //     {
    //         printf("%d", j);
    //     }
    //     printf("\n");
    // }

    // pattern 2
    // int num;
    // scanf("%d", &num);
    // for (int i = num; i >= 1; i--)
    // {
    //     for (int j = i; j >= 1; j--)
    //     {
    //         printf("%d", j);
    //     }
    //     printf("\n");
    // }

    // pattern 3
    // int num;
    // scanf("%d", &num);
    // char c = 'A';

    // for (int i = 1; i <= num; i++)
    // {
    //     for (int j = 1; j <= i; j++)
    //     {
    //         printf("%c", c);
    //     }
    //     printf("\n");
    //     c++;
    // }

    // pattern 4
    int num;
    scanf("%d", &num);
    for (int i = 0; i < num; i++)
    {
        for (int j = 1; j <= num - i - 1; j++)
        {
            printf(" ");
        }

        for (int j = 1; j <= ((i * 2) + 1); j++)
        {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}