import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import Login from "../page/login";
import Home from "../page/Home";
import NotFount from "../page/NotFount";

const routes = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/home",
    element: <Home />,
  },
  {
    path: "*",
    element: <NotFount />,
  },
]);

export default routes;
