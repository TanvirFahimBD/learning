import React, { useRef } from "react";
import { useDispatch } from "react-redux";
import { addTodo } from "../redux/state/TodoSlice";

const TodoCreate = () => {
  const dispatch = useDispatch();
  const todoInfo = useRef();
  return (
    <div className="container">
      <div className="row my-3">
        <div className="col-10">
          <input
            ref={todoInfo}
            type="text"
            className="w-100 form-control"
            placeholder="Enter Todo"
          />
        </div>
        <div className="col-2">
          <button
            className="btn btn-warning"
            onClick={() => dispatch(addTodo(todoInfo.current.value))}
          >
            Add Todo
          </button>
        </div>
      </div>
    </div>
  );
};

export default TodoCreate;
