import Swal from "sweetalert2";
import { editTodo } from "../redux/state/TodoSlice";
import store from "../redux/store/store";

export async function alertEdit(index, item) {
  Swal.fire({
    title: "Update task name",
    input: "text",
    inputValue: item,
    inputValidator: (updatedTodo) => {
      if (updatedTodo) {
        store.dispatch(editTodo({ index, updatedTodo }));
      } else {
        return "You need to write something!";
      }
    },
  });
}
