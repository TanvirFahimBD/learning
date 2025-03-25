#include <bits/stdc++.h>
using namespace std;

// https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/K
// K. I Love strings
int main()
{
    int tn;
    cin >> tn;
    while (tn--)
    {
        string s1, s2, newStr;
        cin >> s1 >> s2;

        for (int i = 0; i < s1.size(); i++)
        {
            newStr += s1[i];
            if (i < s2.size())
            {
                newStr += s2[i];
            }

            if (i == (s1.size() - 1) && (s1.size() < s2.size()))
            {
                for (int j = i + 1; j < s2.size(); j++)
                {
                    newStr += s2[j];
                }
            }
        }

        cout << newStr << endl;
    }
    return 0;
}