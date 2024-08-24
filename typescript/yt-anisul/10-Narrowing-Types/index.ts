/**
 * Narrowing Types - check type by union type
 */
// function printToDos(toDos: string[] | null) {
//     if (toDos) {
//          toDos.map((todo) => console.log(todo))
//    }
//     else {
//         console.log('no toDos')
//    }
// }

// const toDos = ["todo1", "todo2", "todo3", "todo4"]
// printToDos(toDos)
//  printToDos(null)

let firstName: string;
let lastName: typeof firstName;
lastName = '343';
console.log(lastName);