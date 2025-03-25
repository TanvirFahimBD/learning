// https : // docs.google.com/document/d/12efBIhlH8-L1pAXMmYqpPLnYVl2ZP7L4/edit
#include <bits/stdc++.h>
using namespace std;

// https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/U
// U. New Words
// int main()
// {
//     string s;
//     cin >> s;

//     int eC = 0, gC = 0, yC = 0, pC = 0, tC = 0;
//     for (int i = 0; i < s.size(); i++)
//     {
//         if (s[i] == 'e' || s[i] == 'E')
//         {
//             eC++;
//         }
//         else if (s[i] == 'g' || s[i] == 'G')
//         {
//             gC++;
//         }
//         else if (s[i] == 'y' || s[i] == 'Y')
//         {
//             yC++;
//         }
//         else if (s[i] == 'p' || s[i] == 'P')
//         {
//             pC++;
//         }
//         else if (s[i] == 't' || s[i] == 'T')
//         {
//             tC++;
//         }
//     }

//     if ((eC <= gC) && (eC <= yC) && (eC <= pC) && (eC <= tC))
//     {
//         cout << eC << endl;
//     }
//     else if ((gC <= eC) && (gC <= yC) && (gC <= pC) && (gC <= tC))
//     {
//         cout << gC << endl;
//     }
//     else if ((yC <= eC) && (yC <= gC) && (yC <= pC) && (yC <= tC))
//     {
//         cout << yC << endl;
//     }
//     else if ((pC <= eC) && (pC <= gC) && (pC <= yC) && (pC <= tC))
//     {
//         cout << pC << endl;
//     }
//     else if ((tC <= eC) && (tC <= gC) && (tC <= yC) && (tC <= pC))
//     {
//         cout << tC << endl;
//     }

//     return 0;
// }

// https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/I
// I. Palindrome
// int main()
// {
//     string s;
//     cin >> s;
//     int strSize = s.size() / 2;
//     bool palFlag = true;

//     for (int i = 0, j = s.size() - 1; i < strSize; i++, j--)
//     {
//         if (s[i] != s[j])
//         {
//             palFlag = false;
//         }
//     }

//     if (palFlag)
//     {
//         cout << "YES" << endl;
//     }
//     else
//     {
//         cout << "NO" << endl;
//     }

//     return 0;
// }

// https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/V
// V. Replace Word
// int main()
// {
//     string s;
//     cin >> s;
//     string newStr = "";

//     for (int i = 0; i < s.size(); i++)
//     {
//         // BRITISHEGYPTGHANA

//         if ((s[i] == 'E') && (s[i + 1] == 'G') && (s[i + 2] == 'Y') && (s[i + 3] == 'P') && (s[i + 4] == 'T'))
//         {
//             newStr += ' ';
//             i += 4;
//         }
//         else
//         {
//             newStr += s[i];
//         }
//     }

//     cout << newStr << endl;

//     return 0;
// }

// https://codeforces.com/contest/1676/problem/A
// A. Lucky?
// int main()
// {
//     int t;
//     cin >> t;
//     while (t--)
//     {
//         string s;
//         cin >> s;
//         int sum1 = 0, sum2 = 0;

//         for (int i = 0; i < s.size(); i++)
//         {
//             if (i >= 0 && i <= 2)
//             {
//                 sum1 += s[i] - '0';
//             }
//             else if (i >= 3 && i <= 5)
//             {
//                 sum2 += s[i] - '0';
//             }
//         }

//         if (sum1 == sum2)
//         {
//             cout << "YES" << endl;
//         }
//         else
//         {
//             cout << "NO" << endl;
//         }
//     }

//     return 0;
// }

// https://codeforces.com/contest/1703/problem/B
// B. ICPC Balloons
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int num, n = 0, sum = 0;
        cin >> num;
        string s;
        cin >> s;

        int ar[27];
        for (int i = 0; i < 26; i++)
        {
            ar[i] = 0;
        }

        for (int i = 0; i < num; i++)
        {
            n = s[i] - 'A';
            if (ar[n] == 0)
            {
                ar[n] += 2;
            }
            else
            {
                ar[n] += 1;
            }
        }

        for (int i = 0; i < 26; i++)
        {
            sum += ar[i];
        }

        cout << sum << endl;
    }
    return 0;
}