/**
 *  function signature -declare function return type before define function body & call function
 */
var userInfo1;
userInfo1 = function () {
    console.log('Tanvir bro');
};
userInfo1();
var userInfo2;
userInfo2 = function (name) {
    return name;
};
console.log(userInfo2('Fahim bro'));
var userInfo3;
userInfo3 = function (name, age) {
    return "".concat(name, " age is ").concat(age);
};
console.log(userInfo3('Both bro', 23));
