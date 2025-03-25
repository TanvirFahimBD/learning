#include <bits/stdc++.h>
using namespace std;

class Cricketer
{
public:
    string country;
    int jersery;
    Cricketer(string country, int jersery)
    {
        this->country = country;
        this->jersery = jersery;
    }
};

int main()
{
    Cricketer *sakib = new Cricketer("BD1", 10);
    Cricketer *miraj = new Cricketer("BD", 50);
    // miraj = sakib;

    // miraj->country = sakib->country;
    // miraj->jersery = sakib->jersery;

    *miraj = *sakib;
    delete sakib;
    // cout << sakib->country << " " << sakib->jersery << endl;
    cout << miraj->country << " " << miraj->jersery << endl;
    return 0;
}