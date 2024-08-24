"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.sub = exports.add = void 0;
//! 5_5 1: What is module ,different formats of module technique, import and export
const add = (param1, param2, param3) => {
    return param1 + param2 + param3;
};
exports.add = add;
const sub = (param1, param2) => {
    return param1 - param2;
};
exports.sub = sub;
