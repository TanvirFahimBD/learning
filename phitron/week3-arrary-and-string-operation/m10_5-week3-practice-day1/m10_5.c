#include <stdio.h>
#include <string.h>

int main()
{
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

    //* G. Palindrome Array
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/G
    // int n, flag = 0, length = 0;
    // scanf("%d", &n);
    // int a[n];
    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // length = n / 2;
    // for (int i = n - 1, j = 0; i >= length; i--, j++)
    // {
    //     if (a[i] != a[j])
    //     {
    //         flag++;
    //     }
    // }

    // if (flag)
    // {
    //     printf("NO");
    // }
    // else
    // {
    //     printf("YES");
    // }
    // return 0;

    //* F. Way Too Long Words
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/F
    // int n, size = 0;
    // char str[101];
    // char result[10];
    // scanf("%d", &n);
    // getchar();

    // while (n)
    // {
    //     fgets(str, sizeof(str), stdin);
    //     size = strlen(str);
    //     if (str[size - 1] == '\n')
    //     {
    //         str[size - 1] = '\0';
    //         size--;
    //     }

    //     if (size > 10)
    //     {
    //         sprintf(result, "%c%d%c", str[0], size - 2, str[size - 1]);
    //         printf("%s\n", result);
    //     }
    //     else
    //     {
    //         printf("%s\n", str);
    //     }
    //     n--;
    // }
    // return 0;

    //* G. Conversion
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/G
    // char str[100001];
    // fgets(str, sizeof(str), stdin);
    // int size = strlen(str);

    // if (str[size - 1] == '\n')
    // {
    //     str[size - 1] = '\0';
    //     size--;
    // }

    // for (int i = 0; i < size; i++)
    // {
    //     if (str[i] == ',')
    //     {
    //         str[i] = ' ';
    //     }
    //     else if (str[i] <= 'Z' && str[i] >= 'A')
    //     {
    //         str[i] = str[i] + 32;
    //     }
    //     else if (str[i] >= 'a' && str[i] <= 'z')
    //     {
    //         str[i] = str[i] - 32;
    //     }

    //     putchar(str[i]);
    // }

    // return 0;

    //* I. Palindrome
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/I
    // int length = 0, flag = 0;
    // char str[100001];
    // fgets(str, sizeof(str), stdin);
    // int size = strlen(str);

    // if (str[size - 1] == '\n')
    // {
    //     str[size - 1] = '\0';
    //     size--;
    // }

    // length = size / 2;

    // for (int i = 0, j = size - 1; i <= length; i++, j--)
    // {
    //     if (str[i] != str[j])
    //     {
    //         flag++;
    //     }
    // }

    // if (flag)
    // {
    //     printf("NO");
    // }
    // else
    // {
    //     printf("YES");
    // }

    // return 0;

    //* D. Strings
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/D
    int size1 = 0, size2 = 0;
    char str1[11], str2[11];

    scanf("%s", str1);
    scanf("%s", str2);

    size1 = strlen(str1);
    size2 = strlen(str2);

    printf("%d %d\n", size1, size2);

    printf("%s%s\n", str1, str2);

    char tempc = str1[0];
    str1[0] = str2[0];
    str2[0] = tempc;
    printf("%s %s\n", str1, str2);

    return 0;
}