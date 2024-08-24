// //linear search
// let arr = [12, 43, 26, 74, 29, 41, 58, 91, 10];
// let target = 29;

// function linearSearch(arr, target) {
//   for (let i = 0; i < arr.length; i++) {
//     if (arr[i] === target) {
//       return "Data found at " + i;
//     }
//   }
//   return "Data not found";
// }

// console.log(linearSearch(arr, target));
// console.log(linearSearch(["red", "green", "blue", "black"], "Blue"));

// // 1 sec -> 10 lakh

// --------------------------------------

// //binary search
// let arr2 = [10, 20, 30, 40, 50, 60, 70, 80];
// function binarySearch(arr, target) {
//   let start = 0;
//   let end = arr.length - 1;
//   let mid;

//   while (start <= end) {
//     mid = Math.round((start + end) / 2);
//     if (arr[mid] === target) {
//       return "Data found at index " + mid;
//     } else if (arr[mid] < target) {
//       start = mid + 1;
//     } else {
//       end = mid - 1;
//     }
//   }
//   return 'data not found';
// }

// console.log(binarySearch(arr2, 30));
// console.log(binarySearch(['apple', 'banana','mango', 'orange'], 'mango'));

// --------------------------------------
// //order agnostic binary search
// let arr2 = [10, 20, 30, 40, 50, 60, 70, 80];
// function binarySearch(arr, target) {
//   let start = 0;
//   let end = arr.length - 1;
//   let mid;
//   let asc;

//   if (arr[start] < arr[end]) {
//     asc = true;
//   } else {
//     asc = false;
//   }

//   while (start <= end) {
//     mid = Math.round((start + end) / 2);
//     if (arr[mid] === target) {
//       return "Data found at index " + mid;
//     }
//     if (asc) {
//       if (arr[mid] < target) {
//         start = mid + 1;
//       } else {
//         end = mid - 1;
//       }
//     } else {
//       if (arr[mid] < target) {
//         end = mid - 1;
//       } else {
//         start = mid + 1;
//       }
//     }
//   }
//   return 'data not found';
// }

// console.log(binarySearch(arr2, 30));
// console.log(binarySearch([30, 25, 20, 15, 10], 25));

// // --------------------------------------
// // flooring ceiling
// let arr = [10, 20, 30, 40, 50, 60]
// // target = 45
// function floorCeil(arr, target) {
//   let start = 0;
//   let end = arr.length - 1;
//   let mid;

//   while (start <= end) {
//     mid = Math.round((start + end) / 2);
//     if (arr[mid] === target) {
//       return mid;
//     } else if (target > arr[mid]) {
//       start = mid + 1;
//     } else {
//       end = mid - 1;
//     }
//   }
//   return 'ceil: ' + arr[mid] + ' floor: ' + arr[mid-1];
// }

// console.log(floorCeil(arr, 35));

// --------------------------------------
// // flooring ceiling
// let arr = [10, 20, 30, 40, 50, 60, 70, 80, 90]
// function floorCeil(arr, target) {
//   let start = 0;
//   let end = arr.length - 1;
//   let mid;
//   let floor;

//   while (start <= end) {
//     mid = Math.round((start + end) / 2);
//     if (arr[mid] === target) {
//       mid = target;
//     } else if (target > arr[mid]) {
//       start = mid + 1;
//     } else {
//       end = mid - 1;
//     }
//   }

//   return 'floor: ' + arr[mid-1] + ', target: ' + target + ', ceil: ' + arr[mid];

// }

// console.log(floorCeil(arr, 54));

// --------------------------------------
// repeated digit number count in array 
let arr = [2, 5, 8, 8, 8, 8, 8, 9, 12, 12];

function digitCount(arr, target) {
  let start = 0;
  let end = arr.length - 1;
  let mid;
  let targetDigitPos = 0;
  let count = 0;

  while (start <= end) {
    mid = Math.round((start + end) / 2);
    if (arr[mid] === target) {
      targetDigitPos = mid;
      count++;
      break;
    } else if (target > arr[mid]) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }

  for (let i = start; i <= targetDigitPos-1; i++){
    if (arr[i] === target) {
      count++;
    }
  }

  for (let i = targetDigitPos+1; i <= arr.length-1; i++){
    if (arr[i] === target) {
      count++;
    }
  }

  return count;
}

console.log(digitCount(arr, 8));