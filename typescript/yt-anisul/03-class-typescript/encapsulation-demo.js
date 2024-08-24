var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
/**
 * Encapsulation - every class keep properties & methods inside that is Encapsulation
 * Access modifiers - others anyone access given or not. by default public, protected, private.
 * public - accessible & modifiable
 * readonly - accessible & but not modifiable
 * protected - inheritable but not accessible from child class
 * private - setter & getter is used to define the properties or method.
 */
var User = /** @class */ (function () {
    function User(userName, age) {
        this.userName = userName;
        this.age = age;
    }
    User.prototype.display = function () {
        console.log("username: ".concat(this.userName, ", age: ").concat(this.age));
    };
    return User;
}());
// const user1 = new User('fahim', 45);
// user1.display();
var Student = /** @class */ (function (_super) {
    __extends(Student, _super);
    function Student(userName, age, studentId) {
        return _super.call(this, userName, age) || this;
    }
    Student.prototype.display = function () {
        console.log("username: ".concat(this.userName, ", age: ").concat(this.age, ", studentId: ").concat(this.studentId));
    };
    Student.prototype.setStudentId = function (studentId) {
        this.studentId = studentId;
    };
    Student.prototype.getStudentId = function () {
        return this.studentId;
    };
    return Student;
}(User));
var stu1 = new Student('fahim', 45, 0);
stu1.userName = 'tanvir';
// console.log(stu1.userName);
stu1.setStudentId(5683724782);
stu1.display();
console.log(stu1.getStudentId());
