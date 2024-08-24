//! 3-8: Asynchronous TypeScript
/**
 * ? Asynchronous TypeScript: define Promise type, Promise return type & function return type. interface or type alias as Promise type if no return then type will be void
 */
/**
 * Mocking: not getting data from server
 */
// Promise type writing way: Promise<string> | Promise<boolean> | Promise<object>;
// const makePromiseString = (): Promise<string> => {
//   return new Promise<string>((resolve, reject) => {
//     const data: string = "Data is fetched";
//     if (data) {
//       resolve(data);
//     } else {
//       reject("Failed to fetch data");
//     }
//   });
// };

// const getPromiseData = async (): Promise<void> => {
//   const data = await makePromiseString();
//   console.log(data);
// };
// getPromiseData();

/********************************************** */
// const makePromiseBoolean = (): Promise<boolean> => {
//   return new Promise<boolean>((resolve, reject) => {
//     const data: boolean = true;
//     if (data) {
//       resolve(data);
//     } else {
//       reject("Failed to fetch data");
//     }
//   });
// };

// const getPromiseDataBoolean = async (): Promise<void> => {
//   const data = await makePromiseBoolean();
//   console.log(data);
// };
// getPromiseDataBoolean();

/**
 * type alias or interface for object type
 */
// type DataType = {
//   data: string;
// };
// interface IDataType {
//   data: string;
// }

// const makePromiseObject = (): Promise<IDataType> => {
//   return new Promise<IDataType>((resolve, reject) => {
//     const data: IDataType = { data: "data is fetched" };
//     if (data) {
//       resolve(data);
//     } else {
//       reject("Failed to fetch data");
//     }
//   });
// };

// const getPromiseDataObject = async (): Promise<IDataType> => {
//   const data = await makePromiseObject();
//   return data;
// };
// console.log(getPromiseDataObject());

/**
 * fetch real data from api
 */
// interface IData {
//   userId: number;
//   id: number;
//   title: string;
//   completed: boolean;
// }
// const getTodo = async (): Promise<IData> => {
//   const response = await fetch("https://jsonplaceholder.typicode.com/todos/1");
//   return await response.json();
// };

// const getTodoData = async (): Promise<void> => {
//   const result = await getTodo();
//   console.log(result);
// };

// getTodoData();
