#include <bits/stdc++.h>
using namespace std;
int main()
{
    //vector of string which is an arry
    // int  n;
    // cin >> n;
    // vector<string> v(n);
    // for (int i =0; i <n; i++)
    // {
    //     cin >> v[i];
    // }

    // for (int i =0; i <n; i++)
    // {
    //     cout << v[i]  << endl;
    // }
    

    int  n;
    cin >> n;
    cin.ignore();
    vector<string> v(n);
    for (int i =0; i <n; i++)
    {
        getline(cin, v[i]);
    }

    for (int i =0; i <n; i++)
    {
        cout << v[i]  << endl;
    }
    
    return 0;
}