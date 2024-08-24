/**
 * Generics basics - Can work with any type of variable. <Type> is used in generic function parameter before & also after parameter type check
 */
const printUserInfo = <X, Y>(userId: X, userAge: Y) => {
    console.log(`user Id ${userId} , user Age ${userAge}`);
}

// printUserInfo("4232", 45);
// printUserInfo(4232, 45);
printUserInfo(true, 45);