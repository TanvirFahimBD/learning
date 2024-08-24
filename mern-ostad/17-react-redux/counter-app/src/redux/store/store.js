import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "../state/counterSlice";
import todoReducer from "../state/TodoSlice";

export default configureStore({
  reducer: {
    counter: counterReducer,
    todo: todoReducer,
  },
});
