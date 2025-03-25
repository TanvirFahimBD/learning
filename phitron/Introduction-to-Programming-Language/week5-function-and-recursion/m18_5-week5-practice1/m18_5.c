#include <stdio.h>
#include <string.h>
#include <math.h>

//* A. Add
//* https://codeforces.com/group/MWSDmqGsZm/contest/223205/problem/A
// long long int sum = 0;

// long long int fun(int a, int b)
// {
//     sum = a + b;
//     return sum;
// }

// int main()
// {
//     int a, b;
//     scanf("%d%d", &a, &b);
//     fun(a, b);
//     printf("%lld\n", sum);

//     return 0;
// }

//* E. Swap
//* https://codeforces.com/group/MWSDmqGsZm/contest/223205/problem/E

// void fun(int *a, int *b)
// {
//     int temp = *a;
//     *a = *b;
//     *b = temp;
// }

// int main()
// {
//     int a, b;
//     scanf("%d%d", &a, &b);
//     fun(&a, &b);

//     printf("%d %d\n", a, b);

//     return 0;
// }

//* A. Print Recursion
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/A

// void fun(int n)
// {
//     if (n == 0)
//     {
//         return;
//     }

//     fun(n - 1);
//     printf("I love Recursion\n");
// }

// int main()
// {
//     int n;
//     scanf("%d", &n);
//     fun(n);

//     return 0;
// }

//* B. Print from 1 to N
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/B

// void fun(int i, int n)
// {
//     if (i > n)
//     {
//         return;
//     }

//     printf("%d\n", i);
//     fun(i + 1, n);
// }

// int main()
// {
//     int n;
//     scanf("%d", &n);
//     fun(1, n);

//     return 0;
// }

//* C. Print from N to 1
//* https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/C

void fun(int i, int n)
{
    if (i > n)
    {
        return;
    }

    fun(i + 1, n);
    if (i == 1)
        printf("%d", i);
    else
        printf("%d ", i);
}

int main()
{
    int n;
    scanf("%d", &n);
    fun(1, n);

    return 0;
}