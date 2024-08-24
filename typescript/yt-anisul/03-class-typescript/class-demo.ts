//! class - class has properties, constructor, method. class creates a blueprint. Object is created using class. Then call class methods, properties.
class User{
    userName: string;
    age: number;    
    constructor(userName: string, age: number) { 
        this.userName = userName;
        this.age = age;
    }

    display():void {
        console.log(`Your username: ${this.userName}`);
        console.log(`Your age: ${this.age}`);
    }
}

let user1 = new User('fahim', 23);
user1.display();