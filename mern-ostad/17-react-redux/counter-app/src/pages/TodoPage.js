import React from "react";
import TodoCreate from "../components/TodoCreate";
import TodoList from "../components/TodoList";

const TodoPage = () => {
  return (
    <div className="container">
      <div className="row">
        <div className="col-12">
          <div className="card shadow-lg">
            <div className="card-header">
              <h1>My Todo App</h1>
            </div>
            <div className="card-body">
              <TodoCreate />
              <TodoList />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TodoPage;
