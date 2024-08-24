/**
 * Generics basics - Can work with any type of variable. <Type> is used in generic function parameter before & also after parameter type check
 */
var printUserInfo = function (userId, userAge) {
    console.log("user Id ".concat(userId, " , user Age ").concat(userAge));
};
// printUserInfo("4232", 45);
// printUserInfo(4232, 45);
printUserInfo(true, 45);
