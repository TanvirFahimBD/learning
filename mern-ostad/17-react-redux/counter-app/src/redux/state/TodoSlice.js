import { createSlice } from "@reduxjs/toolkit";

export const todoSlice = createSlice({
  name: "todo",
  initialState: {
    value: [],
  },
  reducers: {
    addTodo: (state, action) => {
      state.value.push(action.payload);
    },
    editTodo: (state, action) => {
      state.value.splice(
        action.payload["index"],
        1,
        action.payload["updatedTodo"]
      );
    },
    deleteTodo: (state, action) => {
      state.value.splice(action.payload, 1);
    },
  },
});

export const { addTodo, editTodo, deleteTodo } = todoSlice.actions;
export default todoSlice.reducer;
