//! 2-8: Union, Intersection and Enum Types
/**
 * ? intersection type: this or that. any of these will be good to go
 * ? union type: combine type
 * ? enum type: alternative of string but not recommended
 */
// type NoobDev = {
//   name: string;
// };

// type JuniorDev = NoobDev & {
//   expertise: string;
//   experience: number;
// };

// const newDev: NoobDev | JuniorDev = {
//   name: "fahim",
//   experience: 1,
// };
// console.log(newDev);

/**
 * enum type: alternative of string but not recommended
 */
// type NoobDev = {
//   name: string;
// };

// type JuniorDev = NoobDev & {
//   expertise: string;
//   experience: number;
// };

// enum Level {
//   junior = "junior",
//   mid = "mid",
//   senior = "senior",
// }

// type NextLvlDev = JuniorDev & {
//   leadershipExperience: number;
//   level: "junior" | "mid" | "senior";
//   // level: Level
// };

// const nextDev: NextLvlDev = {
//   name: "fahim",
//   expertise: "js",
//   experience: 3,
//   leadershipExperience: 3,
// level: Level.mid
//   level: "junior",
// };
// console.log(nextDev);
