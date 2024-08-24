//! union type - from given types any one type is allowed
// let userId: (string | number | boolean);
// userId = '324';
// userId = 324;
// userId = true;
// console.log(userId);

//! parameter as union type
function displayUserInfo(userId: string | number ) {
    console.log(userId);
}
displayUserInfo(123)
