#include <stdio.h>

int main()
{
    //* N. Char
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/N
    // char c;
    // scanf("%c", &c);

    // if (c >= 'A' && c >= 'Z')
    // {
    //     printf("%c", c - 32);
    // }
    // else if (c <= 'a' && c <= 'z')
    // {
    //     printf("%c", c + 32);
    // }

    // return 0;

    //* V. Comparison
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/V
    // int a, b;
    // char ch;
    // scanf("%d", &a);
    // scanf(" %c", &ch);
    // scanf("%d", &b);

    // if (ch == '>' && a > b)
    // {
    //     printf("Right");
    // }
    // else if (ch == '<' && a < b)
    // {
    //     printf("Right");
    // }
    // else if (ch == '=' && a == b)
    // {
    //     printf("Right");
    // }
    // else
    // {
    //     printf("Wrong");
    // }

    // return 0;

    //* W. Mathematical Expression
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/W
    // int a, b, c;
    // char ch, ch2;
    // scanf("%d", &a);
    // scanf(" %c", &ch);
    // scanf("%d", &b);
    // scanf(" %c", &ch2);
    // scanf("%d", &c);

    // if (ch == '+')
    // {
    //     if (a + b == c)
    //     {
    //         printf("Yes");
    //     }
    //     else
    //     {
    //         printf("%d\n", a + b);
    //     }
    // }
    // if (ch == '-')
    // {
    //     if (a - b == c)
    //     {
    //         printf("Yes");
    //     }
    //     else
    //     {
    //         printf("%d\n", a - b);
    //     }
    // }
    // if (ch == '*')
    // {
    //     if (a * b == c)
    //     {
    //         printf("Yes");
    //     }
    //     else
    //     {
    //         printf("%d\n", a * b);
    //     }
    // }

    // return 0;

    //* B. Memo and Momo
    //* https://codeforces.com/group/MWSDmqGsZm/contest/326175/problem/B
    // long long int a, b, div;
    // scanf("%lld %lld %lld", &a, &b, &div);

    // if (a % div == 0 && b % div == 0)
    // {
    //     printf("Both");
    // }
    // else if (a % div != 0 && b % div != 0)
    // {
    //     printf("No One");
    // }
    // else if (a % div == 0 && b % div != 0)
    // {
    //     printf("Memo");
    // }
    // else if (a % div != 0 && b % div == 0)
    // {
    //     printf("Momo");
    // }

    // return 0;

    //* T. Sort Numbers
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/T
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);

    if (a >= b && a >= c)
    {
        if (b >= c)
        {
            printf("%d\n%d\n%d\n", c, b, a);
        }
        else
        {
            printf("%d\n%d\n%d\n", b, c, a);
        }
    }
    else if (b >= a && b >= c)
    {
        if (a >= c)
        {
            printf("%d\n%d\n%d\n", c, a, b);
        }
        else
        {
            printf("%d\n%d\n%d\n", a, c, b);
        }
    }
    else
    {
        if (a >= b)
        {
            printf("%d\n%d\n%d\n", b, a, c);
        }
        else
        {
            printf("%d\n%d\n%d\n", a, b, c);
        }
    }

    printf("\n%d\n%d\n%d\n", a, b, c);

    return 0;
}