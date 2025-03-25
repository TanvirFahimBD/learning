#include <bits/stdc++.h>
using namespace std;
int main()
{
    //size given
    // int  n;
    // cin >> n;
    // vector<int> v(n);
    // for (int i =0; i <n; i++)
    // {
    //     cin >> v[i];
    // }

    // for (int i =0; i <n; i++)
    // {
    //     cout << v[i]  << " ";
    // }

    // size not given 
    int  n;
    cin >> n;
    vector<int> v;
    for (int i =0; i <n; i++)
    {
        int x;
        cin >> x;
        v.push_back(x);
    }

    for (int i =0; i <n; i++)
    {
        cout << v[i]  << " ";
    }
    
    
    return 0;
}