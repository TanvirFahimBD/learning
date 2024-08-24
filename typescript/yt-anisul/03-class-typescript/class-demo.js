//! class - class has properties, constructor, method. class creates a blueprint. Object is created using class. Then call class methods, properties.
var User = /** @class */ (function () {
    function User(userName, age) {
        this.userName = userName;
        this.age = age;
    }
    User.prototype.display = function () {
        console.log("Your username: ".concat(this.userName));
        console.log("Your age: ".concat(this.age));
    };
    return User;
}());
var user1 = new User('fahim', 23);
user1.display();
