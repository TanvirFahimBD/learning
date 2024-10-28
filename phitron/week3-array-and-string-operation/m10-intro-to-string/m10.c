#include <stdio.h>

int main()
{
    //* 10-4. String Input and Output
    char str[16];
    // scanf("%s", str);
    // scanf("%[^\n]c", str);
    fgets(str, sizeof(str), stdin);
    // printf("%s ", str);
    fputs(str, stdout);
    return 0;

    //* 10-5. Escape Sequence
    // // char str[] = "bangladesh is a \"beautiful\" country ";
    // // char str[] = "bangladesh \nis a beautiful country";
    // // char str[] = "bangladesh \tis a beautiful country";
    // // char str[] = "bangladesh is a beau\0tiful country";
    // // char str[] = "bangladesh is a beau\\tiful country";
    // char str[] = "bangladesh's a beautiful country";
    // fputs(str, stdout);
    // return 0;

    //* 10-6. Converting String to Integer Number

    // int n;
    // scanf("%d", &n);
    // char str[n + 1];
    // scanf("%s", str);

    // int sum = 0;
    // for (int i = 0; i < n; i++)
    // {
    //     int digit = str[i] - '0';
    //     sum = sum * 10 + digit;
    // }

    // printf("%d", sum);

    // return 0;

    // char str[20] = "HelloW\0rld";
    // printf("%s", str);
    // return 0;

    // char str[20];
    // scanf("%s", &str);
    // printf("%s", str);
    // return 0;

    // char str[20];
    // scanf("%c", &str);
    // printf("%s", str);
    // return 0;
}