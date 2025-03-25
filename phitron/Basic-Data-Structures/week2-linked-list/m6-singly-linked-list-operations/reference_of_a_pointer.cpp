#include <bits/stdc++.h>
using namespace std;

// void fun(int* p){
//     cout << "fun " << &p << endl;
//     cout << "fun " << *p << endl;
// }

// void fun(int* p){
//     // *p = 500;
//     int y = 200;
//     p = &y;
//     cout << "fun " << *p << endl;
// }

void fun(int* p){
    p = NULL;
}

int main()
{
    int x = 10;
    int *p = &x;
    fun(p);

    // cout << "main " << &p << endl;
    // cout << "main " << *p << endl;

    cout << "main " << *p << endl;
    return 0;
}