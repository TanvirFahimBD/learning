/**
 * Encapsulation - every class keep properties & methods inside that is Encapsulation
 * Access modifiers - others anyone access given or not. by default public, protected, private.
 * public - accessible & modifiable
 * readonly - accessible & but not modifiable
 * protected - inheritable but not accessible from child class
 * private - setter & getter is used to define the properties or method.
 */
class User{
    userName: string; //or public userName both same
    // readonly userName: string;
    // protected userName: string;
    public age: number;    
    constructor(userName: string, age: number) { 
        this.userName = userName;
        this.age = age;
    }
   display():void {
        console.log(`username: ${this.userName}, age: ${this.age}`);
    }
}
// const user1 = new User('fahim', 45);
// user1.display();

class Student extends User{
    private studentId: number;
    constructor(userName: string, age: number, studentId: number) { 
        super(userName, age);
    }    
    display():void {
        console.log(`username: ${this.userName}, age: ${this.age}, studentId: ${this.studentId}`);
    }
    setStudentId(studentId: number): void{
        this.studentId = studentId;
    }
    getStudentId(): number{
        return this.studentId ;
    }
}
const stu1 = new Student('fahim', 45, 0);
stu1.userName = 'tanvir';
// console.log(stu1.userName);
stu1.setStudentId(5683724782);
stu1.display();
console.log(stu1.getStudentId());
