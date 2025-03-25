#include <bits/stdc++.h>
using namespace std;

int main()
{
    list<int> l = {10, 20, 30, 40, 20, 60, 20};
    //remove
    // l.remove(20);

    //sort
    // l.sort(greater<int>());
    
    //unique (need to sort first otherwise only side by side)
    l.sort(greater<int>());
    l.unique();
    for (int val : l)
    {
        cout << val << endl;
    }
    

    return 0;
}