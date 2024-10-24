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
    // int start, end, sum;

    // while (scanf("%d%d", &start, &end) != EOF)
    // {
    //     if (start <= 0 || end <= 0)
    //     {
    //         break;
    //     }

    //     if (start > end)
    //     {
    //         int temp = start;
    //         start = end;
    //         end = temp;
    //     }

    //     sum = 0;

    //     for (; start <= end; start++)
    //     {
    //         sum += start;
    //         printf("%d ", start);
    //     }

    //     printf("sum =%d\n", sum);
    // }

    // return 0;

    //* J. Lucky Array
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/J
    // int n, min, count = 0;
    // scanf("%d", &n);
    // int a[n];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // min = a[0];
    // for (int i = 1; i < n; i++)
    // {
    //     if (min > a[i])
    //     {
    //         min = a[i];
    //     }
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     if (a[i] == min)
    //     {
    //         count++;
    //     }
    // }

    // if (count % 2 == 1)
    // {
    //     printf("Lucky\n");
    // }
    // else
    // {
    //     printf("Unlucky\n");
    // }

    // return 0;

    //* D. Positions in array
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/D
    // int n;
    // scanf("%d", &n);
    // int a[n];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     if (a[i] <= 10)
    //     {
    //         printf("A[%d] = %d\n", i, a[i]);
    //     }
    // }

    // return 0;

    //* M. Replace MinMax
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/M
    // int n, min, max;
    // scanf("%d", &n);
    // int a[n];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // min = a[0];
    // max = a[0];
    // for (int i = 0; i < n; i++)
    // {
    //     if (a[i] < min)
    //     {
    //         min = a[i];
    //     }

    //     if (a[i] > max)
    //     {
    //         max = a[i];
    //     }
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     if (a[i] == min)
    //     {
    //         a[i] = max;
    //     }
    //     else if (a[i] == max)
    //     {
    //         a[i] = min;
    //     }
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     printf("%d ", a[i]);
    // }

    // return 0;

    //* F. Reversing
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/F
    // int n;
    // scanf("%d", &n);
    // int a[n];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // for (int i = n - 1; i >= 0; i--)
    // {
    //     printf("%d ", a[i]);
    // }

    // return 0;

    //* R. Age in Days
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/R
    // int n, year = 0, month = 0, day = 0;
    // scanf("%d", &n);

    // year = n / 365;
    // printf("%d years\n", year);

    // month = (n % 365) / 30;
    // printf("%d months\n", month);

    // day = (n % 365) % 30;
    // printf("%d days\n", day);

    // return 0;

    //* 3.5 Extra Problem Set For Practice
    //* https://docs.google.com/document/d/1wyXv1Iqx1W21n2HAoOM1yC5VMEOewKveA8O_Q1CliSo/edit?tab=t.0
    //* Frequency Arrays
    // int n, m;
    // scanf("%d%d", &n, &m);
    // int a[n], a2[m + 1];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // for (int i = 1; i <= m; i++)
    // {
    //     a2[i] = 0;
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     int j = a[i];
    //     a2[j] = a2[j] + 1;
    // }

    // for (int i = 1; i <= m; i++)
    // {
    //     printf("%d\n", a2[i]);
    // }

    // return 0;

    //* Sum Digits
    int n, rem = 0, sum = 0;
    scanf("%d\n", &n);

    while (n > 0)
    {
        rem = n % 10;
        sum += rem;
        n /= 10;
    }
    printf("%d\n", sum);
    return 0;
}