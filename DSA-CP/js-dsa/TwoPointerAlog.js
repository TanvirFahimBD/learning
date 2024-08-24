//Two Pointer Algorithm
// T.C. - O(n)
// S.C. - O(1)
// let arr = [5, 4, 9, 2, 8, 1, 0, 12, 7];
// let start = 0;
// let end = arr.length;
// let mid;
// //mid count
// mid = Math.floor((start + end) / 2);
// let i = 0;
// //i mid reach break
// while (i < mid) {
//     tempFront = arr[i];
//     tempBack = arr[arr.length - i - 1];
//     temp = arr[i];
//     arr[i] = tempBack;
//     arr[arr.length - i - 1] = temp;
//     i++;
// }
// console.log(arr);

//another approach
// let numbers = [10, 20, 30, 40, 50];
// let size = numbers.length - 1;
// let temp;
// console.log('before', numbers);
// for (let i = 0, k = size; i < k; i++, k--){
//     temp = numbers[i];
//     numbers[i] = numbers[k];
//     numbers[k] = temp;
// }
// console.log('after', numbers);

//Palindrom
// function isPalindrome(str) {
//     let i = 0;
//     let k = str.length - 1;
//     while (i < k) {
//         if (str[i] !== str[k]) {
//             return false;
//         }
//         i++;
//         k--;
//     }
//     return true;
// }

// console.log(isPalindrome('madam'));
// console.log(isPalindrome('raceacar'));
// console.log(isPalindrome('wow'));
// console.log(isPalindrome('mom'));
// console.log(isPalindrome('dad'));
// console.log(isPalindrome('Fahim'));

//Combine 2 sorted array in a single array
// let arr1 = [5, 10, 15, 20, 25, 30];
// let arr2 = [15, 23, 25, 30, 35];
// let i = 0;
// let j = 0;
// let newArr = [];

// //single loop condition
// while (true) {
//     // console.log(i);
//     // console.log(j);
    
//     //less than another push one
//     if (arr1[i] < arr2[j]) {
//         // console.log(arr1[i]);

//         newArr.push(arr1[i]);
//         i++;
//     }
    
//     //less than another push one
//     else if (arr1[i] > arr2[j]) {
//         // console.log(arr1[i]);
//         // console.log(arr2[j]);

//         newArr.push(arr2[j]);
//         j++;
//     }

//     //equal push both
//     else if (arr1[i] === arr2[j]) {
//         // console.log(arr1[i]);
//         // console.log(arr2[j]);

//         newArr.push(arr1[i]);
//         newArr.push(arr2[j]);
//         i++;
//         j++;
//     }
//     else {
//         i++;
//     }

//     //if one array end break
//     if (i > arr1.length) {
//         // console.log(i);
//         // console.log(arr1.length);

//         break;
//     }
    
// }

// //after end one loop from another remain to end push
// while (j <= arr2.length - 1) {
//     newArr.push(arr2[j]);
//     j++;
// }

// console.log(newArr); //5, 10, 15, 15, 20, 23, 25, 25, 30, 30, 35
