//! enum - store constants; duplicate value is not allowed here. enum types : numeric, string, heterogeneous

//! numeric enum - value general start from 0 & increase. but if set the after that value increase next others
// enum RequestType {
//     getData=1,
//     readData=3,
//     deleteData
// }
// console.log(RequestType);
// console.log(RequestType.readData);

//! string enum - set value of string enum each value
// enum RequestType2 {
//     getData = "GET_DATA",
//     readData = "READ_DATA",
//     deleteData = "DELETE_DATA",
//     saveData = "SAVE_DATA"
// }
// console.log(RequestType2);
// console.log(RequestType2.getData);
// console.log(RequestType2['saveData']);
 
//! heterogeneous enum - combine different data
enum RequestType3 {
    idValue = 1,
    readData = "READ_DATA",
    rollNumber = 2,
    saveData = "SAVE_DATA"
}
// console.log(RequestType3);
// console.log(RequestType3.idValue);
console.log(RequestType3['saveData']);