 = 0; i < size - 1; i++)
    {
        if (str[i] == ',')
        {
            str[i] = ' ';
        }
        else if (str[i] <= 'Z' && str[i] >= 'A')
        {
            str[i] = str[i] + 32;
        }
        else if (str[i] >= 'a' && str[i] <= 'z')
        {
            str[i] = str[i] - 32;
        }

        printf("%c", str[i]);
    }