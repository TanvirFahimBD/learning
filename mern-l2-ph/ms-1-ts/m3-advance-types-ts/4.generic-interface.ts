//! 3-4: Generic in Interface
/**
 * ? Generic Interface: interface apply by generic type. Generic property can be optional but parameter can't be optional either null, undefined or null, undefined as default value. If object is passed as generic then the property declaration will be as object
 */
// type GenericTuple1<X, Y> = [X, Y];
// interface IRelationWithSalaryType {
//   name: string;
//   salary: number;
// }
// const relationWithSalaryType: GenericTuple1<IRelationWithSalaryType, string> = [
//   { name: "tanvir", salary: 1000 },
//   "fahim",
// ];
// console.log(relationWithSalaryType);

/**
 * generic interface with optional type
 */
// interface CrushInterface<T, U = null> {
//   name: string;
//   husband: T;
//   wife?: U;
// }

// interface IHusbandInterface {
//   name: string;
//   salary: number;
// }

// const crush1: CrushInterface<boolean, null> = { name: "fahim", husband: false };
// console.log(crush1);

// const crush2: CrushInterface<string, undefined> = {
//   name: "fahim1",
//   husband: "fahim",
// };
// console.log(crush2);

// const crush3: CrushInterface<IHusbandInterface> = {
//   name: "fahim2",
//   husband: { name: "fah", salary: 4444 },
// };
// console.log(crush3);
