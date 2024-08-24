import Swal from "sweetalert2";
import { deleteTodo } from "../redux/state/TodoSlice";
import store from "../redux/store/store";

export function alertDelete(index) {
  Swal.fire({
    title: "Are you sure?",
    text: "You won't be able to revert this!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Yes, delete it!",
  }).then((result) => {
    if (result.isConfirmed) {
      console.log(index);
      store.dispatch(deleteTodo(index));
    }
  });
}
