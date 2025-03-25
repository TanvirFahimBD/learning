#include <bits/stdc++.h>
using namespace std;
int main()
{
    string s;
    cin >> s;
    // cout << s[0] << endl;
    // cout << s.at(0) << endl;
    cout << s.front() << endl;
    cout << s.back() << endl;
    cout << s[s.size() - 1] << endl;
    return 0;
}