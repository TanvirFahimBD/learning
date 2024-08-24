/**
 * 1. abstraction - hides the implementation of something.
 * 2. class declared with abstract keyword
 *!3. object cannot be created from abstract class
 *!4. abstract method will not have any body
 *!5. children class which inherited abstract class must inherit abstract methods
 */
abstract class User{
    userName: string;
    age: number;    
    constructor(userName: string, age: number) { 
        this.userName = userName;
        this.age = age;
    }
    abstract display(): void;
}

class Student extends User{
    studentId: number;
    constructor(userName: string, age: number, studentId: number) { 
        super(userName, age);
        this.studentId = studentId;
    }    
    display():void {
        console.log(`username: ${this.userName}, age: ${this.age}, studentId: ${this.studentId}`);
        console.log(` age: ${this.age} `);
        console.log(` studentId: ${this.studentId}`);
    }
}
