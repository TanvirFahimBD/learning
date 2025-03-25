#include <stdio.h>
#include <string.h>
#include <math.h>

//* 19-2. Call By Value, Call by Reference
// void fun(int x, int *y)
// {
//     x *= 10;
//     *y *= 10;
//     printf("%d %d\n", x, *y);
// }

// int main()
// {
//     int a, b;
//     scanf("%d%d", &a, &b);
//     fun(a, &b);
//     printf("%d %d\n", a, b);

//     return 0;
// }

//* 19-3. Passing Array and String in Function
// void makeFirstToUpper(char x[])
// {
//     x[0] = toupper(x[0]);
//     printf("%s", x);
// }

// int main()
// {
//     char a[20] = "programming";
//     makeFirstToUpper(a);

//     return 0;
// }

//* 19-4. Using Pointer variable as Parameter for Array
// void fun(int *x, int n)
// {
//     for (int i = 0; i < 5; i++)
//     {
//         printf("%d ", *(x + i));
//     }

//     // x[0] = -100;
// }

// int main()
// {
//     int a[5] = {1, 2, 3, 4, 5};
//     fun(a, 5);
//     printf("\n");
//     for (int i = 0; i < 5; i++)
//     {
//         printf("%d ", a[i]);
//     }
//     return 0;
// }

// void fun(char *x, int n)
// {
//     printf("%s\n", x);

//     x[0] = 'c';
// }

// int main()
// {
//     char a[5] = "air";

//     fun(a, 5);
//     printf("%s\n", a);
//     return 0;
// }

// void fun(char *x, char *y)
// {

//     y[0] = 'b';
//     x = strcpy(x, y);
// }

// int main()
// {
//     char a[10] = "air";
//     char b[10] = "apple";

//     fun(a, b);
//     printf("%s\n", a);
//     return 0;
// }

//* J.Factorial
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/J
// long long factorial(int n)
// {
//     if (n == 0)
//     {
//         return 1;
//     }
//     return n * factorial(n - 1);
// }

// int main()
// {
//     int n;
//     scanf("%d", &n);

//     printf("%lld\n", factorial(n));
//     return 0;
// }

//* D. Print Digits using Recursion
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/D
// void printDigits(int n)
// {
//     if (n == 0)
//         return;
//     int digit = n % 10;
//     n = n / 10;
//     printDigits(n);
//     printf("%d ", digit);
// }

// int main()
// {
//     int t;
//     scanf("%d", &t);

//     for (int i = 0; i < t; i++)
//     {
//         int n;
//         scanf("%d", &n);

//         if (n == 0)
//         {
//             printf("0");
//         }
//         else
//         {
//             printDigits(n);
//         }
//         printf("\n");
//     }

//     return 0;
// }

//* R. Palindrome Array
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/R

// int isPalin(int *a, int i, int j)
// {
//     if (i > j)
//         return 1;
//     return a[i] == a[j] && isPalin(a, i + 1, j - 1);
// }

// int main()
// {
//     int t;
//     scanf("%d", &t);

//     int a[t];

//     for (int i = 0; i < t; i++)
//     {
//         scanf("%d", &a[i]);
//     }

//     int res = isPalin(a, 0, t - 1);
//     if (res)
//     {
//         printf("YES\n");
//     }
//     else
//     {
//         printf("NO\n");
//     }

//     return 0;
// }

// int isNotPalin(int *a, int i, int j)
// {
//     if (i > j)
//         return 0;
//     return a[i] != a[j] || isNotPalin(a, i + 1, j - 1);
// }

// int main()
// {
//     int t;
//     scanf("%d", &t);

//     int a[t];

//     for (int i = 0; i < t; i++)
//     {
//         scanf("%d", &a[i]);
//     }

//     int res = isNotPalin(a, 0, t - 1);
//     if (res)
//     {
//         printf("NO\n");
//     }
//     else
//     {
//         printf("YES\n");
//     }

//     return 0;
// }

// void m(int *p)
// {
//     int i = 0;
//     for (i = 0; i < 5; i++)
//         printf("%d ", p[i]);
// }
// int main()
// {
//     int a[5] = {6, 5, 3};
//     m(a);
// }

// int main()
// {
//     int ary[4] = {1, 2, 3, 4};
//     printf("%d\n", *ary);
// }

int main()
{
    int ary[4] = {1, 2, 3, 4};
    int *p;
    p = ary + 3;
    *p = 5;
    printf("%d\n", ary[3]);
}