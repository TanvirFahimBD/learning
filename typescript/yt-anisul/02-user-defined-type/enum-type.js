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
var RequestType3;
(function (RequestType3) {
    RequestType3[RequestType3["idValue"] = 1] = "idValue";
    RequestType3["readData"] = "READ_DATA";
    RequestType3[RequestType3["rollNumber"] = 2] = "rollNumber";
    RequestType3["saveData"] = "SAVE_DATA";
})(RequestType3 || (RequestType3 = {}));
// console.log(RequestType3);
// console.log(RequestType3.idValue);
console.log(RequestType3['saveData']);
