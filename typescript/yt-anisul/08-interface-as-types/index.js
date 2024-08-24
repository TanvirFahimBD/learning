var users = [];
var user1 = {
    id: 1,
    name: 'fahim',
    age: 18,
};
var user2 = {
    id: 2,
    name: 'hossain',
    age: 28,
};
users.push(user1);
users.push(user2);
var printUserInfo = function (user) {
    console.log("".concat(user.name, " all info"), user);
};
users.forEach(function (user) { return printUserInfo(user); });
