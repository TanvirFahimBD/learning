// import { add as addSum, sub, multiply } from "./1.module";
// import * as Method from "./1.module";
// import average from "./1.module";
// import AnyName, { add as Add, sub, multiply } from "./1.module";
// import AnyName from "./1.module";

// import addTwo from "./utils/add";
// import sub from "./utils/sub";
// import mult from "./utils/mult";
// import avg from "./utils/avg";

import methods from "./utils";

const add = (param1: number, param2: number, param3: number): number => {
  return param1 + param2 + param3;
};

console.log(methods.addTwo(34, 5));
console.log(methods.sub(34, 5));
console.log(methods.mult(34, 5));
