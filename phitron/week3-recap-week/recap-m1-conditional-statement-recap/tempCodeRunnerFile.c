0] > arr[1])
    {
        if (arr[0] > arr[2])
        {
            if (arr[2] > arr[1])
            {
                arr2[0] = arr[1];
                arr2[1] = arr[2];
                arr2[2] = arr[0];
            }
            else
            {

                arr2[0] = arr[2];
                arr2[1] = arr[1];
                arr2[2] = arr[0];
            }
        }
        else
        {
            if (arr[1] > arr[0])
            {
                arr2[0] = arr[0];
                arr2[1] = arr[1];
                arr2[2] = arr[2];
            }
            else
            {

                arr2[0] = arr[1];
                arr2[1] = arr[0];
                arr2[2] = arr[2];
            }
        }
    }
    else if (arr[1] > arr[0])
    {
        if (arr[1] > arr[2])
        {
            if (arr[2] > arr[0])
            {
                arr2[0] = arr[0];
                arr2[1] = arr[2];
                arr2[2] = arr[1];
            }
            else
            {

                arr2[0] = arr[2];
                arr2[1] = arr[0];
                arr2[2] = arr[1];
            }
        }
        else
        {
            if (arr[1] > arr[0])
            {
                arr2[0] = arr[0];
                arr2[1] = arr[1];
                arr2[2] = arr[2];
            }
            else
            {
                arr2[0] = arr[1];
                arr2[1] = arr[0];
                arr2[2] = arr[2];
            }
        }
    }

    for (int i = 0; i < 3; i++)
    {
        printf("%d\n", arr2[i]);
    }

    printf(