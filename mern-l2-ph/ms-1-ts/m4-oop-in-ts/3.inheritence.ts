//! 4-3: Inheritance
/**
 * Inheritance: extends parent class. properties, constructor, methods then will be available in child class. Then super will be call for call parent class constructor call and new additional properties, methods need to declare in child class.
 */
// class Parent {
//   name: string;
//   age: number;
//   address: string;
//   constructor(name: string, age: number, address: string) {
//     this.name = name;
//     this.age = age;
//     this.address = address;
//   }
//   makeSleep(hours: number): string {
//     return `This ${this.name} will sleep for ${hours} hours`;
//   }
// }

// class Student extends Parent {
//   constructor(name: string, age: number, address: string) {
//     super(name, age, address);
//   }
// }

// class Teacher extends Parent {
//   designation: string;
//   constructor(name: string, age: number, address: string, designation: string) {
//     super(name, age, address);
//     this.designation = designation;
//   }
//   takeClasses(numberOfClass: number): string {
//     return `This ${this.name} will take ${numberOfClass} classes`;
//   }
// }

// const student1 = new Student("Mr. X", 34, "BD");
// console.log(student1.age);
// console.log(student1.makeSleep(4));

// const teacher1 = new Teacher("Mr. X", 34, "BD", "Teacher");
// console.log(teacher1.age);
// console.log(teacher1.makeSleep(6));
// console.log(teacher1.takeClasses(6));
