{
//nullable type
// const searchName = (value: string | null) => {
//     if(value){
//         console.log(`searching ${value}`);        
//     }else{
//         console.log('nothing to search');
//     }
// }
// searchName(null);

//unknown type
// const getSpeed = (value: unknown) => {    
//     if(typeof value === "number"){
//         const convertedSpeed = (value * 1000)/3600;
//         console.log(`Speed ${convertedSpeed} ms^-1`);        
//     }
//     else if(typeof value === "string"){
//         const [mainValue, unit] = value.split(' ');        
//         const convertedSpeed = (parseInt(mainValue) * 1000)/3600;
//         console.log(`Speed ${convertedSpeed} ms^-1`);
//     }else {
//         console.log('wrong input');
        
//     }
// }
// // getSpeed(10);
// // getSpeed(`100 kmh^-1`);
// getSpeed(null);

//never type
function throwError(msg: string):never{
    throw new Error(msg);
}
throwError('OMG error occured !!!');


}