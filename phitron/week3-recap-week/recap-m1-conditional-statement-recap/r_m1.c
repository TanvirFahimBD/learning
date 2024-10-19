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
    int a, b;
    char ch;
    scanf("%d", &a);
    scanf(" %c", &ch);
    scanf("%d", &b);

    if (ch == '>' && a > b)
    {
        printf("Right");
    }
    else if (ch == '<' && a < b)
    {
        printf("Right");
    }
    else if (ch == '=' && a == b)
    {
        printf("Right");
    }
    else
    {
        printf("Wrong");
    }

    return 0;
}