#include <string.h>
#include <stdio.h>
#include <math.h>

//* N. Shift Zeros
//* https://codeforces.com/group/MWSDmqGsZm/contest/223205/problem/N

// int a2[1000];
// void shiftZero(int *x, int t)
// {
//     for (int i = 0, j = 0; i < t; i++)
//     {
//         if (x[i] != 0)
//         {
//             a2[j] = x[i];
//             j++;
//         }
//     }
// }

// int main()
// {
//     int n;
//     scanf("%d", &n);

//     int a[n];
//     for (int i = 0; i < n; i++)
//     {
//         scanf("%d", &a[i]);
//     }

//     shiftZero(a, n);

//     for (int i = 0; i < n; i++)
//     {
//         printf("%d ", a2[i]);
//     }

//     return 0;
// }

//* G. Max and MIN
//* https://codeforces.com/group/MWSDmqGsZm/contest/223205/problem/G

// int minMax[2];

// int findMax(int a, int b)
// {
//     if (a > b)
//     {
//         return a;
//     }
//     else
//     {
//         return b;
//     }
// }

// int findMin(int a, int b)
// {
//     if (a < b)
//     {
//         return a;
//     }
//     else
//     {
//         return b;
//     }
// }

// void findMinMax(int *x, int t)
// {
//     int min = x[0];
//     int max = x[0];
//     for (int i = 0; i < t; i++)
//     {
//         min = findMin(min, x[i]);
//         max = findMax(max, x[i]);
//     }
//     minMax[0] = min;
//     minMax[1] = max;
// }

// int main()
// {
//     int n;
//     scanf("%d", &n);

//     int a[n];
//     for (int i = 0; i < n; i++)
//     {
//         scanf("%d", &a[i]);
//     }

//     findMinMax(a, n);

//     printf("%d %d", minMax[0], minMax[1]);

//     return 0;
// }

//* K. Max Number
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/K

// int findMax(int *x, int i, int max, int t)
// {
//     if (i > t)
//     {
//         return max;
//     }

//     if (x[i] > max)
//     {
//         max = x[i];
//     }

//     int res = findMax(x, i + 1, max, t);
//     return res;
// }

// int main()
// {
//     int n;
//     scanf("%d", &n);
//     int a[n];
//     for (int i = 0; i < n; i++)
//     {
//         scanf("%d", &a[i]);
//     }

//     int res = findMax(a, 0, a[0], n - 1);
//     printf("%d\n", res);
//     return 0;
// }

//* I. Count Vowels
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/I

// char str[201];

// int findVowel(char c)
// {
//     if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
//     {
//         return 1;
//     }
//     else
//     {
//         return 0;
//     }
// }

// int countVowel(char x[], int i, int n)
// {
//     if (i > n)
//     {
//         return 0;
//     }

//     int sum = findVowel(x[i]) + countVowel(x, i + 1, n);
//     return sum;
// }

// int main()
// {
//     fgets(str, sizeof(str), stdin);
//     if (str[strlen(str) - 1] == '\n')
//     {
//         str[strlen(str) - 1] = '\0';
//     }

//     int res = countVowel(str, 0, strlen(str) - 1);
//     printf("%d\n", res);
//     return 0;
// }

//* P. Log2
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/P

int logVal(long long int n)
{
    if (n / 2 == 0)
    {
        return 0;
    }

    if (n / 2 != 0)
    {
        n = n / 2;
    }

    int finalRes = 1 + logVal(n);
    return finalRes;
}

int main()
{
    long long int n;
    scanf("%lld", &n);
    int res = logVal(n);
    printf("%d\n", res);
    return 0;
}