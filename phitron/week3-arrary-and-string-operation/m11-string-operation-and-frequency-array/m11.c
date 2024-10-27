#include <stdio.h>
#include <string.h>

int main()
{
    //* 11.2-Lenght of a String
    // int length = 0;
    // char str[20] = "amar life amar";

    // // for (int i = 0; str[i] != '\0'; i++)
    // // {
    // //     length++;
    // // }

    // length = strlen(str);

    // printf("%d\n", length);

    // return 0;

    //* 11.3-How to copy a String
    // char a[10];
    // char b[10] = "abcdef";

    // // int length = strlen(b);
    // // for (int i = 0; b[i] != '\0'; i++)
    // // {
    // //     a[i] = b[i];
    // // }
    // // a[length] = '\0';
    // // printf("%s %s\n", a, b);

    // strcpy(a, b);
    // printf("%s %s\n", a, b);

    //* 11.4-String Concatation
    // char a[20] = "hello";
    // char b[20] = "world";

    // // int len_a = strlen(a);
    // // int len_b = strlen(b);
    // // int length = len_a + len_b;
    // // for (int i = len_a, j = 0; i < length; i++, j++)
    // // {
    // //     a[i] = b[j];
    // // }
    // // a[length] = '\0';
    // // printf("%s %s\n", a, b);

    // strcat(b, a);
    // printf("%s %s\n", a, b);
    // return 0;

    //* 11.6-String Compare
    // char a[20] = "air";
    // char b[20] = "aadam";
    // int res = strcmp(b, a);
    // printf("%d\n", res);

    // return 0;

    //* 11.7-String Reverse
    // char a[20] = "hello world";
    // char b[20];
    // strcpy(b, a);
    // int length = strlen(a);

    // for (int i = 0, j = length - 1; i <= j; i++, j--)
    // {
    //     char temp = a[i];
    //     a[i] = a[j];
    //     a[j] = temp;
    // }

    // printf("%s | %s\n", a, b);

    // // no build-in function for string reverse

    // return 0;
    // char str[] = "hello\0world";
    // printf("%d", strlen(str));
    // return 0;
    // char str[] = "hi, we are learning string! ";
    // printf("%d", strlen(str));
    // return 0;
    // char a[] = "hello";
    // char b[] = "world";
    // strcpy(b, a);
    // printf("%s %s", a, b);
    // return 0;
    // char a[20] = "aaa";
    // char b[20] = "abc";
    // int res = strcmp(b, a);
    // printf("%d", res);
    // return 0;
    char a[] = "hello";
    char b[] = "world";
    char c[] = "hello world";
    strcat(b, a);
    strcpy(c, b);
    printf("%s", c);
    return 0;
}