#include <stdio.h>
#include <string.h>

int main()
{
    //* C. Compare
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/C
    // char str1[21];
    // char str2[21];

    // scanf("%s%s", str1, str2);

    // int res = strcmp(str1, str2);

    // if (res < 0)
    // {
    //     printf("%s", str1);
    // }
    // else
    // {
    //     printf("%s", str2);
    // }

    // return 0;

    //* E. Count
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/E
    // char str[1000001];
    // int sum = 0, length = 0;
    // scanf("%s", str);

    // length = strlen(str);

    // for (int i = 0; i < length; i++)
    // {
    //     int digit = str[i] - '0';
    //     sum += digit;
    // }

    // printf("%d\n", sum);

    // return 0;

    //* K. I Love strings
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/K
    // int n;
    // scanf("%d", &n);

    // while (n)
    // {
    //     char str1[51];
    //     char str2[51];
    //     char str3[110] = {0};
    //     scanf("%s%s", str1, str2);
    //     int strlen1 = strlen(str1);
    //     int strlen2 = strlen(str2);

    //     str1[strlen1] = '\0';
    //     str2[strlen2] = '\0';

    //     int length = 0, total_length = strlen1 + strlen2;

    //     if (strlen1 >= strlen2)
    //     {
    //         length = strlen1;
    //     }
    //     else
    //     {
    //         length = strlen2;
    //     }

    //     int pos = 0, flag1 = 0, flag2 = 0;

    //     for (int i = 0; i < length; i++)
    //     {
    //         if (str1[i] != '\0' && flag1 == 0)
    //         {
    //             str3[pos] = str1[i];
    //             pos++;
    //         }
    //         else
    //         {
    //             flag1++;
    //         }

    //         if (str2[i] != '\0' && flag2 == 0)
    //         {
    //             str3[pos] = str2[i];
    //             pos++;
    //         }
    //         else
    //         {
    //             flag2++;
    //         }
    //     }

    //     str3[total_length] = '\0';
    //     printf("%s\n", str3);
    //     n--;
    // }

    // return 0;

    //* D. Strings
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/D
    // char str1[11];
    // char str2[11];
    // scanf("%s%s", str1, str2);
    // int strlen1 = strlen(str1);
    // int strlen2 = strlen(str2);

    // str1[strlen1] = '\0';
    // str2[strlen2] = '\0';

    // printf("%d %d\n", strlen1, strlen2);
    // printf("%s%s\n", str1, str2);

    // char temp = str1[0];
    // str1[0] = str2[0];
    // str2[0] = temp;

    // printf("%s %s\n", str1, str2);

    // return 0;

    //* M. Subsequence String
    //* https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/M
    char str1[10001];
    char target[6] = "hello";
    scanf("%s", str1);
    int strlen1 = strlen(str1);
    str1[strlen1] = '\0';

    int count = 0;
    for (int i = 0, j = 0; i < strlen1; i++)
    {
        if (str1[i] == target[j])
        {
            count++;
            j++;
        }
    }

    if (count == 5)
    {
        printf("YES");
    }
    else
    {
        printf("NO");
    }

    return 0;
}