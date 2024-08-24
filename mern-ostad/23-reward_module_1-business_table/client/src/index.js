import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./Assets/css/bootstrap.min.css";
import ReadPage from "./Pages/ReadPage";
import CreatePage from "./Pages/CreatePage";
import UpdatePage from "./Pages/UpdatePage";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from "react-toastify";

const router = createBrowserRouter([
  {
    path: "/",
    // render={(props) => <ReadPage {...props} key={Date.now()}/>},
    element: <ReadPage />,
  },
  {
    path: "/create",
    element: <CreatePage />,
  },
  {
    path: "/update/:id",
    element: <UpdatePage />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
    <ToastContainer />
  </React.StrictMode>
);

// TODO: disconnected  need to connect with backend
// "proxy": "http://localhost:5000"
