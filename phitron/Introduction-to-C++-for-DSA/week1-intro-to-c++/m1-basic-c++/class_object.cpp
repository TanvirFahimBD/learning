#include <bits/stdc++.h>
using namespace std;
// class Student
// {
// public:
//     char name[100];
//     int roll;
//     double gpa;
// };

//* value set
// int main()
// {
//     Student s;
//     char temp[100] = "Tanvir bro";
//     strcpy(s.name, temp);
//     s.roll = 12;
//     s.gpa = 3.5;

//     cout << s.name << " " << s.roll << " " << s.gpa << endl;
//     return 0;
// }

//* take input
// int main()
// {
//     Student s;
//     cin >> s.name;
//     cin >> s.roll;
//     cin >> s.gpa;

//     cout << s.name << " " << s.roll << " " << s.gpa << endl;
//     return 0;
// }

//* take input multiple string
// int main()
// {
//     Student s, s2;
//     cin.getline(s.name, 100);
//     cin >> s.roll >> s.gpa;
//     cin.ignore();
//     cin.getline(s2.name, 100);
//     cin >> s2.roll >> s2.gpa;

//     cout << s.name << " " << s.roll << " " << s.gpa << endl;
//     cout << s2.name << " " << s2.roll << " " << s2.gpa << endl;
//     return 0;
// }

class Student
{
public:
    int roll;
    int cls;
    double gpa;

    //* constructor
    // Student(int r, int c, double g)
    // {
    //     roll = r;
    //     cls = c;
    //     gpa = g;
    // }

    //* this and arrow sign
    Student(int roll, int cls, double gpa)
    {
        // this->roll = roll;
        // this->cls = cls;
        // this->gpa = gpa;

        // dereferencing
        (*this).roll = roll;
        (*this).cls = cls;
        (*this).gpa = gpa;
    }
};

// Student func()
// {
//     Student karim(11, 5, 3.5);
//     return karim;
// }

//* static object
// Student *func()
// {
//     Student karim(11, 5, 3.5);
//     Student *p = &karim;
//     return p;
// }

// dynamic object
Student *func()
{
    Student *karim = new Student(11, 5, 3.5);
    return karim;
}

int main()
{
    Student *s = func();
    cout << s->roll << " " << s->cls << " " << s->gpa << endl;
    return 0;
}