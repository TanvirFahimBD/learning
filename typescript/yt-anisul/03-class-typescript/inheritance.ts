//! Inheritance - inherit another class property, constructor, method.
//! here User is parent class
class User{
    userNameabstraction: string;
    age: number;    
    constructor(userName: string, age: number) { 
        this.userName = userName;
        this.age = age;
    }
    display():void {
        console.log(`username: ${this.userName}, age: ${this.age}`);
    }
}
let user1 = new User('fahim', 23);
user1.display()

//! here Student is child class. New properties need to declare. constructor takes new properties. Parent class constructor called by super method properties pass & call. new properties declared also into child class constructor. now all properties is accessible. 
class Student extends User{
    studentId: number;
    constructor(userName: string, age: number, studentId: number) { 
        super(userName, age);
        this.studentId = studentId;
    }
    display():void {
        console.log(`username: ${this.userName}, age: ${this.age}, studentId: ${this.studentId}`);
    }
}
let student1 = new Student('fahim', 23, 34224234);
student1.display()