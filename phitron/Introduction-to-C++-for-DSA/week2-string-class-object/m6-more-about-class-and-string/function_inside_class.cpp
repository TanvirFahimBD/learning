#include <bits/stdc++.h>
using namespace std;

class Student
{
public:
    string name;
    int roll;
    int math;
    int eng;
    Student(string name, int roll, int math, int eng)
    {
        this->name = name;
        this->roll = roll;
        this->math = math;
        this->eng = eng;
    }

    // void hello()
    // {
    //     cout << "Hi " << this->name << " " << this->roll << endl;
    // }

    void total()
    {
        cout << "Total marks: " << this->name << " = " << this->math + this->eng << endl;
    }
};

int main()
{
    Student rakib("Rakib", 3, 60, 70);
    // cout << rakib.name << " " << rakib.roll << endl;
    // rakib.hello();
    rakib.total();
    Student sakib("Sakib", 10, 60, 50);
    // cout << sakib.name << " " << sakib.roll << endl;
    // sakib.hello();
    sakib.total();
    return 0;
}