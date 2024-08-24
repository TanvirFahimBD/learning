//! 3-9: Conditional Types
/**
 * ? Conditional Types: a type is dependent on another type. generic is used to pass type. If a type is never during conditional type then it is removed during return
 */

/**
 * nested conditional type
 */
// type a1 = string;
// type a3 = undefined;
// type a4 = number;
// type a2 = a1 extends string ? string : null;
// type d = a1 extends null
//   ? null
//   : a3 extends number
//   ? number
//   : a4 extends null
//   ? null
//   : never;
// type Sheikh = {
//   wife1: string;
//   wife2: string;
// };

// type CheckProperty<T> = T extends "wife1" ? true : false;
// type CheckWife1 = CheckProperty<Sheikh>;

// type CheckProperty1<T> = T extends { wife1: string } ? true : false;
// type CheckWife2 = CheckProperty<Sheikh>;

/**
 * extends check
 */
// type Sheikh = {
//   wife1: string;
//   wife2: string;
// };
// type CheckProperty<X, Y> = Y extends X ? true : false;
// type CheckWife1 = CheckProperty<Sheikh, "wife1">;
// type CheckData = CheckProperty<Sheikh, "girlfriend">;

// type Bandhu = "fahim" | "tanvir" | "hossain";
// type RemoveBandu<T> = T extends "fahim" ? never : T;
// type CurrentBandu = RemoveBandu<Bandhu>;

// type RemoveBandu1<X, Y> = X extends Y ? never : X;
// type CurrentBandu2 = RemoveBandu1<Bandhu, "fahim">;
