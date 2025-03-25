#include <bits/stdc++.h>
using namespace std;
int main()
{
    // string s = "Hello world in 2024";
    // cout << s.size() << endl;
    // cout << s.max_size() << endl;
    // cout << s.capacity() << endl;
    // s.clear();
    // cout << s << endl;
    // cout << s.size() << endl;

    // if (s.empty() == true)
    // {
    //     cout << "Empty" << endl;
    // }
    // else
    // {
    //     cout << "Not Empty" << endl;
    // }

    string s = "Hello world";
    s.resize(4);
    s.resize(15, 'x');
    cout << s << endl;

    return 0;
}