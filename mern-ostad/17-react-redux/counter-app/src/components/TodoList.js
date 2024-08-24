import React from "react";
import { useSelector } from "react-redux";
import { alertDelete } from "./alertDelete";
import { alertEdit } from "./alertEdit";

const TodoList = () => {
  const allTodo = useSelector((state) => state.todo.value);
  return (
    <div className="container">
      <div className="row my-5">
        <div className="col-12">
          <table className="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Todo</th>
                <th scope="col">Edit</th>
                <th scope="col">Remove</th>
              </tr>
            </thead>
            <tbody>
              {allTodo.length > 0 ? (
                allTodo.map((item, i) => (
                  <tr key={i.toString()}>
                    <th scope="row">{i}</th>
                    <td>{item}</td>
                    <td>
                      <button
                        className="btn btn-secondary"
                        onClick={() => alertEdit(i, item)}
                      >
                        Edit
                      </button>
                    </td>
                    <td>
                      <button
                        className="btn btn-danger"
                        onClick={() => alertDelete(i)}
                      >
                        Remove
                      </button>
                    </td>
                  </tr>
                ))
              ) : (
                <tr></tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default TodoList;
