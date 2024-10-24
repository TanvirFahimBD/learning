#include <stdio.h>

int main()
{
    //* S. Sum of Consecutive Odd Numbers
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/S
    // int num;
    // scanf("%d", &num);

    // while (num)
    // {
    //     int a, b, start = 0, end = 0, sum = 0;
    //     scanf("%d%d", &a, &b);

    //     if (a >= b)
    //     {
    //         start = b + 1;
    //         end = a;
    //     }
    //     else
    //     {
    //         start = a + 1;
    //         end = b;
    //     }

    //     for (; start < end; start++)
    //     {
    //         if (start % 2 == 1)
    //         {
    //             sum += start;
    //         }
    //     }

    //     printf("%d\n", sum);
    //     num--;
    // }

    // return 0;

    //* G. Summation from 1 to N
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/G
    // int num;
    // long long int sum = 0;
    // scanf("%d", &num);

    // sum = (1LL * (num) * (num + 1)) / 2;
    // printf("%lld\n", sum);

    // return 0;

    //* G. Factorial
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/G
    // int t, num;
    // scanf("%d", &t);

    // while (t)
    // {
    //     scanf("%d", &num);
    //     long long int fact = 1;

    //     for (int i = 1; i <= num; i++)
    //     {
    //         fact *= i;
    //     }

    //     printf("%lld\n", fact);

    //     t--;
    // }

    // return 0;

    //* D. Fixed Password
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/D
    // int num;
    // while (1)
    // {
    //     scanf("%d", &num);
    //     if (num == 1999)
    //     {
    //         printf("Correct\n");
    //         break;
    //     }
    //     printf("Wrong\n");
    // }

    // return 0;
    // int num;
    // while (scanf("%d", &num) != EOF)
    // {

    //     if (num == 1999)
    //     {
    //         printf("Correct\n");
    //         break;
    //     }
    //     printf("Wrong\n");
    // }

    // return 0;

    //* W. Shape3
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/W
    // int num, spc, val;
    // scanf("%d", &num);

    // spc = num - 1;
    // val = 1;
    // for (int i = 0; i < (2 * num); i++)
    // {
    //     for (int j = 1; j <= spc; j++)
    //     {
    //         printf(" ");
    //     }

    //     for (int j = 1; j <= val; j++)
    //     {
    //         printf("*");
    //     }
    //     printf("\n");

    //     if (num - 1 == i)
    //     {
    //         for (int j = 1; j <= spc; j++)
    //         {
    //             printf(" ");
    //         }

    //         for (int j = 1; j <= val; j++)
    //         {
    //             printf("*");
    //         }
    //         printf("\n");
    //     }

    //     if (num - 1 <= i)
    //     {
    //         spc++;
    //         val -= 2;
    //     }
    //     else
    //     {
    //         spc--;
    //         val += 2;
    //     }
    // }

    // return 0;

    //* M. Lucky Numbers
    //*https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/M
    // int i, n, rem, flag = 0, found, value;
    // scanf("%d%d", &i, &n);

    // for (; i <= n; i++)
    // {
    //     rem = 0;
    //     found = 1;
    //     value = i;
    //     while (value > 0)
    //     {
    //         rem = value % 10;
    //         if (rem != 4 && rem != 7)
    //         {
    //             found = 0;
    //         }
    //         value /= 10;
    //     }

    //     if (found == 1)
    //     {
    //         printf("%d ", i);
    //         flag = 1;
    //     }
    // }

    // if (flag == 0)
    // {
    //     printf("%d\n", -1);
    // }

    // return 0;

    //* H. One Prime
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/H
    // int n, count = 0;
    // scanf("%d", &n);

    // for (int i = 2; i <= n; i++)
    // {
    //     if (n % i == 0)
    //     {
    //         count++;
    //     }
    // }

    // if (n == 1 || count == 1)
    // {
    //     printf("YES");
    // }
    // else if (count > 1)
    // {
    //     printf("NO");
    // }

    // return 0;

    //* J. Primes from 1 to n
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/J
    // int n, count;
    // scanf("%d", &n);

    // for (int i = 2; i <= n; i++)
    // {
    //     count = 0;
    //     for (int j = 2; j <= i; j++)
    //     {
    //         if (i % j == 0)
    //         {
    //             count++;
    //         }
    //     }

    //     if (count == 1)
    //     {
    //         printf("%d ", i);
    //     }
    // }

    // return 0;

    //* R. Sequence of Numbers and Sum
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/R
    int start, end, sum;

    while (scanf("%d%d", &start, &end) != EOF)
    {
        if (start <= 0 || end <= 0)
        {
            break;
        }

        if (start > end)
        {
            int temp = start;
            start = end;
            end = temp;
        }

        sum = 0;

        for (; start <= end; start++)
        {
            sum += start;
            printf("%d ", start);
        }

        printf("sum =%d\n", sum);
    }

    return 0;
}